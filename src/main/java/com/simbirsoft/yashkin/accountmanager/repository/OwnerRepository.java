package com.simbirsoft.yashkin.accountmanager.repository;

import com.simbirsoft.yashkin.accountmanager.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {
}
