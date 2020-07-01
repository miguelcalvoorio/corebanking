package org.corebanking.depositaccount.account;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.EntityModel;

import org.springframework.stereotype.Component;

@Component
public class AccountBalanceModelAssembler implements RepresentationModelAssembler<AccountBalance, EntityModel<AccountBalance>> {
    @Override
    public EntityModel<AccountBalance> toModel(final AccountBalance accountBalance) {
        return EntityModel.of(accountBalance,
            linkTo(methodOn(AccountController.class).getAccountBalance(accountBalance.getAccountId())).withSelfRel());
    }
}