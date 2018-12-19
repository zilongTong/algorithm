package list.conbain.array;

import list.conbain.itfc.IDataArray;

/**
 *
 * @author Smile.Wu
 * @version 2015-7-17
 * 差集
 */
public class DataReqExclude implements IDataArray {
	//必须满足的
	private IDataArray reqArray;
	
	//排除
	private IDataArray excludeArray;
	
	private long doc;
	
	public DataReqExclude(IDataArray reqArray, IDataArray excludeArray) {
		this.reqArray = reqArray;
		this.excludeArray = excludeArray;
		this.doc = NO_MORE_DATA;
		if(this.excludeArray != null) {
			this.excludeArray.nextDoc();
		}
	}

	@Override
	public long nextDoc() {
		if(reqArray == null) {
			return doc;
		}
		
		doc = reqArray.nextDoc();
		if(doc == NO_MORE_DATA) {
			reqArray = null;
			return doc;
		}
		
		if(excludeArray == null) {
			return doc;
		}
		
		return doc = toNonExcluded();
	}

	@Override
	public long dataID() {
		return doc;
	}

	@Override
	public long advance(long dataID) {
		while(nextDoc() != NO_MORE_DATA) {
			if(doc >= dataID) {
				return doc;
			}
		}
		return doc;
	}

	/**
	 * 得到下一个不用排除的值，直到结束
	 * @return
	 */
	private long toNonExcluded() {
		//排除的数值
		long exclData = excludeArray.dataID();
		//需要的数值
		long reqData = reqArray.dataID();
		do{
			//需要的数值比排除的数值小，则直接返回需要数值
			if(reqData < exclData) {
				return reqData;
			}
			if(reqData > exclData) {
				//将排除数值，跳转到下一个大于等于 需要数值[reqData]的值
				exclData = excludeArray.advance(reqData);
				if(exclData == NO_MORE_DATA) {	//如果没有排除数值，则返回需要数值
					excludeArray = null;
					return reqData;
				}
				
				//跳转结束，需要数值，小于排除数值，则说明需求值不用被排除，符合结果，返回需要数值
				if(reqData < exclData) {
					return reqData;
				}
			}
			
			//两者相等，则排除该数值，进行下一个需要数值的判断
		} while ((reqData = reqArray.nextDoc()) != NO_MORE_DATA);
		reqArray = null;
		return NO_MORE_DATA;
	}
}
