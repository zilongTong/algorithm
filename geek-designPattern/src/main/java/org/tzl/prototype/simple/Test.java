package org.tzl.prototype.simple;

public class Test {


    /**
     * 不克隆的话，修改引用对象会影响原对象的值
     * <p>
     * 1、浅克隆，即很表层的克隆，如果我们要克隆对象，只克隆它自身以及它所包含的所有对象的引用地址
     * <p>
     * 2、深克隆，克隆除自身对象以外的所有对象，包括自身所包含的所有对象实例
     *
     * @param args
     */
    public static void main(String[] args) {
        CloneTarget target = new CloneTarget();

        target.setName("leo");
        target.setCloneTarget(new CloneTarget());

        System.out.println(target.getName());
        System.out.println(target.getCloneTarget());

        try {
            CloneTarget target1 = (CloneTarget) target.clone();
            target1.setName("fff");
            System.out.println(target1.getName());
            System.out.println(target.getName());
            System.out.println(target1.getCloneTarget());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
