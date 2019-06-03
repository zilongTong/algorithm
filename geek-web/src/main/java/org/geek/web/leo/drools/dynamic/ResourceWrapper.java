package org.geek.web.leo.drools.dynamic;

import org.kie.api.io.Resource;

/**
 * 资源包装类
 *
 * @author caicongyang1
 * @version id: ResourceWrapper, v 0.1 16/10/26 下午2:15 caicongyang1 Exp $$
 */
public class ResourceWrapper {
    private Resource resource;

    private String targetResourceName;

    public ResourceWrapper(Resource resource, String targetResourceName) {
        this.resource = resource;
        this.targetResourceName = targetResourceName;
    }

    public Resource getResource() {
        return resource;
    }

    public String getTargetResourceName() {
        return targetResourceName;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void setTargetResourceName(String targetResourceName) {
        this.targetResourceName = targetResourceName;
    }
}