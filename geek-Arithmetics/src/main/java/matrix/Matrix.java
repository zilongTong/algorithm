package matrix;

public class Matrix {





	private double[][] _h;
	private int _m;
	private int _n;
	public Matrix(int m, int n) throws IllegalParamException {
		if(m < 1) {
			throw new IllegalParamException("illegal value of m in constructor Matrix(m, n): " + m);
		}
		if(n < 1) {
			throw new IllegalParamException("illegal value of n : " + n);
		}
		_h = new double[m][n];
		_m = m;
		_n = n;
	}
	public Matrix(double[][] h) {
		_h = h;
		_m = h.length;
		_n = h[0].length;
	}
	public void setValue(int i, int j, int val) throws IllegalParamException {
		if(i < 0 || j < 0 || i >= _m || j >= _n) {
			throw new IllegalParamException("illegal position : [" + i + "][" + j + "]");
		}
		_h[i][j] = (double) val;
	}

	public Matrix multiBy(Matrix matrix1) throws IllegalParamException {
		return multiBy(matrix1.getH());
	}
	
	public Matrix multiBy(double[][] h1) throws IllegalParamException {
		if(h1 == null) {
			throw new IllegalParamException("the Matrix is null");
		}
		int h_m = h1.length;
		int h_n = h1[0].length;
		if(_n != h_m){
			throw new IllegalParamException("when calculate MatrixA*matrixB, colums of MatrixA must equals to rows of MatrixB." +
					"but " + _n + " is not equals to " + h_m);
		}
		Matrix newMatrix = new Matrix(_m, h_n);
		for(int i = 0; i < _m; i ++) {

			for(int k = 0; k < h_n; k ++) {
				int sum = 0;
				for(int j = 0; j < _n; j ++) {
					sum += _h[i][j] * h1[j][k];
				}
				newMatrix.setValue(i, k, sum);
			}
			
		}
		
		return newMatrix;
	}
	
	public String toString() {
		display();
		return "matrix is display.";
	}
	
	public void display() {
		for(int i = 0; i < _m; i ++) {
			for(int j = 0; j < _n; j ++) {
				System.out.format("%-15f", _h[i][j]);
			}
			System.out.println("\n");
		}
	}
	
	public double[][] getH() {
		return _h;
	}
	public int getRows() {
		return _m;
	}
	public int getColumns() {
		return _n;
	}
	
	public static void main(String[] args) throws IllegalParamException {
		int m = 11, n = 14;
		Matrix matrix = new Matrix(m, n);
		for(int i = 0; i < m; i ++) {
			for(int j = 0; j < n; j ++) {
				matrix.setValue(i, j, (i + 1) * (j + 1) + 3);
			}
		}

		int m1 = 14, n1 = 9;
		Matrix matrix1 = new Matrix(m1, n1);
		for(int i = 0; i < m1; i ++) {
			for(int j = 0; j < n1; j ++) {
				matrix1.setValue(i, j, (i + 1) * (j + 1) + 3);
			}
		}
		
		matrix.multiBy(matrix1.getH()).display();
		
		Matrix mt1 = new Matrix(2, 2);
		Matrix mt2 = new Matrix(2, 3);
		mt1.setValue(0, 0, 1);
		mt1.setValue(0, 1, 1);
		mt1.setValue(1, 0, 2);
		mt1.setValue(1, 1, 0);

		mt2.setValue(0, 0, 0);
		mt2.setValue(0, 1, 2);
		mt2.setValue(0, 2, 3);
		mt2.setValue(1, 0, 1);
		mt2.setValue(1, 1, 1);
		mt2.setValue(1, 2, 2);
		mt1.display();
		mt2.display();
		mt1.multiBy(mt2).display();
	}
}
