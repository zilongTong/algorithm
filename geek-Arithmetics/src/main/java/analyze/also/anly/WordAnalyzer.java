package analyze.also.anly;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import analyze.also.Word;
import analyze.also.device.ChildrenDevice;
import analyze.also.device.IWeightingDevice;
import analyze.also.device.ManDevice;
import analyze.also.device.NoPeopleDevice;
import analyze.also.device.SeasonColdDevice;
import analyze.also.device.SeasonHotDevice;
import analyze.also.device.WomanDevice;

public class WordAnalyzer {
	/**
	 * 关键字
	 */
	private String _inputWord;
	/**
	 * 人群加权器
	 */
	private IWeightingDevice _peopleDevice;
	/**
	 * 季节加权器
	 */
	private IWeightingDevice _seasonDevice;
	
	public WordAnalyzer(String word) {
		_inputWord = word;
	}
	
	public void initDevices() {
		initPeopleDevice();
		initSeasonDevice();
		
	}
	
	public void calculate(List<Word> words) {
		for(Word word : words) {
			setNewWeigh(word);
		}
		System.out.println();
		Collections.sort(words, new Comparator<Word>() {
			public int compare(Word o1, Word o2) {
				if(o1.get_newWeighing() < o2.get_newWeighing()){
					return 1;
				}
				return -1;
			}
			
		});
	}
	
	private void setNewWeigh(Word word) {
		float old = word.get_oldeighing();
		float people = _peopleDevice.contain(word.get_value());
		float season = _seasonDevice.contain(word.get_value());
		people = people > 0 ? 1 : 0;
		float rs = 0f;
		rs = (float) (old / Math.pow(old, Math.sqrt(people + season)) + 20 * (people / (people + 1)) + season / Math.pow(season + 1, people));
		word.set_newWeighing(rs);
		System.out.println("旧权重n：" + old + "\t\t人群k：" + people + "\t\t季节q：" + season + "\t" + word.get_value());
	}
	
	private void initPeopleDevice() {
		IWeightingDevice manDevice = new ManDevice();
		IWeightingDevice womanDevice = new WomanDevice();
		IWeightingDevice childrenDevice = new ChildrenDevice();
		List<IWeightingDevice> devices = new ArrayList<IWeightingDevice>(0);
		devices.add(manDevice);
		devices.add(womanDevice);
		devices.add(childrenDevice);
		int currentNum = 0;
		for(IWeightingDevice device : devices) {
			int num = device.contain(_inputWord);
			if(num > currentNum) {
				_peopleDevice = device;
				currentNum = num;
			}
		}
		if(currentNum == 0){
			_peopleDevice = new NoPeopleDevice();
		}
	}
	
	private void initSeasonDevice() {
		IWeightingDevice seasonCodeDevice = new SeasonColdDevice();
		IWeightingDevice seasonHotDevide = new SeasonHotDevice();
		int cold = seasonCodeDevice.contain(_inputWord);
		int hot = seasonHotDevide.contain(_inputWord);
		if(cold > hot) {
			_seasonDevice = seasonCodeDevice;
		} else if(cold < hot) {
			_seasonDevice = seasonHotDevide;
		} else {
			_seasonDevice = defaultSeasonDevice();
		}
	}
	
	private IWeightingDevice defaultSeasonDevice() {
		int month = Calendar.getInstance().get(Calendar.MONTH);
		if(month > 10 || month < 3) {
			return new SeasonColdDevice();
		} else {
			return new SeasonHotDevice();
		}
	}

	public String show() {
		String info = "新权重计算公式：\n" +
				"\t自身权重：n\n" +
				"\t人群：k\n" +
				"\t季节：q\n" +
				"\tweight = n / Math.pow(n, Math.sqrt(k + q)) + q * Math.pow(k, 2) + q / Math.pow(q + 1, k)";
		return info;
	}
	
	public String get_inputWord() {
		return _inputWord;
	}

	public void set_inputWord(String word) {
		_inputWord = word;
	}

	public IWeightingDevice get_peopleDevice() {
		return _peopleDevice;
	}

	public void set_peopleDevice(IWeightingDevice device) {
		_peopleDevice = device;
	}

	public IWeightingDevice get_seasonDevice() {
		return _seasonDevice;
	}

	public void set_seasonDevice(IWeightingDevice device) {
		_seasonDevice = device;
	}
	
}
