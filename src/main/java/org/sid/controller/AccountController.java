package org.sid.controller;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.validation.Valid;
import org.sid.entites.Account;
import org.sid.entites.Statement;
import org.sid.exceptions.AmountNegatifException;
import org.sid.metier.StatementServiceImpl;
import org.sid.repository.AccountRepository;
import org.sid.repository.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class AccountController {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	StatementRepository statementRepository;
	@Autowired
	StatementServiceImpl statementServiceImpl;

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Model model){
		List<Account> accounts= accountRepository.findAll();
		model.addAttribute("accounts", accounts);
		return "index";
	}

	@RequestMapping(value="/DepositView", method=RequestMethod.GET)
	public String DepositView(Model model, Statement statement,@RequestParam(value="id") Long id){
		statement.setAccount(accountRepository.findOne(id));
		model.addAttribute("statement", new Statement());
		model.addAttribute("id", id);
		return "deposit";
	}

	@RequestMapping(value="/deposit", method=RequestMethod.POST)
	public String deposit(Model model,@Valid Statement statement, BindingResult bindingResult,@RequestParam(value="id") Long id ,
			@RequestParam(value="amountDeposit") double mt) throws AmountNegatifException{
		try{
			Account account = accountRepository.findOne(id);
			statementServiceImpl.deposit(mt, id, statement);
			accountRepository.deposit(account.getId(), account.getBalance()+mt);
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			String message= e.getMessage();
			model.addAttribute("exceptionDeposit", e.toString());
			model.addAttribute("message", message);
			
			
		}
		model.addAttribute("id", id);
		model.addAttribute("amountDeposit", mt);
		return "confirmation";
	}


	@RequestMapping(value="/WithdrawalView", method=RequestMethod.GET)
	public String WithdrawalView(Model model, Statement statement,@RequestParam(value="id") Long id){
		statement.setAccount(accountRepository.findOne(id));
		model.addAttribute("statement", new Statement());
		model.addAttribute("id", id);
		return "withdrawal";
	}

	@RequestMapping(value="/withdrawal", method=RequestMethod.POST)
	public String withdrawal(Model model,Statement statement, @RequestParam(value="id") Long id ,
			@RequestParam(value="montantWithdrawal") double mt) throws AmountNegatifException{

		try{
			Account account = accountRepository.findOne(id);
			statementServiceImpl.withdrawal(mt, id, statement);
			accountRepository.withdrawal(id, account.getBalance()-mt);
			
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			String message= e.getMessage();
			System.out.println(message);
			model.addAttribute("exceptionWithdrawal", e);
			model.addAttribute("message", message);
		}
		
		model.addAttribute("id", id);
		model.addAttribute("montantWithdrawal", mt);
		return "confirmation";

	}
	
	@RequestMapping(value="/listStatement", method=RequestMethod.GET)
	public String listStatements(Model model, @RequestParam(value="id") Long id){
		List<Statement> statements= statementRepository.findAll();
		Account account = accountRepository.findOne(id);
		model.addAttribute("statements", statements);
		model.addAttribute("account", account);
		return "statements";
	}
}
