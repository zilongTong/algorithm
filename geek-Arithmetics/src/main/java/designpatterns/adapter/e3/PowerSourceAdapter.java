package designpatterns.adapter.e3;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-19
 */
public class PowerSourceAdapter extends PowerSource220V implements PowerSource {
	private int targetVoltage = 110;
	
	public PowerSourceAdapter(int targetVoltage) {
		super();
		this.targetVoltage = targetVoltage;
	}

	@Override
	public int supplyPower() {
		//现有电源的电压
		int sourceVoltage = super.supplyPower();
		
		//如果当前的电源电压不是目标电压，则进行变压适配
		if(sourceVoltage != targetVoltage) {
			//电压适配：变压
			sourceVoltage = targetVoltage;
		}
		
		return sourceVoltage;
	}
}
