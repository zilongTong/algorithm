package org.geek.web.leo.drools;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Component;

/**
 * @ClassName RuleEngine
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/3/20 19:36
 **/
@Component
public class RuleEngine {
    private KieSession kSession;

    public Result<Void> initEngine(String ksessionName) {  //初始化ksession，在这里没有把ksession关闭，所以可以重复使用，效率高
        try {
            Result<KieContainer> result = KieContainerFacatory.getKieContainer();
            if (!result.isSuccess()) {
                return Result.buildFail(null, result.getErrorMsg());
            }
            kSession = result.getData().newKieSession(ksessionName);
            return Result.buildSucc(null);
        } catch (Exception e) {
            return Result.buildFail(null, "kieSession初始化出错", e.getMessage());
        }

    }

    public Result<Void> refreshEnginRule(String ksessionName) {  //用来刷新规则，这种实现方式是用不到的，因为规则文件打包在项目中
        try {
                Result<Void> result = initEngine(ksessionName);
            if (!result.isSuccess()) {
                return Result.buildFail(null, result.getErrorMsg());
            }
            return Result.buildSucc(null);
        } catch (Exception e) {
            return Result.buildFail(null, "kieSession刷新出错", e.getMessage());
        }
    }

    public Result<Object> executeRuleEngine(Object data) {
        try {
            kSession.insert(data); //执行规则
            kSession.fireAllRules();
            return Result.buildSucc(data);
        } catch (Exception e) {
            return Result.buildFail(null, "规则执行出错", e.getMessage());
        }
    }
}
