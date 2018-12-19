package util.datareader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.bean.Attribute;
import util.bean.DataCell;
import util.resource.CharSet;
import util.resource.ResourceReader;
import util.similarity.EuclideanDistance;

public class DataReader {

	private String[] _fields = null;
	
	private String _filePath = null;
	private File _file = null;
	
	public DataReader(String filePath, String[] fields) {
		_fields = fields;
		_filePath = filePath;
	}
	public DataReader(File file, String[] fields) {
		_fields = fields;
		this._file = file;
	}
	private ResourceReader getResourceReader() {
		if(_file != null) {
			return new ResourceReader(_file);
		} else {
			return new ResourceReader(_filePath, CharSet.UTF8);
		}
	}
	public DataCell[] loadData() throws Exception {
		List<DataCell> dataCells = new ArrayList<DataCell>(0);
		ResourceReader reader = getResourceReader();
		try {
			reader.load();
			String[] titles = reader.readAsArray();

			int attrLength = _fields.length;
			int[] attrFieldIndexes = new int[attrLength];
			for(int i = 0; i < attrLength; i ++) {
				String attrName = _fields[i];
				int fileDataId = -1;
				for(int j = 0; j < titles.length; j ++) {
					if(attrName.equalsIgnoreCase(titles[j])) {
						fileDataId = j;
						break;
					}
				}
				
				if(fileDataId == -1) {
					throw new RuntimeException("attribute names mismatch, can not file field named " + attrName + " " +
							"among data file. All avaliable names is : " + Arrays.toString(titles));
				} else {
					attrFieldIndexes[i] = fileDataId;
				}
			}
			
			List<String> lines = null;
			while((lines = reader.readLines()) != null) {
				int lineSize = lines.size();
				try {
					String labelId = lines.get(0);
					Attribute[] attributes = new Attribute[attrLength];
					for(int i = 0; i < attrLength; i ++) {
						int attrFieldIndex = attrFieldIndexes[i];
						String value = lineSize > attrFieldIndex ? lines.get(attrFieldIndex) : "";
						attributes[i] = new Attribute(_fields[i], value);
					}
					DataCell dataCell = new DataCell(labelId, attributes);
					dataCells.add(dataCell);
				} catch (Exception e) {
					throw new RuntimeException("error while reading line : " + lines + ". " + e);
				}
			}
			
		} catch (IOException e) {
			throw new Exception("error while reading data from file: " + _filePath + "." + e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return dataCells.toArray(new DataCell[dataCells.size()]);
	}

	public void set_fields(String[] _fields) {
		this._fields = _fields;
	}
	public String[] get_fields() {
		return _fields;
	}
	public String get_filePath() {
		return _filePath;
	}
	public void set_filePath(String path) {
		_filePath = path;
	}
	
	public static void main(String[] args) throws Exception {
		long b = System.currentTimeMillis();
		String[] fields = new String[]{"Age", "IncomeRange", "Education", "Skills", "Social", "isPaid"};
		String filePath = "/chaintree/data/clusteringSF.dat";
		DataReader dataReader = new DataReader(filePath, fields);
		DataCell[] cells = dataReader.loadData();
		
		for(DataCell cell : cells) {
			System.out.println(cell);
		}
		System.out.println();
		DataSet dataSet = new DataSet(cells, new EuclideanDistance());
		
		dataSet.displayAdjacencyMatrix();
		
		System.out.println(System.currentTimeMillis() - b);
	}
}
