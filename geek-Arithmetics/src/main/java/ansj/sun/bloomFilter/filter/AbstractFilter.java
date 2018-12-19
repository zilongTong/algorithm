package ansj.sun.bloomFilter.filter;

import ansj.sun.bloomFilter.bitMap.IntMap;
import ansj.sun.bloomFilter.bitMap.LongMap;
import ansj.sun.bloomFilter.iface.BitMap;
import ansj.sun.bloomFilter.iface.Filter;

/**
 *
 * @author Smile.Wu
 * @version 2015-6-8
 */
public abstract class AbstractFilter implements Filter {
	
	private BitMap bm = null;

	private long size = 0;

	public AbstractFilter(long maxValue, int MACHINENUM) throws Exception {
		this.size = maxValue;
		if (MACHINENUM == 32) {
			bm = new IntMap((int) (size / MACHINENUM));
		} else if (MACHINENUM == 64) {
			bm = new LongMap((int) (size / MACHINENUM));
		} else {
			throw new Exception("DefaultFilter exception");
		}
	}
	
	public long dealHashcode(long hashCode) {
		//绝对值，不溢出
		return (hashCode > 0 ? hashCode : -1 * hashCode) % size;
	}

	public AbstractFilter(long maxValue) {
		size = maxValue ;
		bm = new IntMap((int) (size / 32));
	}

	public boolean contains(String str) {
		long hash = this.myHashCode(str);
		return bm.contains(hash);
	}

	public void add(String str) {
		long hash = this.myHashCode(str);
		bm.add(hash);
	}

	public BitMap getBm() {
		return bm;
	}

	public void setBm(BitMap bm) {
		this.bm = bm;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public boolean containsAndAdd(String str) {
		long hash = this.myHashCode(str);
		
		if (bm.contains(hash)) {
			return true;
		} else {
			bm.add(hash);
		}
		return false;
	}
}
