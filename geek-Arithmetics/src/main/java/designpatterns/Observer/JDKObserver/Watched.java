package designpatterns.Observer.JDKObserver;

import java.util.Observable;

/**
 * Created by zilong on 2017/8/30.
 */
public class Watched extends Observable {

    private String data = "";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if(!this.data.equals(data)){
            this.data = data;
            setChanged();
        }
        notifyObservers();
    }

}
