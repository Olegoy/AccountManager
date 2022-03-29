package com.simbirsoft.yashkin.accountmanager.service.impl;

import com.simbirsoft.yashkin.accountmanager.entity.AccountEntity;
import com.simbirsoft.yashkin.accountmanager.entity.OperationEntity;
import com.simbirsoft.yashkin.accountmanager.exception.NotFoundException;
import com.simbirsoft.yashkin.accountmanager.mappers.AccountMapper;
import com.simbirsoft.yashkin.accountmanager.mappers.OperationMapper;
import com.simbirsoft.yashkin.accountmanager.repository.AccountRepository;
import com.simbirsoft.yashkin.accountmanager.repository.OperationRepository;
import com.simbirsoft.yashkin.accountmanager.rest.dto.AccountRequestDto;
import com.simbirsoft.yashkin.accountmanager.rest.dto.OperationRequestDto;
import com.simbirsoft.yashkin.accountmanager.rest.dto.OperationResponseDto;
import com.simbirsoft.yashkin.accountmanager.service.AccountService;
import com.simbirsoft.yashkin.accountmanager.service.OperationService;
import com.simbirsoft.yashkin.accountmanager.service.kafka.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OperationServiceImpl implements OperationService {


    private static final Logger log = LoggerFactory.getLogger(OperationServiceImpl.class);

    private final OperationRepository operationRepository;
    private final OperationMapper operationMapper;
    private final AccountRepository accountRepository;
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    public OperationServiceImpl(OperationRepository operationRepository, OperationMapper operationMapper, AccountRepository accountRepository, AccountService accountService, AccountMapper accountMapper) {
        this.operationRepository = operationRepository;
        this.operationMapper = operationMapper;
        this.accountRepository = accountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<OperationResponseDto> getAll() {
        List<OperationEntity> allOperationsEntity = operationRepository.findAll();
        List<OperationResponseDto> allOperations = allOperationsEntity.stream()
                .map(operationMapper::operationResponseDtoFromOperationEntity)
                .collect(Collectors.toList());

        log.info("got all Operations");
        return allOperations;
    }

    @Override
    public OperationResponseDto getById(Long id) {
        OperationEntity entity = operationRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Operation with ID = %d not found", id))
        );

        OperationResponseDto responseDto = operationMapper.operationResponseDtoFromOperationEntity(entity);
        log.info("Operation got by id");
        return responseDto;
    }

    @Override
    public OperationResponseDto addOperation(OperationRequestDto operationRequestDto) {
        OperationEntity entity = operationMapper.operationEntityFromOperationRequestDto(operationRequestDto);
        entity.setDate(LocalDateTime.now());
        AccountEntity accountEntity = accountMapper.accountEntityFromAccountResponseDto(accountService.getById(operationRequestDto.getAccountNumber()));
        if (accountEntity.getAmount() - operationRequestDto.getOperationSum() >= 0) {
            accountService.updateAccount(new AccountRequestDto(operationRequestDto.getAccountNumber()
                    , accountEntity.getAmount() - operationRequestDto.getOperationSum()
            ));
        } else {
            throw new NotFoundException("Недостаточно средств");
        }
        entity.setBalanceAfter(accountEntity.getAmount() - operationRequestDto.getOperationSum());
        operationRepository.save(entity);

        OperationResponseDto responseDto = operationMapper.operationResponseDtoFromOperationEntity(entity);
        log.info("Operation added");
        return responseDto;
    }

    @Override
    public OperationResponseDto updateOperation(Long id, OperationRequestDto operationRequestDto) {
        OperationEntity entity = operationRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Operation with ID = %d not found", id))
        );
        entity.setDescription(operationRequestDto.getDescription());
        entity.setOperationSum(operationRequestDto.getOperationSum());
        entity.setBalanceAfter(operationRequestDto.getBalanceAfter());
        AccountEntity accountEntity = accountRepository.getById(operationRequestDto.getId());
//        entity.setAccount(accountEntity);
        OperationResponseDto responseDto = operationMapper.operationResponseDtoFromOperationEntity(entity);
        log.info("Operation updated");
        return responseDto;
    }

    @Override
    public OperationResponseDto deleteOperation(Long id) {
        OperationEntity entity = operationRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Operation with ID = %d not found", id))
        );
        operationRepository.delete(entity);
        OperationResponseDto responseDto = operationMapper.operationResponseDtoFromOperationEntity(entity);
        log.info("Operation deleted");
        return responseDto;
    }

}
