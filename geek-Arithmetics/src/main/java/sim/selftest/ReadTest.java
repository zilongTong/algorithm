package sim.selftest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import analyze.also.exp.NullPathException;

import sim.selftest.user.User;
import util.resource.ResourceReader;

public class ReadTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String file = "/sim/data/data.txt";
		ResourceReader reader = new ResourceReader(file);
		Map<String, User> users = new HashMap<String, User>(20, 0.9f);
		int total = 0;
		try {
			reader.load();
			String line = null;
			while((line = reader.readLine()) != null) {
				if(line == null || line.trim().isEmpty())
					continue;
				String[] values = line.split(",");
				String name = values[0];
				long itemId = Long.parseLong(values[1]);
				double pref = Double.parseDouble(values[2]);
				if(users.get(name) != null) {
					users.get(name).addItem(itemId, pref);
				}else{
					total ++;
					User u = new User(name);
					u.addItem(itemId, pref);
					users.put(name, u);
				}
			}

			Iterator<Entry<String, User>> us = users.entrySet().iterator();
			User[] uas = new User[total];
			int k = 0;
			while(us.hasNext()) {
				uas[k] = us.next().getValue();
				k ++;
			}
			
			for(int i = 0; i < total; i ++) {
				User u1 = uas[i];
				for(int j = i + 1; j < total; j ++) {
					User u2 = uas[j];
					
					System.out.println(u1.getName() + "\t" + u2.getName() + "\t\t" + u1.getSimilarity(u2));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPathException e) {
			e.printStackTrace();
		} finally {
			reader.close();
		}
	}

}
