package analyze.also.device;

public interface IWeightingDevice {
	
	/**
	 * 分词关键词中是否包含该词库的关键字
	 * @param word 关键词
	 * @return
	 */
	public int contain(String word);
}
