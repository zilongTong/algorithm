package chaintree.algorithm;

import java.util.ArrayList;
import java.util.List;

import util.bean.Cluster;
import util.bean.DataCell;
import util.bean.Dendrogram;

public class SingleLinkAlgorithm {
	
    private DataCell[] elements;
    
    private double[][] a;
    
    private int maxLevel = 4;
    
	public SingleLinkAlgorithm(DataCell[] elements, double[][] a) {
		this.elements = elements;
		this.a = a;
	}

	public SingleLinkAlgorithm(DataCell[] elements, double[][] a, int maxLevel) {
		this.elements = elements;
		this.a = a;
		this.maxLevel = maxLevel;
	}
	
	public Dendrogram cluster() {
		Dendrogram dnd = new Dendrogram("Distance");
		double d = 0;
		List<Cluster> initialClusters = new ArrayList<Cluster>();
		for(DataCell cell : elements) {
			Cluster c = new Cluster(cell);
			initialClusters.add(c);
		}
		
		dnd.addLevel(String.valueOf(d), initialClusters);
		
		d = 1.0d;
		int k = initialClusters.size();
		
		while(k > 1 && d < maxLevel) {
			int oldK = k;
			List<Cluster> clusters = buildClusters(d);
			k = clusters.size();
			if(oldK != k) {
				dnd.addLevel(String.valueOf(d), clusters);
			}
			d ++;
		}
		
		return dnd;
	}
	
	private List<Cluster> buildClusters(double distanceThreshold) {
		boolean[] usedElementFlags = new boolean[elements.length];
		List<Cluster> clusters = new ArrayList<Cluster>();
		
		for(int i = 0, n = a.length; i < n; i ++) {
			List<DataCell> clusterCells = new ArrayList<DataCell>(0);
			
			for(int j = i, k = a.length; j < k; j ++) {
				
				if(a[i][j] <= distanceThreshold && !usedElementFlags[j]) {
					clusterCells.add(elements[j]);
					usedElementFlags[j] = true;
				}
			}
			
			if(clusterCells.size() > 0) {
				Cluster c = new Cluster(clusterCells);
				clusters.add(c);
			}
		}
		return clusters;
	}
	
	public DataCell[] getElements() {
		return elements;
	}
	public void setElements(DataCell[] elements) {
		this.elements = elements;
	}
	public double[][] getA() {
		return a;
	}
	public void setA(double[][] a) {
		this.a = a;
	}
}
