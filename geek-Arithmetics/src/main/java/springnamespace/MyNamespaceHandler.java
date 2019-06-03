package springnamespace;

/**
 * @ClassName MyNamespaceHandler
 * @Author Leo
 * @Description //TODO
 * @Date: 2018/12/20 11:12
 **/
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("leooo", new LeoBeanDefinitionParser());
    }
}