package list.conbain.array;

import java.util.Arrays;
import java.util.Comparator;

import list.conbain.itfc.IDataArray;

/**
 *
 * @author Smile.Wu
 * @version 2015-7-17
 * 交集
 */
public class DataConjunction implements IDataArray {

	private IDataArray[] arrays;
	
	//默认值-1，后面有使用
	private long lastData = -1;
	
	/**
	 * 构造函数，将待处理链表（数组）传入
	 * @param arrays
	 */
	public DataConjunction(IDataArray[] arrays) {
		this.arrays = arrays;
		//数组长度大于1才需要进行处理
		if(arrays.length > 1) {
			for(IDataArray array : arrays) {
				//没一个链表的虚拟指针，都指向第一个数据
				if(array.nextDoc() == NO_MORE_DATA) {
					lastData = NO_MORE_DATA;
					return;
				}
			}
			//将数组，按照链表的第一个数值，从小到大排列
			Arrays.sort(arrays, new Comparator<IDataArray>() {
				@Override
				public int compare(IDataArray o1, IDataArray o2) {
					if(o1.dataID() == o2.dataID()) {
						return 0;
					}
					if(o1.dataID() > o2.dataID()) {
						return 1;
					} else {
						return -1;
					}
				}
			});
			
			//获取第一个符合条件的数值
			if(doNext() == NO_MORE_DATA) {
				lastData = NO_MORE_DATA;
				return;
			}
		}
	}
	
	/*
	 * 执行一次计算
	 */
	private long doNext() {
		int first = 0;
		//最后一个元素的第一个数
		long doc = arrays[arrays.length - 1].dataID();
		
		IDataArray firstArray;
		
		/*
		 * 循环结束的条件
		 * 
		 * 1、有一个元素的链表结束，即返回 NO_MORE_DATA
		 * 
		 * 2、firstArray的dataID == doc		？		元素按照链表第一个元素，升序排列
		 */
		while((firstArray = arrays[first]).dataID() < doc) {
			
			//跳转到大于等于doc的数
			doc = firstArray.advance(doc);
			//循环判断
			first = first == arrays.length - 1 ? 0 : first + 1;
		}
		
		return doc;
	}

	@Override
	public long nextDoc() {
		if(lastData == NO_MORE_DATA) {
			return lastData;
		} else if(lastData == -1) {
			/*
			 * 因为在构造函数里进行了排序，所以所有元素的链表虚拟指针已经指向第一个数字
			 * 所以第一次doNext操作，也是在构造函数里执行，这里第一次调用nextDoc时（lastData == -1），实际上结果已经存在，直接赋值lastData，并返回
			 */
			//构造函数第一次调用doNext()，lastData = -1，返回doNext计算得出的第一个符合条件的值
			return lastData = arrays[arrays.length - 1].dataID();
		}
		
		/*
		 * 数组的最后一个元素对应的链表，虚拟指针指向下一个数字
		 * 数组是按照每个链表的第一个数，从小到大排列的，因此交集可以从最后一个数组元素的链表开始
		 */
		arrays[arrays.length - 1].nextDoc();
		
		//执行一次交集运算，并赋值
		return lastData = doNext();
	}

	@Override
	public long dataID() {
		return lastData;
	}

	@Override
	public long advance(long dataID) {
		//内部调用计算
		while(nextDoc() != NO_MORE_DATA) {
			if(lastData >= dataID) {
				return lastData;
			}
		}
		return NO_MORE_DATA;
	}
	
	public int size() {
		return arrays.length;
	}
}
