package analyze.also.device;

public class NoPeopleDevice implements IWeightingDevice {

	public int contain(String word) {
		return 0;
	}

	public String toString() {
		return "NoPeopleDevice 未确定人群";
	}
}
