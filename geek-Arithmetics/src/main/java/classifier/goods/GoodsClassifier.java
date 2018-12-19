package classifier.goods;

import java.util.HashMap;
import java.util.Map;

import classifier.AttributeValue;
import classifier.NaiveBayes;
import classifier.goods.data.Goods;
import classifier.goods.data.GoodsDataSet;
import classifier.itf.Attribute;
import classifier.itf.Concept;
import classifier.itf.Instance;
import classifier.util.TermCoefficient;

public class GoodsClassifier extends NaiveBayes {

	private GoodsDataSet goodsDataSet;
	private int topNTerms;
	private boolean verbose;
    private double jaccardThreshold=0.25;
    
    public GoodsClassifier(GoodsDataSet dataSet, int topN) {
    	super("", dataSet.getTrainingSet(topN));
    	goodsDataSet = dataSet;
    	topNTerms = topN;
    }
    
    @Override
    public boolean train() {
    	
    	if(goodsDataSet.getSize() <= 0) {
    		System.out.println("Can not train this classifier as the training dataset is empty.");
    		return false;
    	}
    	
    	for(String attrName : getTSet().getAttributeNameSet()) {
    		trainOnAttribute(attrName);
    	}
    	
    	return super.train();
    }
    
    @Override
    protected void calculateConditionalProbabilities() {
		p = new HashMap<Concept, Map<Attribute,AttributeValue>>();
		int c = 0;
		for( Instance i : tSet.getInstanceSet().values() ) {

			Map<Attribute, AttributeValue> aMap = p.get(i.getConcept());
			
			for( Attribute attr : i.getAttributes() ) {
				if( aMap == null ) {
					aMap = new HashMap<Attribute, AttributeValue>();
					p.put(i.getConcept(), aMap);
				}
				
				AttributeValue bestValue = findBestAttributeValue(aMap, attr);
				if( bestValue == null ) {
					c ++;
					AttributeValue newAttrValue = new AttributeValue(attr.getValue());
					aMap.put(attr, newAttrValue);
				} else {
					bestValue.count();
				}
			}
		}
		System.out.println("new attribute " + c);
    }
    @Override
    public double getProbability(Instance i, Concept c) {
    	double cp = 1;

		Map<Attribute, AttributeValue> aMap = p.get(c);
		double instanceNumber = conceptProirs.get(c);
		
    	for( Attribute attr : i.getAttributes() ) {
    		if(attr != null && attributeList.contains(attr.getName())) {
    			
    			AttributeValue bestAttrValue = findBestAttributeValue(aMap, attr);
    			if( bestAttrValue == null ) {
    				//如果没有符合的属性值，则把该属性的概率设置为平摊
    				cp *= ((double) 1 / (tSet.getSize() + 1));
    			} else {
        			double r = 1;
//        			r = new GoodsInterfere().helpInterfere(bestAttrValue, c);
        			/*
        			 * 该分类下，当前属性值出现的次数/总实体数量
        			 */
    				cp *= (bestAttrValue.getCount() / instanceNumber) * r;
    			}
    		}
    	}
    	cp = cp == 1 ? (double) cp / tSet.getNumberOfConcepts() : cp;
    	
    	return cp;
    }

	public double getProbability(Instance i) {
		return 1;
	}
	
    @Override
    public Concept classify(Instance instance) {
    	return super.classify(instance);
    }
    
    public String classify(Goods g) {
    	GoodsInstance i = goodsDataSet.toGoodsInstance(g, topNTerms);
    	Concept c = classify(i);
    	if( verbose ) {
            System.out.println("Classified " + g.getGoodsSn() + " as " + c.getName());
    	}
    	if(c == null) {
    		return "";
    	}
    	return c.getName();
    }
    
    /**
     * 从aMap中寻找与a相似度满足一个阀值且最相似的属性值
     * @param aMap 某个concept里面对应的<属性, 属性值>关系
     * @param a 某个instance具有的属性信息
     * @return
     */
    public AttributeValue findBestAttributeValue(Map<Attribute, AttributeValue> aMap, Attribute a) {
    	TermCoefficient termCoefficient = new TermCoefficient();
    	
    	String aValue = a.getValue().toString();
    	String[] terms = aValue.split(" ");
        Attribute bestMatch = null;
        double bestSim = 0.0;
        
        for(Attribute attr : aMap.keySet()) {
        	String value = attr.getValue().toString();
        	String[] terms1 = value.split(" ");
        	double sim = termCoefficient.similarity(terms, terms1);
        	if(sim > jaccardThreshold && sim > bestSim) {
        		bestMatch = attr;
        		bestSim = sim;
        	}
        }
        
        return aMap.get(bestMatch);
    }

	public double getJaccardThreshold() {
		return jaccardThreshold;
	}

	public void setJaccardThreshold(double jaccardThreshold) {
		this.jaccardThreshold = jaccardThreshold;
	}
}
