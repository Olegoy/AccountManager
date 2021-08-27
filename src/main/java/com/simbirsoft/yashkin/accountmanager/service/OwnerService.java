package com.simbirsoft.yashkin.accountmanager.service;

import com.simbirsoft.yashkin.accountmanager.rest.dto.OwnerRequestDto;
import com.simbirsoft.yashkin.accountmanager.rest.dto.OwnerResponseDto;

import java.util.List;

public interface OwnerService {

    List<OwnerResponseDto> getAll();

    OwnerResponseDto getById(Long id);

    OwnerResponseDto addOwner(OwnerRequestDto ownerRequestDto);

    OwnerResponseDto updateOwner(Long id, OwnerRequestDto ownerRequestDto);

    OwnerResponseDto deleteOwner(Long id);
}
