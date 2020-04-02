package org.tzl.stackqueue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * ʮ����ת���ɶ�����
 * 
 * @author Administrator
 *
 */
public class TestConvert {

	public static void main(String[] args) {
		
		//����һ��ʮ������
		int n = 100;
		
		//��ʮ������ת���ɶ�����
		int t = n;//������
		//String str = "";
		//����һ����ջ
		Deque stack  = new LinkedList();
		do{
			//����2������
			int mod = t % 2;			
			//�������
			//System.out.println(mod);
			//str =mod +str;
			//��ջ
			stack.push(mod);
			//����2�õ���
			//int result = t / 2;
			//ʹ������������
			//t = result;
			t = t /2 ;
			
		}while(t>0);//��>0
		
		//������
		System.out.print(n+"------>");
		while(!stack.isEmpty()){//ջ�ǿ�
			System.out.print(stack.pop());
		}

	}

}
