package org.geek.web.leo.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;

/**
 * @ClassName KieContainerFacatory
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/3/20 18:07
 **/

public class KieContainerFacatory {
    private static KieContainer kieContainer;

    public static Result<KieContainer> getKieContainer() {
        try {
            if (null == kieContainer) {
                kieContainer = KieServices.Factory.get().getKieClasspathContainer();
                return Result.buildSucc(kieContainer);
            }
            return Result.buildSucc(kieContainer);
        } catch (Exception e) {
            return Result.buildFail(null, "kie容器初始化出错", e.getMessage());
        }

    }
}
