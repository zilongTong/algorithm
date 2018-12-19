package analyze.also;

public class Word {

	private String _value;
	
	private float _oldeighing = 1f;
	
	private float _newWeighing;

	public Word(String v) {
		_value = v;
	}
	public Word(String v, float old) {
		_value = v;
		_oldeighing = old;
	}
	
	public String get_value() {
		return _value;
	}
	public void set_value(String _value) {
		this._value = _value;
	}
	public float get_oldeighing() {
		return _oldeighing;
	}
	public void set_oldeighing(float _oldeighing) {
		this._oldeighing = _oldeighing;
	}
	public float get_newWeighing() {
		return _newWeighing;
	}
	public void set_newWeighing(float weighing) {
		_newWeighing = weighing;
	}
}
