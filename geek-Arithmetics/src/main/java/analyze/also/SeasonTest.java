package analyze.also;

import java.util.ArrayList;
import java.util.List;

import analyze.also.device.ChildrenDevice;
import analyze.also.device.IWeightingDevice;
import analyze.also.device.ManDevice;
import analyze.also.device.SeasonColdDevice;
import analyze.also.device.SeasonHotDevice;
import analyze.also.device.WomanDevice;

public class SeasonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IWeightingDevice seasonCodeDevice = new SeasonColdDevice();
		IWeightingDevice seasonHotDevide = new SeasonHotDevice();
		IWeightingDevice manDevice = new ManDevice();
		IWeightingDevice womanDevice = new WomanDevice();
		IWeightingDevice childrenDevice = new ChildrenDevice();
		long b = System.currentTimeMillis();
		List<String> words = new ArrayList<String>(0);
		words.add("Metersbonwe[新品]运动休闲女装织花毛毛里开衫毛衣");
		words.add("ME&CITY KIDS男童插肩连帽短打无袖T恤[童装优惠]");
		words.add("ME&CITY KIDS男童撞色袖棉布茄克");
		words.add("ME&CITY KIDS[童装优惠]女童波点印花针织长袖连帽衫");
		words.add("Metersbonwe男运动休闲前胸印花连帽针织套头卫衣[元旦限时特价]");
		
		words.add("AMPM男基本净色圆领长袖毛衫");
		words.add("Metersbonwe男一款多花满身印花连帽针织套头卫衣[元旦限时特价]");
		words.add("Metersbonwe男装圆领间条长袖毛衣[元旦限时特价]");
		words.add("Metersbonwe[新品]男前胸提花条纹圆领长袖毛衣");
		words.add("AMPM女基本净色高领长袖毛衫（缤纷纯色）");
		words.add("Metersbonwe女净色立领开衫卫衣");
		for(String word : words) {
			System.out.println(word);
			System.out.println("秋冬装："+seasonCodeDevice.contain(word));
			System.out.println("春夏装："+seasonHotDevide.contain(word));
			System.out.println("男士："+manDevice.contain(word));
			System.out.println("女士："+womanDevice.contain(word));
			System.out.println("童装："+childrenDevice.contain(word)+"\n**********************************");
		}
		System.out.println("耗时："+(System.currentTimeMillis() - b));
	}

	/*
		自身权重：n
		人群：k
		季节：q
		n / Math.pow(n, Math.sqrt(k + q)) + q * Math.pow(k, 2) + Math.sqrt(q)
	 */
}
