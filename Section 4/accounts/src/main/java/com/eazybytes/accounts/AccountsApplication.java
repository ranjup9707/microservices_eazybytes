package com.eazybytes.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*As controller, JPA, Entity are in the same package but if it is another package then need to use below annotations:
@ComponentScans({@ComponentScan("com.eazybytes.accounts.audit")})
@EnableJpaRepositories("com.eazybytes.accounts.repository")
@EntityScan("com.eazybytes.accounts.repository") */
// "auditAwareImpl" -> Is From AuditAwareImpl -> @Component("auditAwareImpl")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts Microservice REST API Documentation",
				description = "EazyBank Accounts Microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Ranju Pillai",
						email = "ranju.pillai.com",
						url = "https://ranju.pillai.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://ranju.pillai.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "EazyBank Accounts Microservice REST API Documentation",
				url = "https://ranju.pillai.com"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}
}
