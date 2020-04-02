package org.tzl.search;
/**
 * ǰ�᣺˳��ṹ�����չؼ�������
 * @author Administrator
 *
 */
public class TestSearch2 {

	public static void main(String[] args) {
		//��������
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		//����Ҫ���ҵ�ֵ
		int key =10;
		
		//�����۰���ֲ���
		int index = binarySearch(array,key);
		
		//������
		if(index == -1){
			System.out.println("������");
		}else{
			System.out.println(key+"��������"+index);
		}
	}
	
	
	/**
	 * ��ʹ�õݹ�
	 * T(n) =O(logn)
	 * S(n) =O(1)
	 * @param array
	 * @param key
	 * @return
	 */
	public static int binarySearch(int [] array,int key){
		//ָ��low��high
		int low = 0;
		int high = array.length - 1;		
		
		//�۰����
		while(low <= high){
			//���mid
			int mid = (low+high)/2;
			
			//�ж��Ƿ����
			if(key == array[mid]){
				return mid;
			}else if(key < array[mid]){
				high = mid -1;
			}else{ //key > array[mid]
				low = mid+1;
			}
		}		
		return -1;
	}

}
