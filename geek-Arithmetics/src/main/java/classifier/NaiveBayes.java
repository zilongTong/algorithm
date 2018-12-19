package classifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import classifier.itf.Attribute;
import classifier.itf.Concept;
import classifier.itf.IClassifier;
import classifier.itf.Instance;
/**
 * 朴素贝叶斯分类算法
 * @author HQ01U8435
 * 贝叶斯分类器的分类原理是通过某对象的先验概率，<br />
 * 利用贝叶斯公式计算出其后验概率，<br />
 * 即该对象属于某一类的概率，选择具有最大后验概率的类作为该对象所属的类。
 */
public class NaiveBayes implements IClassifier {
	/**
	 * 分类器标识符
	 */
	private String name;
	/**
	 * 分类器训练数据集
	 */
	protected TrainingSet tSet;
	/**
	 * 每个概念中所拥有的实例数量
	 */
	protected Map<Concept, Double> conceptProirs;
	
	/**
	 * 记录每个概念中，每个属性的每个值的次数
	 */
	protected Map<Concept,Map<Attribute, AttributeValue>> p;
	
	protected List<String> attributeList;

	protected boolean verbose = false;
	
	/**
	 * 分类器的构造函数
	 * @param name
	 * @param tSet
	 */
	public NaiveBayes(String name, TrainingSet tSet) {
		this.name = name;
		this.tSet = tSet;
		
		conceptProirs = new HashMap<Concept, Double>(tSet.getNumberOfConcepts());
		verbose = false;
	}
	
	public Concept classify(Instance instance) {
		Concept bestConcept = null;
		double bestP = 0.0;
		
		if( tSet == null || tSet.getConceptSet().size() < 1 ) {
			throw new RuntimeException("You have to train it first. Please run the method [train()]!");
		}
	    if( verbose ) {
	        System.out.println("\n*** Classifying instance: " + instance.toString() + "\n");
	    }
		for(Concept c : tSet.getConceptSet()) {
			double p = getProbability(c, instance);
	        if( verbose ) {
	            System.out.printf("P(%s|%s) = %.15f\n", c.getName(), instance.toString(), p);
	        }
	        if( p >= bestP) {
	            bestConcept = c;
	            bestP = p;
	        }
		}
		return bestConcept;
	}

	public boolean train() {
		long b = System.currentTimeMillis();
		
		boolean hasTrained = false;
		if( attributeList == null || attributeList.size() < 1) {
			System.out.print("Can't train the classifier without specifying the attributes for training!");
			System.out.print("Use the method --> trainOnAttribute(Attribute a)");
		} else {
			calculateConceptPriors();
			calculateConditionalProbabilities();
			hasTrained = true;
		}

		if (verbose) {
			System.out.print("       Naive Bayes training completed in ");
	        System.out.println((System.currentTimeMillis() - b) + " (ms)");
		}
		
		return hasTrained;
	}
	
	public void trainOnAttribute(String attrName) {
		if(attributeList == null) {
			attributeList = new ArrayList<String>();
		}
		attributeList.add(attrName);
	}
	
	/**
	 * 计算某个实例属于某个概念的概率（后验概率）
	 * @param c
	 * @param i
	 * @return
	 */
	public double getProbability(Concept c, Instance i) {
		double cP = 0.0;
		if( tSet.getConceptSet().contains(c) ) {
			cP = (getProbability(i, c) * getProbability(c)) / getProbability(i);
		} else {
			cP = 1 / (tSet.getNumberOfConcepts() + 1.0);
		}
		return cP;
	}
	
	/**
	 * 实例出现的概率，对所有概念来说，该值是常数，不影响结果排序 <br />
	 * 返回 1 ，能提高分类效率
	 * @param i 实例
	 * @return
	 */
	public double getProbability(Instance i) {
		double cP = 0;
		
		for(Concept c : tSet.getConceptSet()) {
			cP += getProbability(i, c) * getProbability(c);
		}
		
		cP = cP == 0 ? (double) 1 / tSet.getSize() : cP;
		
		return cP;
	}
	
