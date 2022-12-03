package com.example.Account.repository;

import com.example.Account.domain.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountUserRepository  extends JpaRepository<AccountUser, Long> {
}
