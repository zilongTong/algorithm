package designpatterns.adapter.e3;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-19
 */
public class App {

	public static void main(String[] args) throws PowerVoltageException {
		//创建一个220V电源
		PowerSource powerSource220 = new PowerSource220V();
		
		//启动220V的电脑
		AbstractComputer computer = new Computer220V();
		computer.startUp(powerSource220);
		
		AbstractComputer computer110 = new Computer110V();
		try {
			//由于没有110V的适配器，这里110V的电脑启动失败
			computer110.startUp(powerSource220);
		} catch (Exception e) {
			//错误信息打印
			e.printStackTrace();
		}
		
		//创建110V的电源适配器
		PowerSource powerSourceAdapterFor110V = new PowerSourceAdapter(110);
		//通过适配器的作用，成功启动110V的电脑
		computer110.startUp(powerSourceAdapterFor110V);
		
		ApplePhone phone = new ApplePhone();
		phone.charge(new ApplePowerSourceAdapater());
		System.out.println();

		phone.charge(new ApplePowerSourceAdapater1(powerSource220));
	}
}