	/**
	 * 给定一个概念，属于这个概念的已有实例数占总实例数的比例
	 * @param c
	 * @return
	 */
	public double getProbability(Concept c) {
		Double InstanceCount = conceptProirs.get(c);
		
		return InstanceCount == null ? 0.0 : InstanceCount / tSet.getSize();
	}
	/**
	 * 先验概率
	 * @param i
	 * @param c
	 * @return
	 */
	public double getProbability(Instance i, Concept c) {
		double cP = 1;
		double instanceNumber = conceptProirs.get(c);
		//遍历实例中所有的属性
		for(Attribute a : i.getAttributes()) {
			//获得某个概念对应的属性关系
			Map<Attribute, AttributeValue> attrMap = p.get(c);
			AttributeValue attrValue = attrMap.get(a);
			
			if( attrValue == null ) {
				cP *= (double) 1 / (tSet.getSize() + 1);
			} else {
				//该属性值出现的次数（也就是该概念中有多少实例出了该属性值）  除以  该概念对应的实例数
				//即，某个实例中出现某个属性值，属于该概念的概率
				cP *= (attrValue.getCount() / instanceNumber);
			}
		}
		
		cP = cP == 1 ? (double) 1 / tSet.getNumberOfConcepts() : cP;
		
		return cP;
	}
	/**
	 * 计算每个概念拥有的实例的数量
	 */
	private void calculateConceptPriors() {
		long begin = System.currentTimeMillis();
		
//		for(Concept c : tSet.getConceptSet()) {
//			int totalConceptCount = 0;
//			
//			for(Instance i : tSet.getInstanceSet().values()) {
//				if(i.getConcept().equals(c)) {
//					totalConceptCount ++;
//				}
//			}
//			
//			conceptProirs.put(c, new Double(totalConceptCount));
//		}
		
		for(Instance i : tSet.getInstanceSet().values()) {
			Concept c = i.getConcept();
			Double count = conceptProirs.get(c.getName());
			if(count == null) {
				conceptProirs.put(c, 1D);
			} else {
				conceptProirs.put(c, count + 1);
			}
		}
		
		System.out.println("calculate concept priors cost "+(System.currentTimeMillis() - begin));
	}
	/**
	 * 生成CPT（条件概率表）Conditional Probabilities Table
	 */
	protected void calculateConditionalProbabilities() {
		p = new HashMap<Concept, Map<Attribute,AttributeValue>>();
		
		//依次读取训练集中的实例信息，对分类器进行训练
		for(Instance i : tSet.getInstanceSet().values()) {
			//分析实例包含的属性
			for(Attribute a : i.getAttributes()) {
				
				//如果属性不为null，而且是分类器所认可的属性
				if(a != null && attributeList.contains(a.getName())) {
					
					//根据实例的概念，取得属性和属性值映射关系
					Map<Attribute, AttributeValue> aMap = p.get(i.getConcept());
					if( aMap == null ) {
						aMap = new HashMap<Attribute, AttributeValue>();
					}
					
					AttributeValue attrValue = aMap.get(a);
					if( attrValue == null ) {
						attrValue = new AttributeValue(a.getValue());
						aMap.put(a, attrValue);
					} else {
						attrValue.count();
					}
				}
			}
		}
	}
	
	public String getName() {
		return name;
	}

	public TrainingSet getTSet() {
		return tSet;
	}

	public void setTSet(TrainingSet set) {
		tSet = set;
	}
	
	public void showConcepts() {
		if(conceptProirs != null) {
			for(Map.Entry<Concept, Double> c : conceptProirs.entrySet()) {
				System.out.println(c.getKey() + "\t" + c.getValue());
			}
		}
	}

	public boolean isVerbose() {
		return verbose;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}
}
