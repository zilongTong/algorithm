/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: Demo.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-10-15 02 : 05:44
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-10-15 02 : 05:44> <version>   <desc>
 */

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author :tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo {
    static class Counter {
        private static AtomicInteger count = new AtomicInteger(0);

        public static void increment() {
            count.incrementAndGet();
        }

        public static int value() {
            return count.get();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Counter.increment();
            System.out.println("counter: " + Counter.value());
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
