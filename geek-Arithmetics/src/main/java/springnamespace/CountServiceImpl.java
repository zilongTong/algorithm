package springnamespace;

/**
 * @ClassName CountServiceImpl
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/1/5 14:48
 **/
public class CountServiceImpl implements CountService {

    private int count = 0;
    public int count() {
        return count ++;
    }
}