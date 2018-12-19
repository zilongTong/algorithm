package sort.merge;

import java.util.Arrays;
import java.util.Comparator;
import sort.util.AbstractSort;

/**
 * 
 * @author wjyuian
 *	合并排序采用了分治法的思路来设计排序算法。 
	主要步骤： 
	1：分解数组 
	2：排序子数组 
	3：合并排序好的子数组 
 * @param <T>
 */
public class MergeSort<T> extends AbstractSort<T> {
	private boolean isLog = false;
	public void setLog(boolean isl) {
		isLog = isl;
	}
	private void log(String t) {
		if(isLog) {
			System.out.println(t);
		}
	}
	
	public MergeSort(Comparator<? super T> comp) {
		init(comp);
	}

	public T[] sort(T... array) {
		log("src:" + Arrays.toString(array));
		sort(array, 0, array.length - 1, array.clone());
		return null;
	}


    /** 
     * 对指定区间[start,end]的数组元素进行排序 
     *  
     * @param start 
     * @param end 
     */  
    private void sort(T[] src, int start, int end, T[] clone) {  
        if (start < end) {  
        	log("sort array: " + Arrays.toString(Arrays.copyOfRange(src, start, end)));
            int mid = (end + start) / 2;  
            sort(src, start, mid, clone);  
            sort(src, mid + 1, end, clone);  
            merge(src, start, mid + 1, end + 1, clone);  
        }  
    }
    
    /** 
     * 合并子数组[start,mid)和子数组[mid,end)。 
     *  
     * @param src 
     * @param start 
     * @param mid 
     * @param end 
     * @param clone 
     */  
    private void merge(T[] src, int start, int mid, int end, T[] clone) {  

    	log("sub sort array 1: " + Arrays.toString(Arrays.copyOfRange(src, start, mid)));
    	log("sub sort array 2: " + Arrays.toString(Arrays.copyOfRange(src, mid, end)));
        System.arraycopy(src, start, clone, start, end - start);  
        int leftIndex = start;  
        int rightIndex = mid;  
        int i = start;  
        log("start:"+start+", mid:"+ mid+", end:"+ end);
        for (; leftIndex < mid && rightIndex < end; i++) {  
            T l = clone[leftIndex];  
            T r = clone[rightIndex];  
            log("\ti:"+i+", left=clone["+leftIndex+"]="+l+", right=clone["+rightIndex+"]="+ r);
            if (comp.compare(r, l) > 0) {  
                src[i] = l;  
                leftIndex++;  
                log("\t\tsrc["+i+"] = left");
            } else {  
                src[i] = r;  
                rightIndex++;  
                log("\t\tsrc["+i+"] = right");
            }  
            log("src:"+Arrays.toString(src)+"\tclone:"+Arrays.toString(clone));
        }  
        if (leftIndex < mid) {  
            System.arraycopy(clone, leftIndex, src, i, mid - leftIndex); 
            log("System.arraycopy(clone, leftIndex, src, i, mid - leftIndex)");
        } else {  
        	// if(rightIndex == end) 
            // 复制右半部分  
            System.arraycopy(clone, rightIndex, src, i, end - rightIndex);  
            log("System.arraycopy(clone, rightIndex, src, i, end - rightIndex)");
        }  
        log("****************************************************************\n");
    }  
  
    public static void main(String[] args) {  
        MergeSort<Integer> s = new MergeSort<Integer>(new Comparator<Integer>() {  
            public int compare(Integer o1, Integer o2) {  
                return (o1 - o2) * 1;  
            }  
        });  
        s.setLog(true);
        Integer[] array = new Integer[] { 3, 5, 9, 8, 12, 1, 55, 7 };  
        s.sort(array);  
        System.out.println(Arrays.toString(array));  
    }  
  
    public String toString() {  
        return "合并排序";  
    } 
}
