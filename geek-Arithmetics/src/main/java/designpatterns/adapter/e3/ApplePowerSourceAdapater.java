package designpatterns.adapter.e3;

public class ApplePowerSourceAdapater extends PowerSource220V implements LowPowerSource {

	@Override
	public int getChargeSupply() {	//实现目标接口
		//获得待适配的接口数据
		int powerSource220 = super.supplyPower();
		
		//进行一个适配处理
		powerSource220 = 36;
		
		return powerSource220;
	}

}
