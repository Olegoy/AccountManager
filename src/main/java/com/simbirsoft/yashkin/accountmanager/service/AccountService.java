package com.simbirsoft.yashkin.accountmanager.service;

import com.simbirsoft.yashkin.accountmanager.rest.dto.AccountRequestDto;
import com.simbirsoft.yashkin.accountmanager.rest.dto.AccountResponseDto;

public interface AccountService {

    AccountResponseDto getById(Long id);

    AccountResponseDto addAccount(AccountRequestDto accountRequestDto);

    AccountResponseDto updateAccount(Long id, AccountRequestDto accountRequestDto);

    AccountResponseDto deleteAccount(Long id);
}
