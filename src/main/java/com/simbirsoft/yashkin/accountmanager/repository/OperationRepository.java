package com.simbirsoft.yashkin.accountmanager.repository;

import com.simbirsoft.yashkin.accountmanager.entity.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<OperationEntity, Long> {
}
