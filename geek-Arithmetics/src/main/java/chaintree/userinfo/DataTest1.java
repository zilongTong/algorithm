package chaintree.userinfo;

import java.io.File;

import chaintree.algorithm.SingleLinkAlgorithm;
import chaintree.data.SFData;

import util.bean.DataCell;
import util.bean.Dendrogram;
import util.datareader.DataReader;
import util.datareader.DataSet;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-5-30 上午10:38:25 
 */
public class DataTest1 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		File file = new File(StaticValue.USER_DATE_AFTER_HANDLE);
		DataReader reader = new DataReader(file, StaticValue.HANDLED_USER_FIELD);
		
		DataSet ds = SFData.createDataset(reader);

		DataCell[] dataCells = ds.getData();
		double[][] adjMatrix = ds.getAdjacencyMatrix();

		SingleLinkAlgorithm sla = new SingleLinkAlgorithm(dataCells, adjMatrix);
		Dendrogram dendrogram = sla.cluster();
//		dendrogram.printAll();
		dendrogram.print(1);
	}

}
