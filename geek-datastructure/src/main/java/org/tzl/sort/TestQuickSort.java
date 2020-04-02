package org.tzl.sort;

import java.util.Arrays;

public class TestQuickSort {
	private static int partition(int[] arr, int low, int high) {
		//ָ����ָ��i����ָ��j
		int i = low;
		int j= high;
		
		//����һ������Ϊ��׼ֵ���ڿ�
		int x = arr[low];
		
		//ʹ��ѭ��ʵ�ַ�������
		while(i<j){//5  8
			//1.���������ƶ�j���ҵ���һ��С�ڻ�׼ֵ��ֵ arr[j]
			while(arr[j]>=x && i<j){
				j--;
			}
			//2.���Ҳ��ҵ�С�ڻ�׼����ֵ���뵽��ߵģ��ӣ�λ�ã� ��ָ�����м��ƶ�һ��λ��i++
			if(i<j){
				arr[i] = arr[j];
				i++;
			}
			//3.���������ƶ�i���ҵ���һ�����ڵ��ڻ�׼ֵ��ֵ arr[i]
			while(arr[i]<x && i<j){
				i++;
			}
			//4.������ҵ��Ĵ�ӡ���ڻ�׼ֵ��ֵ���뵽�ұߵĿ��У���ָ�����м��ƶ�һ��λ�� j--
			if(i<j){
				arr[j] = arr[i];
				j--;
			}
		}
		
		//ʹ�û�׼ֵ��ӣ�����ǻ�׼ֵ������λ��
		arr[i] = x;//arr[j] = y;
		//���ػ�׼ֵ��λ������
		return i; //return j;
	}
	private static void quickSort(int[] arr, int low, int high) {//???�ݹ��ʱ����
		if(low < high){
			//������������һ������ֳ��������������ط�����������
			int index = partition(arr,low,high);
			//����������п���
			quickSort(arr,low,index-1);
			//���ҷ������п���
			quickSort(arr,index+1,high);
		}
	
	}

	public static void quickSort(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		quickSort(arr,low,high);
	}
	
	public static void main(String[] args) {
		//������������
		int arr[] = {72,6,57,88,60,42,83,73,48,85};

		//�����������
		System.out.println(Arrays.toString(arr));
		//��������
		quickSort(arr);
		//partition(arr,0,arr.length-1);
		//�����������
		System.out.println(Arrays.toString(arr));
	}

	
}
