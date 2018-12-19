package designpatterns.Observer;

/**
 * Created by zilong on 2017/8/22.
 */
public interface Observer {
    /**
     * 更新接口
     * @param state    更新的状态
     */
    public void update(String state);
}