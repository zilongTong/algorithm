package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.bean.Cluster;
import util.bean.DataCell;

public class ClusterSet {

	private Set<Cluster> allClusters = new HashSet<Cluster>();
	
	public Cluster findClusterByElement(DataCell cell) {
		for(Cluster cluster : allClusters) {
			if(cluster.contain(cell)) {
				return cluster;
			}
		}
		return null;
	}

	public List<Cluster> getAllClusters() {
		return new ArrayList<Cluster>(allClusters);
	}
	
	public int size() {
		return allClusters.size();
	}
	
	public void add(Cluster cluster) {
		allClusters.add(cluster);
	}
	
	public void remove(Cluster cluster) {
		allClusters.remove(cluster);
	}
}
