/*
 * Copyright (C),2016-2017. 上海朔羡网络科技有限公司
 * FileName: BaseModel.java
 * Author:  tongzilong@mgzf.com
 * Date:     2017-12-27 10 : 18:29
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2017-12-27 10 : 18:29> <version>   <desc>
 */

package org.tzl.converters;

import java.io.Serializable;
import java.util.Date;

public class BaseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8381936430770425293L;

	@ApiField("createTime")
	private Date createTime;
	
	@ApiField("createUserId")
	private Long createUserId;
	
	@ApiField("updateTime")
	private Date updateTime;
	
	@ApiField("updateUserId")
	private Long updateUserId;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}
	
}
