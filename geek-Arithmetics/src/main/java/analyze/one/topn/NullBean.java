package analyze.one.topn;

public class NullBean implements ITopNBean {
	private int v = 0;

	public NullBean(int v) {
		this.v = v;
	}
	
	@Override
	public double value() {
		return v;
	}

}
