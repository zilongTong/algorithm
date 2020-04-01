package org.tzl.prototype.deep;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class WuKong extends Monkey implements Cloneable, Serializable {

    private JinGuBang jinGuBang;

    public WuKong() {
    }

    public WuKong(JinGuBang jinGuBang) {
        this.jinGuBang = jinGuBang;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return deepClone();
    }


    public Object deepClone() {
        try {

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            WuKong copy = (WuKong) ois.readObject();
            copy.birthday = new Date();
            return copy;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public WuKong copy(WuKong target) {

        WuKong qiTianDaSheng = new WuKong();
        qiTianDaSheng.height = target.height;
        qiTianDaSheng.weight = target.height;

        qiTianDaSheng.jinGuBang = new JinGuBang();
        qiTianDaSheng.jinGuBang.h = target.jinGuBang.h;
        qiTianDaSheng.jinGuBang.d = target.jinGuBang.d;

        qiTianDaSheng.birthday = new Date();
        return qiTianDaSheng;
    }
}
