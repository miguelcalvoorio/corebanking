package org.corebanking.depositaccount.account;

import org.springframework.hateoas.EntityModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private AccountBalanceRepository accountBalanceRepository;
    private AccountBalanceModelAssembler accountBalanceModelAssembler;

    AccountController(AccountBalanceRepository accountBalanceRepository, AccountBalanceModelAssembler accountBalanceModelAssembler) {
        this.accountBalanceRepository = accountBalanceRepository;
        this.accountBalanceModelAssembler = accountBalanceModelAssembler;
    }

    @GetMapping("/accounts/{accountId}/balance")
    public EntityModel<AccountBalance> getAccountBalance(@PathVariable final Long accountId) {
        AccountBalance accountBalance = accountBalanceRepository.findById(accountId)
            .orElseThrow(() -> new AccountNotFoundException(accountId));

        return accountBalanceModelAssembler.toModel(accountBalance);
    }
}