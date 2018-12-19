/*
 * Copyright (C),2016-2017. 上海朔羡网络科技有限公司
 * FileName: Converters.java
 * Author:  tongzilong@mgzf.com
 * Date:     2017-12-26 07 : 07:58
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2017-12-26 07 : 07:58> <version>   <desc>
 */

package org.tzl.converters;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static org.tzl.converters.FieldUtilities.isNumeric;

public class Converters {

    private static final Map<String, Field> fieldCache = new ConcurrentHashMap<String, Field>();
    private static final Set<String> baseFields = new HashSet<String>();

    protected static final Logger logger = LoggerFactory.getLogger(Converters.class);

    static {
        baseFields.add("createTime");
        baseFields.add("createUserId");
        baseFields.add("updateTime");
        baseFields.add("updateUserId");
    }

    public static void main(String[] args) {
        GrabOrderPosition go=new GrabOrderPosition();
        go.setCreateUserId(2L);
        go.setGrabOrderTotal(10);
        go.setStatus(1);
        go.setValidRecommendTotal(20);
        GrabOrderPositionModel g = Converters.convertBean(GrabOrderPositionModel.class, go, null);

    }

    private Converters() {
    }

    public static <K, T> Map<K, T> convertMap(Class<T> clazz, Map<K, ?> data, List<String> fields)  {
        if (CollectionUtils.isEmpty(data)) {
            return null;
        }
        Map<K, T> result = new HashMap<K, T>(data.size());
        for (Map.Entry<K, ?> t : data.entrySet()) {
            T convertBean = convertBean(clazz, t.getValue(), fields);
            result.put(t.getKey(), convertBean);
        }
        return result;
    }

