/*
 * Copyright (C),2016-2017. 上海朔羡网络科技有限公司
 * FileName: FieldUtilities.java
 * Author:  tongzilong@mgzf.com
 * Date:     2017-12-27 10 : 15:39
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2017-12-27 10 : 15:39> <version>   <desc>
 */

package org.tzl.converters;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.Map.Entry;

public class FieldUtilities {
	
	public static void main(String[] args) {
		String fields = "position.positionId,position.title,candidate.candidateId,group.groupId,operation.operationId";
//		Map<String, List<String>> convertToMap = convertToMap(fields );
//		Set<Entry<String, List<String>>> entrySet = convertToMap.entrySet();
//		for (Entry<String, List<String>> entry : entrySet) {
//			String key = entry.getKey();
//			List<String> value = entry.getValue();
//			System.out.println(key + "   "  + value.toString());
//		}
//
	}
//
//	public static Map<String,List<String>> convertToMap(String fields){
//		Map<String,List<String>> map = new HashMap<String, List<String>>();
//		if(StringUtils.isNotEmpty(fields)){
//			String[] split = fields.split(",");
//			FieldType[] values = FieldType.values();
//			for (FieldType fieldType : values) {
//				String name = fieldType.getValue();
//				List<String> fieldList = new ArrayList<String>();
//				for (String field : split) {
//					String[] _field = field.split("\\.");
//					if(name.equals(_field[0])){
//						fieldList.add(_field[1]);
//					}
//				}
//				map.put(name, fieldList);
//			}
//		}
//		return map ;
//	}

    public static boolean isNumeric(Object obj) {
        if (obj == null) {
            return false;
        }
        char[] chars = obj.toString().toCharArray();
        int length = chars.length;
        if (length < 1)
            return false;

        int i = 0;
        if (length > 1 && chars[0] == '-')
            i = 1;

        for (; i < length; i++) {
            if (!Character.isDigit(chars[i])) {
                return false;
            }
        }
        return true;
    }
}
