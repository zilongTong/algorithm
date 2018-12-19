/*
 * Copyright (C),2016-2017. 上海朔羡网络科技有限公司
 * FileName: DBUniqueIdGenetatorUtil.java
 * Author:  tongzilong@mgzf.com
 * Date:     2017-12-25 11 : 45:04
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2017-12-25 11 : 45:04> <version>   <desc>
 */

package org.tzl.snowFlackIdGen;




import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;


public class DBUniqueIdGenetatorUtil {

    private static final UniqueIdGenerator UNIQUE_ID_GENERATOR = init();
    
    private static UniqueIdGenerator init() {
        int no = getIpNo();
        
        UniqueIdGenerator generator = new UniqueIdGenerator(no % 7);
        
        return generator;
    }
    
    private static int getIpNo() {
        int defaultValue = new Random(System.currentTimeMillis()).nextInt(1023);
        try {
            //本机IP
            String ip = getLocalIp();
            if(!StringUtils.isNotEmpty(ip)) {
                int lastDotIndex = ip.lastIndexOf('.');
                if(lastDotIndex >= 0) {
                    //获取IP最后一簇
                    return NumberUtils.toInt(ip.substring(lastDotIndex), defaultValue);
                }
            }
        } catch (Exception e) { }
        
        return defaultValue;
    }
    
    private static String getLocalIp() throws UnknownHostException {
        try {
            return Inet4Address.getLocalHost().getHostAddress();
        } catch (Exception e) {
            return InetAddress.getLocalHost().getHostAddress();
        }
    }
    
    /**
     * 生成随机不冲突的ID
     */
    public static long randonID() {
        return UNIQUE_ID_GENERATOR.nextId();
    }
    
    public static void main(String[] args) {
        long begin = System.nanoTime();
        
        for (int i = 0; i < 100; i++) {
            Long id = DBUniqueIdGenetatorUtil.randonID();

            System.out.println(Long.toHexString(id));
        }
        long cost = System.nanoTime() - begin;
        
        System.out.println(cost / 1000000F);
    }
}
