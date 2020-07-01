package org.corebanking.depositaccount.account;

import org.springframework.data.jpa.repository.JpaRepository;

interface AccountBalanceRepository extends JpaRepository<AccountBalance, Long> {

}