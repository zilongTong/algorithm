package classifier.core;

import java.util.ArrayList;
import java.util.List;

import classifier.itf.Concept;
import classifier.itf.Instance;

public class BaseConcept implements Concept {
	private String name;
	private BaseConcept parent;
	private List<Instance> instances = new ArrayList<Instance>();

	public BaseConcept(String name) {
		this.name = name;
	}
	public BaseConcept(String name, BaseConcept parent) {
		this.name = name;
		this.parent = parent;
	}

	public synchronized void addInstance(Instance instance) {
		instances.add(instance);
	}
	
	public Instance[] getInstances() {

		return instances.toArray(new Instance[instances.size()]);
	}

	public String getName() {
		return name;
	}

	public Concept getParent() {
		return parent;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		final BaseConcept baseConcept = (BaseConcept) obj;
		if( this == obj ) {
			return true;
		}
		if( !(obj instanceof BaseConcept) ) {
			return false;
		}
		if( name == null) {
			if( baseConcept.name != null) {
				return false;
			}
		} else if( !name.equalsIgnoreCase(baseConcept.name)) {
			return false;
		}
		if( parent == null) {
			if( baseConcept.parent != null ) {
				return false;
			}
		} else if( !parent.equals(baseConcept.parent)) {
			return false;
		}
		return true;
	}

	public String toString() {
		return name;
	}
}
