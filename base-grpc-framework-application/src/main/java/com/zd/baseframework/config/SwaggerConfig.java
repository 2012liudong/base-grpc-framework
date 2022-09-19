package com.zd.baseframework.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Title: com.zd.baseframework.config.SwaggerConfig
 * @Description swagger url：http://localhost:18080/swagger-ui.html
 * @author liudong
 * @date 2022/6/15 6:07 PM
 */
@Component
@EnableSwagger2
@ConditionalOnProperty(prefix = "swagger-config", name = "enabled", havingValue = "true")
public class SwaggerConfig {

    @Autowired
    private SwaggerProperties swaggerProperties;

    @Bean
    public Docket createRestApi() {

        Docket docker =  new Docket(DocumentationType.SWAGGER_2)
                .groupName(swaggerProperties.getEnabled())
                .apiInfo(apiInfo())
                .select()
                .apis(basePackage(swaggerProperties.getBasePackage()))
                .paths(PathSelectors.any())
                .build();

        docker.globalOperationParameters(globalParameters());
        docker.securitySchemes(Collections.singletonList(tokenAuthorization()));
        docker.enable(true);
        return docker;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .version(swaggerProperties.getVersion())
                .build();
    }

    private ApiKey tokenAuthorization() {
        return new ApiKey("Authorization", swaggerProperties.authorizationKeyName,
                ApiKeyVehicle.HEADER.getValue());
    }

    /**setting global request paramters*/
    private List<Parameter> globalParameters(){
        List<Parameter> pars = new ArrayList<>();

        //build token
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name(swaggerProperties.authorizationKeyName)
                .description("Authorization-token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        pars.add(tokenPar.build());

        return pars;
    }

    private Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> Optional.fromNullable(input.declaringClass()).transform(handlerPackage(basePackage)).or(true);
    }

    private Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
        return input -> {
            // match restful basePackage path
            for (String strPackage : basePackage.split(",")) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    @Data
    @Component
    @ConfigurationProperties(prefix = "swagger-config")
    public static class SwaggerProperties{

        private String enabled;

        private String title;

        private String description;

        private String version;

        private String basePackage;

        private String authorizationKeyName;

    }

}

