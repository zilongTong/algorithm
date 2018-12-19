package analyze.one.topn;

public class IntegerBean implements ITopNBean {

	private int count = 0;

	public IntegerBean(int count) {
		super();
		this.count = count;
	}

	@Override
	public String toString() {
		return "IntegerBean [count=" + count + "]";
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public double value() {
		return this.count;
	}
}
