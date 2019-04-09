package org.sid;


import java.util.Date;

import org.sid.repository.AccountRepository;
import org.sid.repository.StatementRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AccountManagerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(AccountManagerApplication.class, args);
		AccountRepository accountRepository = ctx.getBean(AccountRepository.class);
		StatementRepository statementRepository = ctx.getBean(StatementRepository.class);
		
	
	}

}
