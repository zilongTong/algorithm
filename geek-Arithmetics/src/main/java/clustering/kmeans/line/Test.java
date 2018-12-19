package clustering.kmeans.line;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= 200; i ++) {
			list.add(i);
		}
		KMeans means = new KMeans(list, 10);
		List<Cluster> rs = means.execute();
		for(Cluster c : rs) {
			System.out.println(c.get_list());
		}
		
	}
}
