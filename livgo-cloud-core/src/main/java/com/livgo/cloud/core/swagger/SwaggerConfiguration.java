package com.livgo.cloud.core.swagger;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Description:Swagger Config
 * Author:     gaocl
 * Date:       2018/1/29
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Configuration
@Import({
        Swagger2DocumentationConfiguration.class,
        BeanValidatorPluginsConfiguration.class
})
public class SwaggerConfiguration {

    @Autowired
    private SwaggerProperties swaggerProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "swagger.enabled", matchIfMissing = true)
    public Docket createRestApi() {

        if (swaggerProperties.getBasePath().isEmpty()) {
            swaggerProperties.getBasePath().add("/**");
        }
        List<Predicate<String>> basePath = new ArrayList();
        for (String path : swaggerProperties.getBasePath()) {
            basePath.add(PathSelectors.ant(path));
        }

        List<Predicate<String>> excludePath = new ArrayList();
        for (String path : swaggerProperties.getExcludePath()) {
            excludePath.add(PathSelectors.ant(path));
        }

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalOperationParameters(buildGlobalParameters(swaggerProperties.getGlobalParameters()))
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
                .paths(
                        Predicates.and(
                                Predicates.not(Predicates.or(excludePath)),
                                Predicates.or(basePath)
                        )
                )
                .build();
        return docket;
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .version(swaggerProperties.getVersion())
                .contact(new Contact(swaggerProperties.getContact().getName(),
                        swaggerProperties.getContact().getUrl(),
                        swaggerProperties.getContact().getEmail()))
                .build();

        return apiInfo;

    }

    private List<Parameter> buildGlobalParameters(
            List<SwaggerProperties.GlobalParameters> globalParameters) {
        List<Parameter> parameters = Lists.newArrayList();

        if (Objects.isNull(globalParameters)) {
            return parameters;
        }
        for (SwaggerProperties.GlobalParameters globalParameter : globalParameters) {
            parameters.add(new ParameterBuilder()
                    .name(globalParameter.getName())
                    .description(globalParameter.getDescription())
                    .modelRef(new ModelRef(globalParameter.getModelRef()))
                    .parameterType(globalParameter.getParameterType())
                    .required(Boolean.parseBoolean(globalParameter.getRequired()))
                    .build());
        }
        return parameters;
    }


}
