package chaintree.classification.t1;

import java.io.IOException;
import java.util.List;

import util.resource.ResourceReader;
import chaintree.classification.CateRate;
import chaintree.classification.t1.knowledge.KeyCateKnowledge;

public class NBFilterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String p = "/chaintree/data/data1.csv";
		String p = "/classifier/goods/data/training_data.csv";
		ResourceReader reader = new ResourceReader(p);
		NBFilter filter = new NBFilter(new KeyCateKnowledge());
		try {
			
			reader.load();
			List<String> line = null;
			while((line = reader.readLines()) != null) {
				String cn = line.get(1);
				String brief = line.toString();
				filter.learn(cn, brief);
			}

			reader.reset();
			double total = 0;
			double right = 0;
			double exceptions = 0;
			long b = System.currentTimeMillis();
			boolean isall = true;
			if(isall) {
				while((line = reader.readLines()) != null) {
					total ++;
					String cn = line.remove(1);
					String brief = line.toString();
					try {
						AnalyzeResult analyzeResult = filter.analyzeFromBrief(brief);
						CateRate cr = analyzeResult.getMostProbable();
						if(cr == null) {
							System.out.println("分析结果为空：" + brief);
						} else {
							if(cr.getName().equalsIgnoreCase(cn)) {
								right ++;
							} else {
								//分析不准的信息
								System.out.println(cn + ":" + analyzeResult);
							}
						}
					} catch (Exception e) {
						exceptions ++;
					}
				}
				double rightRate = right / total * 100;
				System.out.println("一共分析  "+ total + " 个商品信息");
				System.out.println("正确的有：" + right + " 个");
				System.out.println("正确率：" + rightRate + "%");
				System.out.println("发生异常：" + exceptions);
				System.out.println("耗时：" + (System.currentTimeMillis() - b));
			}
			b = System.currentTimeMillis();
			String test = "[621507, 女前胸压褶局部撞色短袖衬衫, 修身型]";
			AnalyzeResult ar = filter.analyzeFromBrief(test);
			System.out.println(System.currentTimeMillis() - b);
			System.out.println(ar);
			System.out.println(filter.cateSize());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
