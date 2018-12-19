package chaintree.data;

import util.bean.DataCell;
import util.datareader.DataReader;
import util.datareader.DataSet;
import util.similarity.EuclideanDistance;

public class SFDataT {

	private static final String[] fields = new String[]{
		"goods_name",
		"cat_name",
		"attr_name",
		"value_name"};
	
	private static final String filePath = "/chaintree/data/data1.csv";
	
	public static DataSet createDataset() {
		DataReader dataReader = new DataReader(filePath, fields);
		DataSet dataSet = null;
		try {
			DataCell[] cells = dataReader.loadData();
			
			dataSet = new DataSet(cells, new EuclideanDistance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSet;
	}
}
