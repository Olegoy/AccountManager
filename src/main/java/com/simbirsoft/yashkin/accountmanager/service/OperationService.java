package com.simbirsoft.yashkin.accountmanager.service;

import com.simbirsoft.yashkin.accountmanager.rest.dto.OperationRequestDto;
import com.simbirsoft.yashkin.accountmanager.rest.dto.OperationResponseDto;

public interface OperationService {

    OperationResponseDto getById(Long id);

    OperationResponseDto addOperation(OperationRequestDto operationRequestDto);

    OperationResponseDto updateOperation(Long id, OperationRequestDto operationRequestDto);

    OperationResponseDto deleteOperation(Long id);
}
