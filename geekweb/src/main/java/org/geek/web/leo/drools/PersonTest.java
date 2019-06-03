package org.geek.web.leo.drools;

import org.drools.core.impl.KnowledgeBaseFactory;
import org.geek.web.leo.drools.dynamic.Message;
import org.geek.web.leo.drools.dynamic.TraceLog;
import org.kie.api.KieServices;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @ClassName PersonTest
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/3/20 11:31
 **/
public class PersonTest {
    private static KieContainer container = null;

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        KieServices kieServices = KieServices.Factory.get();


        container = kieServices.getKieClasspathContainer();
        KieSession statefulKieSession1 = container.newKieSession("myAgeSession");
        KieSession statefulKieSession2 = container.newKieSession("AuthRulePackage");
        TraceLog log = new TraceLog();
        log.setJoin_room_success("false");
        Message message = new Message();
        Person person = new Person("duval yang", 12);
        statefulKieSession1.insert(person);
        statefulKieSession1.fireAllRules();
        statefulKieSession2.insert(log);
        statefulKieSession2.insert(message);
        System.out.println(message.getMessage());
        statefulKieSession2.fireAllRules();
        statefulKieSession1.dispose();
    }
}