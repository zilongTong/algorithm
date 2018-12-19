package list.conbain.array;

import list.conbain.itfc.IDataArray;
import list.core.DataQueue;

/**
 *
 * @author Smile.Wu
 * @version 2015-7-17
 * 并集
 */
public class DataDisjunction implements IDataArray {
	//倒排链表最小堆
	private DataQueue dataQueue;
	//并集最小满足数
	private int minMatchNum = 1;
	
	private long currentData = -1;
	
	public DataDisjunction(IDataArray[] arrays, int minMatchNum) {
		//构建一个指定大小的二叉堆排序对象
		dataQueue = new DataQueue(arrays.length);
		if(arrays.length > 0) {
			for(IDataArray array : arrays) {
				if(array.nextDoc() != NO_MORE_DATA) {
					//每个元素进行各自的下一个结果计算，并添加到二叉堆进行排序
					dataQueue.insert(array);
				}
			}
		}
		this.minMatchNum = minMatchNum;
	}

	@Override
	public long nextDoc() {
		//如果当前堆中的元素数量小于最小的要求满足数，或者没有更多的结果，则设置当前数值为没有结果
		//advanceAfterCurrent方法中计算下一个结果
		if(dataQueue.size() < minMatchNum || !advanceAfterCurrent()) {
			currentData = NO_MORE_DATA;
		}
		
		return currentData;
	}

	@Override
	public long dataID() {
		
		return currentData;
	}

	@Override
	public long advance(long dataID) {
		while(nextDoc() != NO_MORE_DATA) {
			if(currentData >= dataID) {
				return currentData;
			}
		}
		return NO_MORE_DATA;

//		if(dataQueue.size() < minMatchNum || !advanceAfter(dataID)) {
//			currentData = NO_MORE_DATA;
//		}
//		return currentData;
	}

	/*
	 * 计算下一个符合条件的数值
	 */
	protected boolean advanceAfterCurrent() {
		do {
			currentData = dataQueue.topArrayData();//获得堆顶元素的链表的当前数
			int matchs = 1;
			do {
				if(!dataQueue.topNextAndAdjustElsePop()) {
					if(dataQueue.size() == 0) {
						break;
					}
				}
				
				//下一个堆顶元素的当前数值，不等于当前数值，则退出
				if(dataQueue.topArrayData() != currentData) {
					break;
				}
				
				matchs ++;
				
			} while(true);
			
			//计算得到符合要求的结果，返回true，结果储存在【currentData】
			if(matchs >= minMatchNum) {
				//matchs，这里可以记录该数满足的链表数量，用于二次排序：按照满足链表数量排序
				return true;
			}
			if(dataQueue.size() < minMatchNum) {
				return false;
			}
		} while(true);
	}

	@Deprecated
	protected boolean advanceAfter(long data) {
		do {
			currentData = dataQueue.topArrayData(data);//最顶层到排表第一个数
			int matchs = 1;
			do {
				if(!dataQueue.skipToAndAdjustElsePop(data)) {
					if(dataQueue.size() == 0) {
						break;
					}
				}
				
				if(dataQueue.topArrayData(data) != currentData) {
					break;
				}
				
				matchs ++;
				
			} while(true);
			
			if(matchs >= minMatchNum) {
				return true;
			}
			if(dataQueue.size() < minMatchNum) {
				return false;
			}
		} while(true);
	}
}
