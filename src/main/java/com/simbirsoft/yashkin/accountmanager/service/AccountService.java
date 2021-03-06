package com.simbirsoft.yashkin.accountmanager.service;

import com.simbirsoft.yashkin.accountmanager.rest.dto.AccountRequestDto;
import com.simbirsoft.yashkin.accountmanager.rest.dto.AccountResponseDto;

import java.util.List;

public interface AccountService {

    List<AccountResponseDto> getAll();

    AccountResponseDto getById(Long id);

    AccountResponseDto addAccount(AccountRequestDto accountRequestDto);

    AccountResponseDto updateAccount(AccountRequestDto accountRequestDto);

    AccountResponseDto deleteAccount(Long id);

    AccountResponseDto depositInAccount(Long id, Long sum);

    AccountResponseDto withdrawAccount(Long id, Long sum, String descripion);

}
