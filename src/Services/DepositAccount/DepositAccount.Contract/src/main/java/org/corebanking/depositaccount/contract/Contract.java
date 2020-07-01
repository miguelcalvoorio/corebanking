package org.corebanking.depositaccount.contract;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class Contract {
    private @Id @GeneratedValue Long contractId;
    
    private String accountNumber;
    private String accountProduct;
    private String accountStatus;
    private String accountSetUpDate;
    private String accountLastUpdate;

    Contract() {}
    
    Contract(String accountNumber,String accountProduct, String accountStatus, String accountSetUpDate, String accountLastupdate) {
        this.accountNumber = accountNumber;
        this.accountProduct = accountProduct;
        this.accountStatus = accountStatus;
        this.accountSetUpDate = accountSetUpDate;
        this.accountLastUpdate = accountLastupdate;
    }
}