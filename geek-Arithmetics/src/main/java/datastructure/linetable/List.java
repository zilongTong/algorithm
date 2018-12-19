package datastructure.linetable;
/**
 * ���Ա�ӿ�
 * �ʹ洢�ṹ�޹�
 * @author Administrator
 *
 */
public interface List {
	// �������Ա�Ĵ�С��������Ԫ�صĸ�����
	public int size();
	
	// �������Ա������Ϊ i ������Ԫ��
	public Object get(int i);

	// ������Ա�Ϊ�շ��� true�����򷵻� false��
	public boolean isEmpty();

	// �ж����Ա��Ƿ��������Ԫ�� e
	public boolean contains(Object e);

	// ��������Ԫ�� e �����Ա��е����
	public int indexOf(Object e);

	// ������Ԫ�� e ���뵽���Ա��� i ��λ��
	public void add(int i, Object e);

	// ������Ԫ�� e ���뵽���Ա�ĩβ
	public void add(Object e);

	// ������Ԫ�� e ���뵽Ԫ�� obj ֮ǰ
	public boolean addBefore(Object obj, Object e);

	// ������Ԫ�� e ���뵽Ԫ�� obj ֮��
	public boolean addAfter(Object obj, Object e);

	// ɾ�����Ա������Ϊ i ��Ԫ��,������֮
	public Object remove(int i);

	// ɾ�����Ա��е�һ���� e ��ͬ��Ԫ��
	public boolean remove(Object e);

	// �滻���Ա������Ϊ i ������Ԫ��Ϊ e������ԭ����Ԫ��
	public Object replace(int i, Object e);

	
}
