package fr.societegeneral.bankaccount.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final String BANK_ACCOUNT = "Bank Account";

    Contact contact = new Contact(
            "Taher",
            "https://swagger.io/tools/swagger-ui/", 
            "test@gmail.com"
    );
    
    ApiInfo apiInfo = new ApiInfo("Bank Account API v1",
			"In order to save money, In order to retrieve some or all of my savings, In order to check my operations",
			"Bank Account first version",
			"",
			contact,
			null, null, Collections.emptyList());
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("fr.societegeneral.bankaccount.controller"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag(BANK_ACCOUNT, "Make withdrawals and deposits and see your operations history from your bank account."));

    }
}
