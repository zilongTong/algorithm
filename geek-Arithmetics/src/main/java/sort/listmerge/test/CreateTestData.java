package sort.listmerge.test;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import analyze.also.exp.NullPathException;

import util.resource.ResourceReader;
import util.resource.ResourceWriter;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-6-26 下午2:14:28 
 */
public class CreateTestData {
	public static void f(String path, String name) throws NullPathException, IOException {
		File inFile = new File(path + name);
		
		ResourceReader reader = new ResourceReader(inFile);
		ResourceWriter writer = new ResourceWriter(path + "data/" + name);
		Random r = new Random(System.currentTimeMillis());
		reader.load();
		String line = null;
		while ((line = reader.readLine()) != null) {
			float s = r.nextFloat();
			line += "," + s;
			System.out.println(line);
			writer.write(line);
		}
		
		reader.close();
		writer.close();
	}
	public static void main(String[] args) throws NullPathException, IOException {
		String path = "F:/kingyp/Arithmetics/src/sort/listmerge/Test/";
		String[] fileNames = new String[]{"buy.txt","common.txt","love.txt","view.txt"};
		
		f(path, fileNames[0]);
		f(path, fileNames[1]);
		f(path, fileNames[2]);
		f(path, fileNames[3]);
	}
}
