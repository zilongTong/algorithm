package util.similarity;

public class EuclideanDistance implements Distance {

	public EuclideanDistance() {
	}

    public double getDistance(double[] x, double[] y) {
    	if(x == null || y == null) {
    		return 0.0;
    	}
        double sumXY2 = 0.0;
        for(int i = 0, n = x.length; i < n; i++) {
            sumXY2 += Math.pow(x[i] - y[i], 2);
        }
        return Math.sqrt(sumXY2);
    }

}
