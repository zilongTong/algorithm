package designpatterns.adapter.e3;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-19
 */
public class PowerSource220V implements PowerSource {

	@Override
	public int supplyPower() {
		//提供220V电压
		return 220;
	}

}
