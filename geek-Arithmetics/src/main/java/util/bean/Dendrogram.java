package util.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import util.ClusterSet;


public class Dendrogram {

	private Map<Integer, ClusterSet> _entryMap;
	private Map<Integer, String> _levelLabels;
	private Integer _nextLevel;
	private String _levelLabelName;

	public Dendrogram(String levelLabelName) {
		_entryMap = new LinkedHashMap<Integer, ClusterSet>();
		_levelLabels = new LinkedHashMap<Integer, String>();
		_nextLevel = 1;
		_levelLabelName = levelLabelName;
	}
	
	public int addLevel(String label, Cluster cluster) {
		List<Cluster> values = new ArrayList<Cluster>();
		values.add(cluster);
		return addLevel(label, values);
	}
	
	public int addLevel(String label, Collection<Cluster> clusters) {
		ClusterSet clusterSet = new ClusterSet();
		
		for(Cluster c : clusters) {
			clusterSet.add(c.copy());
		}
		int level = _nextLevel;
		_entryMap.put(level, clusterSet);
		_levelLabels.put(level, label);
		_nextLevel ++;
		return level;
	}
	
	public void setLevel(int level, String label, Collection<Cluster> clusters) {
		ClusterSet clusterSet = new ClusterSet();
		for(Cluster c : clusters) {
			clusterSet.add(c.copy());
		}
		System.out.println("Setting cluster level : " + level);
		_entryMap.put(level, clusterSet);
		_levelLabels.put(level, label);
		if(level >= _nextLevel) {
			_nextLevel = level + 1;
		}
	}
	
    public void printAll() {
        for(Map.Entry<Integer, ClusterSet> e : _entryMap.entrySet()) {
            Integer level = e.getKey();
            print(level);
        }
    }
    
    public void print(int level) {
        String label = _levelLabels.get(level);
        if(label == null) {
        	System.out.println("data on level " + level + " is null.");
        	return;
        }
        ClusterSet clusters = _entryMap.get(level);
        System.out.println("Clusters for: level=" + level + ", " + 
                _levelLabelName + "=" + label);
        for(Cluster c : clusters.getAllClusters()) {
        	if (c.getElements().size() > 0) {
        	System.out.println("____________________________________________________________\n");
            System.out.println(c.getElementsAsString());
        	System.out.println("____________________________________________________________\n\n");
        	}
        }
    }
    
    public int getTopLevel() {
        return _nextLevel - 1;
    }
    
    public List<Integer> getAllLevels() {
        return new ArrayList<Integer>(_entryMap.keySet());
    }
    
    public String getLabelForLevel(int level) {
        return _levelLabels.get(level);
    }
    
    public List<Cluster> getClustersForLevel(int level) {
        ClusterSet cs = _entryMap.get(level);
        return cs.getAllClusters();
    }
	
	public Map<Integer, ClusterSet> get_entryMap() {
		return _entryMap;
	}
	public void set_entryMap(Map<Integer, ClusterSet> map) {
		_entryMap = map;
	}
	public Map<Integer, String> get_levelLabels() {
		return _levelLabels;
	}
	public void set_levelLabels(Map<Integer, String> labels) {
		_levelLabels = labels;
	}
	public Integer get_nextLevel() {
		return _nextLevel;
	}
	public void set_nextLevel(Integer level) {
		_nextLevel = level;
	}
	public String get_levelLabelName() {
		return _levelLabelName;
	}
	public void set_levelLabelName(String labelName) {
		_levelLabelName = labelName;
	}
}
