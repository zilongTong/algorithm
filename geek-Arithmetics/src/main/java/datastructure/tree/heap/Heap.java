/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: Heap.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-09-26 09 : 30:16
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-09-26 09 : 30:16> <version>   <desc>
 */

package datastructure.tree.heap;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Heap {
    private Node[] heapArray;

    private int maxSize;
    private int currentSize;

    public Heap(int mx) {
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }


    public boolean isEmpty() {
        return currentSize == 0 ? true : false;
    }

    public boolean isFull() {
        return currentSize == maxSize ? true : false;
    }



    class Node {
        private int data;

        public Node(int key) {
            data = key;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}