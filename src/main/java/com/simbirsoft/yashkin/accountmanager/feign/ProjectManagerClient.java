package com.simbirsoft.yashkin.accountmanager.feign;

import com.simbirsoft.yashkin.accountmanager.entity.config.ProjectManagerClientConfiguration;
import com.simbirsoft.yashkin.accountmanager.exception.NotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "ProjectManager-service",
        url = "${project.api-base-url}",
        fallback = ProjectManagerClientImpl.class,
        configuration = ProjectManagerClientConfiguration.class
)
public interface ProjectManagerClient {

    @Operation(summary = "Обновление проекта")
    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponseDto> updateProject(@PathVariable Long id,
                                        @RequestBody ProjectRequestDto requestDto);
}
