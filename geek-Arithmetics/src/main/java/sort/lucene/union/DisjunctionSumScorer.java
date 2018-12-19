package sort.lucene.union;

import java.util.ArrayList;
import java.util.List;

import sort.lucene.DataSet;
import sort.lucene.MyScorer;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-3-31 上午9:32:46 
 */
public class DisjunctionSumScorer {
	private List<MyScorer> subScorers;
	private ScorerDocQueue scorerDocQueue;

	public DisjunctionSumScorer(MyScorer ... scorers) {
		subScorers = new ArrayList<MyScorer>(scorers.length);
		
		for(MyScorer scorer : scorers) {
			subScorers.add(scorer);
		}
		
		initScorerDocQueue();
	}
	
	public void initScorerDocQueue() {
		scorerDocQueue = new ScorerDocQueue(subScorers.size());
		for(MyScorer scorer : subScorers) {
			if(scorer.next()) {
				scorerDocQueue.insertScorer(scorer);
			}
		}
	}
	
	public void show() {
		scorerDocQueue.show();
	}
	
	public static void main(String[] args) {
		DisjunctionSumScorer disjunctionSumScorer = new DisjunctionSumScorer(DataSet.Scorers.sc1,
						DataSet.Scorers.sc2,
						DataSet.Scorers.sc3,
						DataSet.Scorers.sc4,
						DataSet.Scorers.sc5);
		disjunctionSumScorer.show();
	}
}
