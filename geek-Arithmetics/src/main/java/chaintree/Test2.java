package chaintree;

import util.bean.DataCell;
import util.datareader.DataSet;
import chaintree.data.SFDataT;

public class Test2 {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		DataSet ds = SFDataT.createDataset();
		System.out.println(ds.getData().length);
		DataCell[] dcs = ds.getData();

	}

}
