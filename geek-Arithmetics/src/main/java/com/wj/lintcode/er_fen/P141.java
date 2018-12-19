package com.wj.lintcode.er_fen;

public class P141 {
	private double abs(double v) {
		return v > 0 ? v : v * -1;
	}
	public int sqrt(int x) {
		if(x <= 0) {
			return 0;
		}
		if(x == 1) {
			return 1;
		}
		double  num = 1;
		double c = x;
		do{
			num = (num + x / num) / 2D;
			
			c = abs(num * num - x);
		}while(c > 0.00001);
		return (int)num;
    }
	
	public static void main(String[] args) {
		System.out.println(new P141().sqrt(3));
	}
}