    public static <T> List<T> convertList(Class<T> clazz, List<?> data, List<String> fields)  {
        if (CollectionUtils.isEmpty(data)) {
            return Collections.emptyList();
        }
        List<T> list = new ArrayList<T>(data.size());
        
        try {
            for (Object t : data) {
                T convertBean = convertBean(clazz, t, fields);
                if (convertBean != null)
                    list.add(convertBean);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static <T> T toBean(Class<T> clazz, Object data, List<String> fields) {
        try {
            return convertBean(clazz, data, fields);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 对象转化
     * 
     * @param clazz
     * @param data
     * @return
     * @throws Exception
     */
    public static <T> T convertBean(Class<T> clazz, Object data, List<String> fields) {
        try {
            if (data == null) {
                return null;
            }
            T rsp = null;
            rsp = clazz.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            Map<String, Object> fieldValueMap = getFieldValueMap(data);
            if (CollectionUtils.isEmpty(fields)) {
                setValue(clazz, rsp, pds, fieldValueMap);
            } else {
                for (String convertFid : fields) {
                    setValue(clazz, rsp, pds, fieldValueMap, convertFid);
                }
            }
            return rsp;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


    private static <T> void setValue(Class<T> clazz, T rsp, PropertyDescriptor[] pds, Map<String, Object> fieldValueMap) throws Exception,
            IllegalAccessException, InvocationTargetException, ParseException {
        for (PropertyDescriptor pd : pds) {
            Method method = pd.getWriteMethod();
            if (method == null) { // ignore read-only fields
                continue;
            }
            String itemName = pd.getName();
            String fieldName = "";
            Field field;
            if (baseFields.contains(itemName) && BaseModel.class.isAssignableFrom(clazz)) {
                field = getField(BaseModel.class, pd);
            } else {
                field = getField(clazz, pd);
            }
            ApiField jsonField = field.getAnnotation(ApiField.class);
            if (jsonField != null) {
                fieldName = jsonField.value();
            }

            Class<?> typeClass = field.getType();
            Object value = fieldValueMap.get(fieldName);
            if (value != null) {
                if (String.class.isAssignableFrom(typeClass)) {
                    if (value instanceof String) {
                        method.invoke(rsp, value.toString());
                    } else {
                        method.invoke(rsp, value);
                    }
                } else if (Long.class.isAssignableFrom(typeClass)) {
                    if (value instanceof Long) {
                        method.invoke(rsp, (Long) value);
                    } else {
                        if (isNumeric(value)) {
                            method.invoke(rsp, NumberUtils.toLong(String.valueOf(value)));
                        }
                    }
                } else if (Integer.class.isAssignableFrom(typeClass)) {
                    if (value instanceof Integer) {
                        method.invoke(rsp, NumberUtils.toInt(String.valueOf(value)));
                    } else {
                        if (isNumeric(value)) {
                            method.invoke(rsp, NumberUtils.toInt(String.valueOf(value)));
                        }
                    }
                } else if (Boolean.class.isAssignableFrom(typeClass)) {
                    if (value instanceof Boolean) {
                        method.invoke(rsp, (Boolean) value);
                    } else {
                        if (value != null) {
                            method.invoke(rsp, Boolean.valueOf(value.toString()));
                        }
                    }
                } else if (Double.class.isAssignableFrom(typeClass)) {
                    if (value instanceof Double) {
                        method.invoke(rsp, NumberUtils.toDouble(String.valueOf(value)));
                    }
                } else if (Number.class.isAssignableFrom(typeClass)) {
                    if (value instanceof Number) {
                        method.invoke(rsp, (Number) value);
                    }
                } else if (Date.class.isAssignableFrom(typeClass)) {
                    DateFormat format = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
                    format.setTimeZone(TimeZone.getTimeZone(Constants.DATE_TIMEZONE));
                    if (value instanceof Date) {
                        method.invoke(rsp, value);
                    }
                } else if (List.class.isAssignableFrom(typeClass)) {
                    // TODO 暂时不支持
                    throw new Exception("Temporarily does not support to list");
                } else {
                    if (value != null) {
                        method.invoke(rsp, value);
                    }
                }
            } else {
                logger.debug(itemName + " value is null ");
            }
        }
    }

    private static <T> void setValue(Class<T> clazz, T rsp, PropertyDescriptor[] pds, Map<String, Object> fieldValueMap, String convertFid) throws Exception,
            IllegalAccessException, InvocationTargetException, ParseException {
        for (PropertyDescriptor pd : pds) {
            Method method = pd.getWriteMethod();
            if (method == null) { // ignore read-only fields
                continue;
            }
            String itemName = pd.getName();
            String fieldName = "";
            Field field;
            if (baseFields.contains(itemName) && BaseModel.class.isAssignableFrom(clazz)) {
                field = getField(BaseModel.class, pd);
            } else {
                field = getField(clazz, pd);
            }
            ApiField jsonField = field.getAnnotation(ApiField.class);
            if (jsonField != null) {
                fieldName = jsonField.value();
            }

            Class<?> typeClass = field.getType();
            if (convertFid.equals(itemName)) {
                Object value = fieldValueMap.get(fieldName);
                if (String.class.isAssignableFrom(typeClass)) {
                    if (value instanceof String) {
                        method.invoke(rsp, value.toString());
                    } else {
                        if (value != null) {
                            method.invoke(rsp, value.toString());
                        } else {
                            method.invoke(rsp, "");
                        }
                    }
                } else if (Long.class.isAssignableFrom(typeClass)) {
                    if (value instanceof Long) {
                        method.invoke(rsp, (Long) value);
                    } else {
                        if (isNumeric(value)) {
                            method.invoke(rsp, Long.valueOf(value.toString()));
                        }
                    }
                } else if (Integer.class.isAssignableFrom(typeClass)) {
                    if (value instanceof Integer) {
                        method.invoke(rsp, (Integer) value);
                    } else {
                        if (isNumeric(value)) {
                            method.invoke(rsp, Integer.valueOf(value.toString()));
                        } else {
                            throw new Exception(itemName + " is not a Number(Integer)");
                        }
                    }
                } else if (Boolean.class.isAssignableFrom(typeClass)) {
                    if (value instanceof Boolean) {
                        method.invoke(rsp, (Boolean) value);
                    } else {
                        if (value != null) {
                            method.invoke(rsp, Boolean.valueOf(value.toString()));
                        } else {
                            throw new Exception(itemName + " is not a Boolean");
                        }
                    }
                } else if (Double.class.isAssignableFrom(typeClass)) {
                    if (value instanceof Double) {
                        method.invoke(rsp, (Double) value);
                    } else {
                        throw new Exception(itemName + " is not a Double");
                    }
                } else if (Number.class.isAssignableFrom(typeClass)) {
                    if (value instanceof Number) {
                        method.invoke(rsp, (Number) value);
                    } else {
                        throw new Exception(itemName + " is not a Number");
                    }
                } else if (Date.class.isAssignableFrom(typeClass)) {
                    DateFormat format = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
                    format.setTimeZone(TimeZone.getTimeZone(Constants.DATE_TIMEZONE));
                    if (value instanceof String) {
                        method.invoke(rsp, format.parse(value.toString()));
                    } else {
                        throw new Exception(itemName + " is not a Date");
                    }
                } else if (List.class.isAssignableFrom(typeClass)) {
                    // TODO 暂时不支持
                    throw new Exception("Temporarily does not support to list");
                } else {
                    if (value != null) {
                        method.invoke(rsp, value);
                    }
                }
            }
        }
    }

    private static Field getField(Class<?> clazz, PropertyDescriptor pd) throws Exception {
        String key = clazz.getName() + "_" + pd.getName();
        Field field = fieldCache.get(key);
        if (field == null) {// 这个方法不加锁，初始化并发也没关系，无非多put几次
            field = clazz.getDeclaredField(pd.getName());
            fieldCache.put(key, field);
        }
        return field;
    }

    private static Map<String, Object> getFieldValueMap(Object bean) {
        Class<?> cls = bean.getClass();
        Map<String, Object> valueMap = new HashMap<String, Object>();
        Method[] methods = cls.getDeclaredMethods();
        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            try {
                String fieldGetName = parGetName(field.getName());
                if (!checkGetMet(methods, fieldGetName)) {
                    continue;
                }
                Method fieldGetMet = cls.getMethod(fieldGetName, new Class[] {});
                Object fieldVal = fieldGetMet.invoke(bean, new Object[] {});
                valueMap.put(field.getName(), fieldVal);
            } catch (Exception e) {
                continue;
            }
        }
        return valueMap;

    }

    /**
     * 判断是否存在某属性的 get方法
     * 
     * @param methods
     * @param fieldGetMet
     * @return boolean
     */
    private static boolean checkGetMet(Method[] methods, String fieldGetMet) {
        for (Method met : methods) {
            if (fieldGetMet.equals(met.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 拼接某属性的 get方法
     * 
     * @param fieldName
     * @return String
     */
    private static String parGetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }

    // 学历转换 搜索使用
    private static final Map<Integer, List<Integer>> DEGREEIDS = new HashMap<Integer, List<Integer>>(6);

    /**
     * 
     * 功能描述: <br>
     * 〈转换学历〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static List<Integer> convertToDegreeIds(Integer id) {
        if (id != null && id > 0) {
            loadDegreeIds();
            return DEGREEIDS.get(id);
        }
        return null;
    }

    /**
     * 
     * 功能描述: <br>
     * 〈加载学历初始数据给搜索引擎使用 1:本科 3:硕士 4:博士 5:博士后 6:MBA 8:大专 〉
     * 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private static void loadDegreeIds() {
        if (DEGREEIDS==null||DEGREEIDS.isEmpty()) {
            DEGREEIDS.put(1, Arrays.asList(new Integer[] { 1, 3, 4, 5, 6 }));
            DEGREEIDS.put(3, Arrays.asList(new Integer[] { 3, 4, 5 }));
            DEGREEIDS.put(4, Arrays.asList(new Integer[] { 4, 5 }));
            DEGREEIDS.put(5, Arrays.asList(new Integer[] { 5 }));
            DEGREEIDS.put(6, Arrays.asList(new Integer[] { 4, 5, 6 }));
            DEGREEIDS.put(8, Arrays.asList(new Integer[] { 1, 3, 4, 5, 6, 8 }));
        }
    }

}
