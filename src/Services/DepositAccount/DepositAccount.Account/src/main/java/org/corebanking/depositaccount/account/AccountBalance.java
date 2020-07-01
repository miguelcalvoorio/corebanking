package org.corebanking.depositaccount.account;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class AccountBalance {
    private @Id @GeneratedValue Long accountId;
    
    private String accountNumber;
    private String accountProduct;
    private Double accountBalanceAmmout;
    private Double accountAvailableBalanceAmount;
    private String accountLastUpdate;

    AccountBalance() {}

    AccountBalance(String accountNumber,String accountProduct, Double accountBalanceAmmount, Double accountAvailableBlanceAmount, String accountLastupdate) {
        this.accountNumber = accountNumber;
        this.accountProduct = accountProduct;
        this.accountBalanceAmmout = accountBalanceAmmount;
        this.accountAvailableBalanceAmount = accountAvailableBlanceAmount;
        this.accountLastUpdate = accountLastupdate;
    }
}