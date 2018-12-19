package chaintree.data;

import util.bean.DataCell;
import util.datareader.DataReader;
import util.datareader.DataSet;
import util.similarity.EuclideanDistance;

public class SFData {

	private static final String[] fields = new String[]{"Age", "IncomeRange", "Education", "Skills", "Social", "isPaid"};
	
	private static final String filePath = "/chaintree/data/clusteringSF.dat";
	
	public static DataSet createDataset() {
		DataReader dataReader = new DataReader(filePath, fields);
		return createDataset(dataReader);
	}

	public static DataSet createDataset(DataReader dataReader) {
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
