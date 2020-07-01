package org.corebanking.depositaccount.account;

public class AccountNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    AccountNotFoundException(Long id) {
        super("Could not found contract " + id);
    }
}