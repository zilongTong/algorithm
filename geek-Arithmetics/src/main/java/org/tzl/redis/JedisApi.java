/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: JedisApi.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-05-08 07 : 24:31
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-05-08 07 : 24:31> <version>   <desc>
 */

package org.tzl.redis;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class JedisApi {

    private static final Logger LOG = LoggerFactory.getLogger(JedisApi.class);

    private volatile static JedisApi jedisApi;

    /**
     * 保存多个连接源
     */
    private static Map<String, JedisPool> poolMap = new HashMap<String, JedisPool>();

    private JedisApi() {
    }

    /**
     * @Description: jedisPool 池
     * @Param: [ip, port]
     * @return: redis.clients.jedis.JedisPool
     * @Author: imdalai
     * @Date: 2018/1/15
     */
    private static JedisPool getPool(String ip, int port) {

        try {
            String key = ip + ":" + port;
            JedisPool pool = null;
            if (!poolMap.containsKey(key)) {
                JedisPoolConfig config = new JedisPoolConfig();
                //最大空闲连接数
                config.setMaxIdle(10);
                //最大连接数
                config.setMaxTotal(1000);
                //  在获取连接的时候检查有效性, 默认false
                config.setTestOnBorrow(true);
                //  在空闲时检查有效性, 默认false
                config.setTestOnReturn(true);
                pool = new JedisPool(config, ip, port, Protocol.DEFAULT_TIMEOUT, "123", 0, null);
                poolMap.put(key, pool);
            } else {
                pool = poolMap.get(key);
            }
            return pool;
        } catch (Exception e) {
            LOG.error("init jedis pool failed ! " + e.getMessage(), e);
        }
        return null;
    }

    /**
     * @Description: 线程安全单列模式
     * @Param: []
     * @return: JedisApi
     * @Author: imdalai
     * @Date: 2018/1/15
     */
    public static JedisApi getRedisApi() {

        if (jedisApi == null) {
            synchronized (JedisApi.class) {
                if (jedisApi == null) {
                    jedisApi = new JedisApi();
                }
            }
        }
        return jedisApi;
    }

    /**
     * @Description: 获取一个jedis连接
     * @Param: [ip, port]
     * @return: redis.clients.jedis.Jedis
     * @Author: imdalai
     * @Date: 2018/1/15
     */
    public Jedis getRedis(String ip, int port) {
        Jedis jedis = null;
        int count = 0;
        int RETRY_NUM = 5;
        while (jedis == null && count <= RETRY_NUM) {
            try {
                jedis = getPool(ip, port).getResource();
            } catch (Exception e) {
                LOG.error("get redis failed ! " + e.getMessage(), e);
                count++;
            }
        }
        return jedis;
    }

    /**
     * @Description: 释放jedis到jedisPool中
     * @Param: [jedis, ip, port]
     * @return: void
     * @Author: imdalai
     * @Date: 2018/1/15
     */
    public void closeRedis(Jedis jedis) {

        if (jedis != null) {
            try {
                jedis.close();
            } catch (Exception e) {
                LOG.error("colse jedis failed ! " + e.getMessage(), e);
            }
        }
    }
}

