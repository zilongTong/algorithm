package classifier;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

import classifier.itf.Attribute;
import classifier.itf.Concept;
import classifier.itf.Instance;

/**
 * 分类器的训练集
 * @author HQ01U8435
 *
 */
public class TrainingSet implements Serializable {
	private static final long serialVersionUID = -7220389622698306870L;
	
	/**
	 * 是否显示细节信息
	 */
	private boolean verbose = false;
	/**
	 * 实例集
	 */
	private HashMap<Integer, Instance> instanceSet;
	/**
	 * 概念集
	 */
	private HashSet<Concept> conceptSet;
	/**
	 * 属性集
	 */
	private HashSet<String> attributeNameSet;
	
	public TrainingSet() {
		instanceSet = new HashMap<Integer, Instance>();
	}

	public TrainingSet(Instance[] instances) {
		instanceSet = new HashMap<Integer,Instance>();
		conceptSet  = new HashSet<Concept>();
		attributeNameSet = new HashSet<String>();
		
		Concept c ;
		int length = instances.length;
		//遍历所有的实例，放置到实例集合中，同时将该实例所属的概念放到概念集中
		for(int instanceId = 0; instanceId < length; instanceId ++ ) {
			Instance i = instances[instanceId];
			instanceSet.put(instanceId, i);
			
			c = i.getConcept();
			if(!conceptSet.contains(c)) {
				conceptSet.add(c);
			}
			//保存属性名称
			for(Attribute a : i.getAttributes()) {
				if(a != null) {
					attributeNameSet.add(a.getName());
				}
			}
		}

		if (verbose) {
			System.out.println("-------------------------------------------------------------");
			System.out.print("Loaded "+getSize()+" instances that belong into ");
			System.out.println(this.getNumberOfConcepts()+" concepts");
			System.out.println("-------------------------------------------------------------");			
		}
	}
	

	public int getSize() {
		return instanceSet.size();
	}
	public int getNumberOfConcepts() {
		return conceptSet.size();
	}
	public HashMap<Integer, Instance> getInstanceSet() {
		return instanceSet;
	}
	public void setInstanceSet(HashMap<Integer, Instance> instanceSet) {
		this.instanceSet = instanceSet;
	}
	public HashSet<Concept> getConceptSet() {
		return conceptSet;
	}
	public void setConceptSet(HashSet<Concept> conceptSet) {
		this.conceptSet = conceptSet;
	}
	public HashSet<String> getAttributeNameSet() {
		return attributeNameSet;
	}
	public void setAttributeNameSet(HashSet<String> attributeNameSet) {
		this.attributeNameSet = attributeNameSet;
	}
}
