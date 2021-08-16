package com.simbirsoft.yashkin.accountmanager.mappers;

import com.simbirsoft.yashkin.accountmanager.entity.OwnerEntity;
import com.simbirsoft.yashkin.accountmanager.rest.dto.OwnerRequestDto;
import com.simbirsoft.yashkin.accountmanager.rest.dto.OwnerResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

    @Mapper(componentModel = "spring")
    @Component
    public interface OwnerMapper {

        OwnerEntity ownerEntityFromOwnerRequestDto(OwnerRequestDto ownerRequestDto);

        OwnerResponseDto ownerResponseDtoFromOwnerEntity(OwnerEntity ownerEntity);

        void updateOwnerEntityFromOwnerRequestDto(OwnerRequestDto ownerRequestDto, @MappingTarget OwnerEntity ownerEntity);

        void updateOwnerResponseDtoFromOwnerEntity(OwnerEntity ownerEntity, @MappingTarget OwnerResponseDto ownerResponseDto);
    }
