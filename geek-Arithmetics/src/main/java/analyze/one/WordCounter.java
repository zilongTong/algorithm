package analyze.one;

import analyze.one.topn.ITopNBean;

public class WordCounter implements ITopNBean {

	private String word;
	private long count;
	public WordCounter() {
		
	}
	public WordCounter(String word, long count) {
		super();
		this.word = word;
		this.count = count;
	}

	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public void addCount(int i) {
		this.count += i;
	}
	@Override
	public double value() {
		return this.count;
	}
	@Override
	public String toString() {
		return "WordCounter [word=" + word + ", count=" + count + "]";
	}
}
