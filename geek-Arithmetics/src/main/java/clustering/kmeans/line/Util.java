package clustering.kmeans.line;

import java.util.List;

public class Util {

	public static double average(List<Integer> list) {
		if(list == null || list.size() < 1)
			return -1;
		int sum = 0;
		for(Integer p : list) {
			sum += p;
		}
		return sum / list.size();
	}
	public static double variance(List<Integer> list) {
		double avg = average(list);
		if(avg < 0) {
			return -1;
		}
		double total = 0;
		for(Integer p : list) {
			total += Math.pow(p - avg, 2);
		}
		return total / list.size();
	}
	
	public static double standardDeviation(List<Integer> list) {
		double var = variance(list);
		if(var < 0) {
			return -1;
		}
		return Math.sqrt(var);
	}
}
