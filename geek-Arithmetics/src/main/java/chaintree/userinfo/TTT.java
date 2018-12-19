package chaintree.userinfo;

import java.io.File;
import java.io.IOException;

import util.resource.ResourceReader;
import util.resource.ResourceWriter;
import analyze.also.exp.NullPathException;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-5-30 上午10:48:53 
 */
public class TTT {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NullPathException 
	 */
	public static void main(String[] args) throws NullPathException, IOException {
		File file = new File(StaticValue.USER_DATE_SRC);
//		File file = new File("D:/快盘/Java Design Model/Arithmetics/src/chaintree/data/clusteringSF.dat");
		ResourceReader reader = new ResourceReader(file);

		reader.load();
		
		ResourceWriter resourceWriter = new ResourceWriter(StaticValue.USER_DATE_AFTER_HANDLE);
		String line = null;
		int i = 0;
		while((line = reader.readLine()) != null) {
			if(i == 0) {
				line = Util.getFieldTitle();
			} else {
				line = Util.handleLine(line);
			}
			if(i == 0 || i > 1000) {
				resourceWriter.write(line);
			}
			if(++ i >= 2000) {
				break;
			}
		}
		reader.close();
		resourceWriter.close();
	}

}
