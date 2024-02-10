package com.bank.accounts;

import com.bank.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableProcessApplication // It triggers the deployment of BPMN processes packaged within your Spring Boot application. Deploy programmatically!!
@EnableDiscoveryClient
@EnableFeignClients
/*@ComponentScans({ @ComponentScan("com.bank.accounts.web") })
@EnableJpaRepositories("com.bank.accounts.repository")
@EntityScan("com.bank.accounts.entity")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice REST API Documentation",
				description = "Bank Accounts microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Enayetullah Rasuli",
						email = "info@bank.com",
						url = "https://www.devailab.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.devailab.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "Bank Accounts microservice REST API Documentation",
				url = "https://www.devailab.com/swagger-ui.html"
		)
)
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}


	/* Example of programmatically deploying a camunda process, which needs:
	* @EnableProcessApplication and META-INF/processes.xml */
	@Autowired
	private RuntimeService runtimeService;

	@EventListener
	private void processPostDeploy(PostDeployEvent event) {
		System.out.println("Starting the process");
		runtimeService.startProcessInstanceByKey("loanApproval");
	}
}
