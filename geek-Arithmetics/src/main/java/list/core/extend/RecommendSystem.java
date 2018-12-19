package list.core.extend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import list.conbain.array.DataConjunction;
import list.conbain.itfc.IDataArray;
import list.core.extend.field.FieldKeyValue;
import list.core.extend.query.QueryPair;
import list.core.extend.query.RecommendQuery;

/**
 *
 * @author Smile.Wu
 * @version 2015-10-20
 */
public class RecommendSystem {

	//字段名和字段值集合
	private Map<String, FieldKeyValue> keyFieldMap = new HashMap<String, FieldKeyValue>();
	
	public IDataArray query(RecommendQuery querys) {
		IDataArray mustConjunction = null;
		IDataArray[] mustIDataArrays = fromFieldValue(querys.getMustQuerys());
		if(mustIDataArrays.length > 1) {
			mustConjunction = new DataConjunction(mustIDataArrays);
		} else if(mustIDataArrays.length == 1) {
			mustConjunction = mustIDataArrays[0];
		}
		
		
		return mustConjunction;
	}
	
	private IDataArray[] fromFieldValue(List<QueryPair> qps) {
		List<IDataArray> arrays = new ArrayList<IDataArray>();
		for(QueryPair qp : qps) {
			IDataArray ida = queryField(qp);
			if(ida != null) {
				arrays.add(ida);
			}
		}
		return arrays.toArray(new IDataArray[arrays.size()]);
	}
	
	private IDataArray queryField(QueryPair qp) {
		FieldKeyValue fieldKeyValue = keyFieldMap.get(qp.getField());
		if(fieldKeyValue == null) {
			return null;
		}
		
		return fieldKeyValue.getValueList(qp.getValue());
	}
}
