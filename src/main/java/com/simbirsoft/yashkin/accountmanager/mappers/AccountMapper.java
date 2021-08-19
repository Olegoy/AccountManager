package com.simbirsoft.yashkin.accountmanager.mappers;

import com.simbirsoft.yashkin.accountmanager.entity.AccountEntity;
import com.simbirsoft.yashkin.accountmanager.rest.dto.AccountRequestDto;
import com.simbirsoft.yashkin.accountmanager.rest.dto.AccountResponseDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface AccountMapper {

    AccountEntity accountEntityFromAccountRequestDto(AccountRequestDto accountRequestDto);

    AccountResponseDto accountResponseDtoFromAccountEntity(AccountEntity accountEntity);

}
