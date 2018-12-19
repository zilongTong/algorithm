package designpatterns.adapter.e3;

public class ApplePowerSourceAdapater1 implements LowPowerSource {
	private PowerSource adaptee = null;

	public ApplePowerSourceAdapater1(PowerSource adaptee) {
		super();
		this.adaptee = adaptee;
	}

	@Override
	public int getChargeSupply() {
		//获得待适配的接口数据
		int powerSource220 = adaptee.supplyPower();
		
		//进行一个适配处理
		powerSource220 = 36;
		
		return powerSource220;
	}

}
