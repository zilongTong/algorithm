package orion.java.map.hashmap;


/**
 * 
 * @author Smile.Wu
 * @version 2015-11-17
 */
public class TestHashMap {

	static class Entry {
		private int value;
		private Entry next;

		private Entry(int value, Entry next) {
			super();
			this.value = value;
			this.next = next;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Entry getNext() {
			return next;
		}

		public void setNext(Entry next) {
			this.next = next;
		}
	}

	public void showEntrys(Entry en) {
		while (en != null) {
			System.out.print(en.getValue() + " ");
			en = en.getNext();
		}
	}

	public void testEntry1() {
		Entry[] entrys = new Entry[1];

		entrys[0] = new Entry(10, null);

		Entry old = entrys[0];
		entrys[0] = new Entry(20, old);

		showEntrys(entrys[0]);
	}

	public void testEntry2() {
		Entry[] entrys = new Entry[1];

		entrys[0] = new Entry(10, null);

		entrys[0] = new Entry(20, entrys[0]);

		showEntrys(entrys[0]);
	}

	public int v(int c) {
		int capacity = 1;
		while (capacity < c)
			capacity <<= 1;
		return capacity;
	}

	public void bestCopacity() {
		int size = 5000;
		int c = v(size);
		int resize = (int) (c * 0.75F);
		System.out.println(c);
		System.out.println(resize);
		
		int realSize = (int) (size / 0.75);
		System.out.println(realSize);
		System.out.println(v(realSize));
	}
}
