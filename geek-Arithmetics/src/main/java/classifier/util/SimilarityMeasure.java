package classifier.util;

import java.io.Serializable;

public interface SimilarityMeasure extends Serializable {

	public double similarity(String[] x, String[] y);
}
