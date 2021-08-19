package com.simbirsoft.yashkin.accountmanager.mappers;

import com.simbirsoft.yashkin.accountmanager.entity.OwnerEntity;
import com.simbirsoft.yashkin.accountmanager.rest.dto.OwnerRequestDto;
import com.simbirsoft.yashkin.accountmanager.rest.dto.OwnerResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

    @Mapper(componentModel = "spring")
    @Component
    public interface OwnerMapper {

        OwnerEntity ownerEntityFromOwnerRequestDto(OwnerRequestDto ownerRequestDto);

        @Mappings({
                @Mapping(target="id", source="ownerEntity.id"),
                @Mapping(target="login", source="ownerEntity.login"),
                @Mapping(target="firstName", source="ownerEntity.firstName"),
                @Mapping(target="lastName", source="ownerEntity.lastName")
        })
        OwnerResponseDto ownerResponseDtoFromOwnerEntity(OwnerEntity ownerEntity);

    }
