package designpatterns.adapter.e3;

public class ApplePhone implements Phone {

	@Override
	public void charge(LowPowerSource powerSource) {
		if(powerSource.getChargeSupply() == 36) {
			System.out.println("apple phone is in charge!");
		} else {
			throw new RuntimeException("voltage error of power source!");
		}
	}

}
