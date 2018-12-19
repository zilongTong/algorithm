package designpatterns.Observer;

/**
 * Created by zilong on 2017/8/22.
 */
public class ConcreteSubject extends Subject {

    private String state;
    private String getState(){
        return state;
    }
    public  void change(String newState){
        state=newState;
        System.out.printf("主题状态为："+state);
        //状态改变通知观察者
        this.nodifyObservers(state);
    }
}
