package chaintree.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import clustering.kmeans.surface.Cluster;
import clustering.kmeans.surface.Point;

public class ClusterSet {

	private Set<Cluster> allClusters = new HashSet<Cluster>(0);
	
	public Cluster findClusterByElement(Point p) {
		for(Cluster cluster : allClusters) {
			if(cluster.contain(p)) {
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
