package com.simbirsoft.yashkin.accountmanager.service.impl;

import com.simbirsoft.yashkin.accountmanager.entity.OwnerEntity;
import com.simbirsoft.yashkin.accountmanager.exception.NotFoundException;
import com.simbirsoft.yashkin.accountmanager.mappers.AccountMapper;
import com.simbirsoft.yashkin.accountmanager.mappers.OwnerMapper;
import com.simbirsoft.yashkin.accountmanager.repository.OwnerRepository;
import com.simbirsoft.yashkin.accountmanager.rest.dto.OwnerRequestDto;
import com.simbirsoft.yashkin.accountmanager.rest.dto.OwnerResponseDto;
import com.simbirsoft.yashkin.accountmanager.service.AccountService;
import com.simbirsoft.yashkin.accountmanager.service.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class OwnerServiceImpl implements OwnerService {

    private static final Logger log = LoggerFactory.getLogger(OwnerServiceImpl.class);

    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    public OwnerServiceImpl(OwnerRepository ownerRepository, OwnerMapper ownerMapper, AccountService accountService, AccountMapper accountMapper) {
        this.ownerRepository = ownerRepository;
        this.ownerMapper = ownerMapper;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<OwnerResponseDto> getAll() {
        List<OwnerEntity> allOwnersEntity = ownerRepository.findAll();
        List<OwnerResponseDto> allOwners = allOwnersEntity.stream()
                .map(ownerMapper::ownerResponseDtoFromOwnerEntity)
                .collect(Collectors.toList());

        log.info("got all Owners");
        return allOwners;
    }

    @Override
    public OwnerResponseDto getById(Long id) throws NullPointerException {
        OwnerEntity entity = ownerRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Owner with ID = %d not found", id))
        );

        OwnerResponseDto responseDto = ownerMapper.ownerResponseDtoFromOwnerEntity(entity);
        log.info("owner got by id");
        return responseDto;
    }

    @Override
    public OwnerResponseDto addOwner(OwnerRequestDto ownerRequestDto) {
        OwnerEntity entity = ownerMapper.ownerEntityFromOwnerRequestDto(ownerRequestDto);

        accountService.addAccount(accountMapper.accountRequestDtoFromAccountEntity(ownerRequestDto.getAccount()));

        ownerRepository.save(entity);
        OwnerResponseDto responseDto = ownerMapper.ownerResponseDtoFromOwnerEntity(entity);
        log.info("owner added");
        return responseDto;
    }

    @Override
    public OwnerResponseDto updateOwner(Long id, OwnerRequestDto ownerRequestDto) throws NullPointerException {
        OwnerEntity entity = ownerRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Owner with ID = %d not found", id))
        );
        entity.setFirstName(ownerRequestDto.getFirstName());
        entity.setLastName(ownerRequestDto.getLastName());
        entity.setLogin(ownerRequestDto.getLogin());
        entity.setPassword(ownerRequestDto.getPassword());
        OwnerResponseDto responseDto = ownerMapper.ownerResponseDtoFromOwnerEntity(entity);
        log.info("owner updated");
        return responseDto;
    }

    @Override
    public OwnerResponseDto deleteOwner(Long id) throws NullPointerException {
        OwnerEntity entity = ownerRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Owner with ID = %d not found", id))
        );
        ownerRepository.delete(entity);
        OwnerResponseDto responseDto = ownerMapper.ownerResponseDtoFromOwnerEntity(entity);
        log.info("owner deleted");
        return responseDto;
    }
}
