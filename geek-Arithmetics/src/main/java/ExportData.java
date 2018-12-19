import java.io.File;
import java.io.IOException;

import analyze.also.exp.NullPathException;

import util.resource.CharSet;
import util.resource.ResourceReader;
import util.resource.ResourceWriter;


public class ExportData {

	public static void main(String[] args) throws NullPathException, IOException {
		
		String in = "D://同事文档//吴成江//邦购网3月份关键字.csv";
		String out = "D://同事文档//吴成江//out.csv";
		ResourceReader reader = new ResourceReader(new File(in));
		ResourceWriter writer = new ResourceWriter(out, CharSet.GBK);
		
		reader.load();
		String line = null;
		while((line = reader.readLine()) != null) {
			writer.write(line);
		}
	
		reader.close();
		writer.close();
	}
}
