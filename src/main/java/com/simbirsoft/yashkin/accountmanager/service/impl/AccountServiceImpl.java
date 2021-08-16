package com.simbirsoft.yashkin.accountmanager.service.impl;

import com.simbirsoft.yashkin.accountmanager.entity.AccountEntity;
import com.simbirsoft.yashkin.accountmanager.entity.OwnerEntity;
import com.simbirsoft.yashkin.accountmanager.exception.NotFoundException;
import com.simbirsoft.yashkin.accountmanager.mappers.AccountMapper;
import com.simbirsoft.yashkin.accountmanager.repository.AccountRepository;
import com.simbirsoft.yashkin.accountmanager.repository.OwnerRepository;
import com.simbirsoft.yashkin.accountmanager.rest.dto.AccountRequestDto;
import com.simbirsoft.yashkin.accountmanager.rest.dto.AccountResponseDto;
import com.simbirsoft.yashkin.accountmanager.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final OwnerRepository ownerRepository;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper, OwnerRepository ownerRepository) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public AccountResponseDto getById(Long id) {
        AccountEntity entity = accountRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Account with ID = %d not found", id))
        );

        AccountResponseDto responseDto = accountMapper.accountResponseDtoFromAccountEntity(entity);
        log.info("Account got by id");
        return responseDto;
    }

    @Override
    public AccountResponseDto addAccount(AccountRequestDto accountRequestDto) {
        AccountEntity entity = accountMapper.accountEntityFromAccountRequestDto(accountRequestDto);
        accountRepository.save(entity);

        AccountResponseDto responseDto = accountMapper.accountResponseDtoFromAccountEntity(entity);
        log.info("Account added");
        return responseDto;
    }

    @Override
    public AccountResponseDto updateAccount(Long id, AccountRequestDto accountRequestDto) {
        AccountEntity entity = accountRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Account with ID = %d not found", id))
        );
        entity.setNumber(accountRequestDto.getNumber());
        entity.setAmount(accountRequestDto.getAmount());
        OwnerEntity owner = ownerRepository.getById(accountRequestDto.getId());
        entity.setOwner(owner);
        AccountResponseDto responseDto = accountMapper.accountResponseDtoFromAccountEntity(entity);
        log.info("Account updated");
        return responseDto;
    }

    @Override
    public AccountResponseDto deleteAccount(Long id) {
        AccountEntity entity = accountRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Account with ID = %d not found", id))
        );
        accountRepository.delete(entity);
        AccountResponseDto responseDto = accountMapper.accountResponseDtoFromAccountEntity(entity);
        log.info("Account deleted");
        return responseDto;
    }
}
