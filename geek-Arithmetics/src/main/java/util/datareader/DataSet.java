package util.datareader;

import java.util.Arrays;

import util.bean.DataCell;
import util.similarity.Distance;

public class DataSet {
	private DataCell[] data;
	private Distance distance;
	private double[][] adjacencyMatrix;
	
	public DataSet(DataCell[] dataCell, Distance distance) {
		this.data = dataCell;
		this.distance = distance;
		adjacencyMatrix = calculateMatrix();
	}
	
	private double[][] calculateMatrix() {
		int n = data.length;
		double[][] matrix = new double[n][n];
		DataCell a = null, b = null;
		for(int i = 0; i < n; i ++) {
			a = data[i];
			for(int j = i + 1; j < n; j ++) {
				b = data[j];
				matrix[i][j] = distance.getDistance(a.get_numericAttributeValues(), b.get_numericAttributeValues());
				matrix[j][i] = matrix[i][j];
			}
			matrix[i][i] = 0f;
		}
		return matrix;
	}
	
	public DataCell[] getData() {
		return data;
	}
	public void setData(DataCell[] data) {
		this.data = data;
	}
	public Distance getDistance() {
		return distance;
	}
	public void setDistance(Distance distance) {
		this.distance = distance;
	}
	public double[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}
	public void setAdjacencyMatrix(double[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}
	public void displayAdjacencyMatrix() {
		for(int i = 0, len = adjacencyMatrix.length; i < len; i ++) {
			System.out.println(Arrays.toString(adjacencyMatrix[i]));
		}
	}
}
