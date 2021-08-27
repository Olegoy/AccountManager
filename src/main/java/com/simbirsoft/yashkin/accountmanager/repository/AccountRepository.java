package com.simbirsoft.yashkin.accountmanager.repository;

import com.simbirsoft.yashkin.accountmanager.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

}
