package com.livgo.cloud.core.swagger;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SwaggerConfiguration.class})
public @interface EnableSwagger {


}
