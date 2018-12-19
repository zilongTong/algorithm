package list.conbain.array;

import java.util.Arrays;

import list.conbain.itfc.IDataArray;

/**
 *
 * @author Smile.Wu
 * @version 2015-7-17
 */
public class IntegerDataArray implements IDataArray {
	
	private Integer[] array;
	
	private int index = -1;
	
	private int size = -1;
	
	private long currentData;

	public IntegerDataArray(Integer[] array) {
		Arrays.sort(array);
		this.array = array;
		this.index = -1;
		this.size = array.length;
		this.currentData = NO_MORE_DATA;
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
		return currentData;
	}

	@Override
	public long nextDoc() {
		index ++;
		if(index >= size) {
			currentData = NO_MORE_DATA;
		} else {
			currentData = array[index];
		}
		return currentData;
	}
}
