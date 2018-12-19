package analyze.also.device;

import java.util.List;

import analyze.also.wordstock.Stock;

public class Device implements IWeightingDevice {
	
	private Stock _stock;
	
	public Device(String path) {
		_stock = new Stock(path);
		try {
			_stock.initDictMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int contain(String word) {
		List<String> rs = _stock.process(word, false);
		return rs.size();
	}

}
