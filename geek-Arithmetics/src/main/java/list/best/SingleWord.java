package list.best;
/**
 *
 * @author Smile.Wu
 * @version 2015-9-14
 */
public class SingleWord {
	public static int singleNumber(int a[], int n) {
	    int result = 0;
	    for (int i = 0; i < n; i++)
	    {
	        result ^= a[i];
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{2, 4, 1, 5, 2, 4, 1};
		
		System.out.println(singleNumber(a, 7));
	}
}
