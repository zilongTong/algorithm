package org.geek.web.importdemo;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName MyImportSelector
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/1/21 14:07
 **/
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"org.geek.web.importdemo.Triangle"};
    }
}
