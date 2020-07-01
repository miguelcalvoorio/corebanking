package org.corebanking.depositaccount.contract;

public class ContractNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    ContractNotFoundException(Long id) {
        super("Could not found contract " + id);
    }
}