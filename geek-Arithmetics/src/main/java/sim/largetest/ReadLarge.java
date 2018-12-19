package sim.largetest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import util.resource.ResourceReader;

public class ReadLarge {

	public static void main(String[] args) {
		ResourceReader reader = new ResourceReader("/sim/data/userGoods.dat");
		try {
			long b = System.currentTimeMillis();
			reader.load();
			Map<Long, User> users = new HashMap<Long, User>(100, 0.95f);
			IndexMapper userIdMapper = new IndexMapper();
			long count = 0;
			String line = null;
			while((line = reader.readLine()) != null) {
				String[] datas = line.split(",");
				if(datas.length == 3) {
					count ++;
					long mobile = Long.parseLong(datas[0]);
					long goodsSn = Long.parseLong(datas[1]);
					float pref = Float.parseFloat(datas[2]);
					userIdMapper.getIndex(mobile);
					Goods g = new Goods(goodsSn, pref);
					if(users.get(mobile) == null) {
						User user = new User(mobile, g);
						users.put(mobile, user);
					}else{
						users.get(mobile).addGoods(g);
					}
				}
			}
			System.out.println("ok");
			int userCounter = userIdMapper.get_indexToMobile().size();
			System.out.println("用户总数：" + userCounter);
			for(int u = 0; u < userCounter; u ++) {
				long userAId = userIdMapper.getObjectIdFrom(u);
				User userA = users.get(userAId);
				System.out.println(userAId);
				for(int v = u + 1; v < userCounter; v ++) {
					long userBId = userIdMapper.getObjectIdFrom(v);
					User userB = users.get(userBId);
					double sim = userA.getSimilarity(userB);
					if(sim > 0) {
						System.out.println(userAId + " - " + userBId + " : " + sim);
					}
				}
			}
			
			System.out.println(count);
			System.out.println(users.size());
			System.out.println("读取耗时：" + (System.currentTimeMillis() - b));
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
