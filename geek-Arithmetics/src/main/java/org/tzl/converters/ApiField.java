/*
 * Copyright (C),2016-2017. 上海朔羡网络科技有限公司
 * FileName: ApiField.java
 * Author:  tongzilong@mgzf.com
 * Date:     2017-12-27 10 : 18:53
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2017-12-27 10 : 18:53> <version>   <desc>
 */

package org.tzl.converters;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
 * @author dolf.zhang@hunteron.com
 * @Description api 字段对应 
 * @Date  2014年12月18日 下午3:21:07
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD })
public @interface ApiField {

	public String value() default "";

}
