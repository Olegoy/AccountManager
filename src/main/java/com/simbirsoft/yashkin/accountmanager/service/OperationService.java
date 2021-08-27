package com.simbirsoft.yashkin.accountmanager.service;

import com.simbirsoft.yashkin.accountmanager.rest.dto.OperationRequestDto;
import com.simbirsoft.yashkin.accountmanager.rest.dto.OperationResponseDto;

import java.util.List;

public interface OperationService {

    List<OperationResponseDto> getAll();

    OperationResponseDto getById(Long id);

    OperationResponseDto addOperation(OperationRequestDto operationRequestDto);

    OperationResponseDto updateOperation(Long id, OperationRequestDto operationRequestDto);

    OperationResponseDto deleteOperation(Long id);
}
