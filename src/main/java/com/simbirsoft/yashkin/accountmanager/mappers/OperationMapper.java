package com.simbirsoft.yashkin.accountmanager.mappers;

import com.simbirsoft.yashkin.accountmanager.entity.OperationEntity;
import com.simbirsoft.yashkin.accountmanager.rest.dto.OperationRequestDto;
import com.simbirsoft.yashkin.accountmanager.rest.dto.OperationResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface OperationMapper {

    OperationEntity operationEntityFromOperationRequestDto(OperationRequestDto operationRequestDto);

    OperationResponseDto operationResponseDtoFromOperationEntity(OperationEntity operationEntity);

}
