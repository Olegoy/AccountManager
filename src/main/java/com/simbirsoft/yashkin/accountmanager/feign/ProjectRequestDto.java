package com.simbirsoft.yashkin.accountmanager.feign;

import io.swagger.v3.oas.annotations.media.Schema;

public class ProjectRequestDto {

    @Schema(description = "Статус проекта")
    private ProjectStatus status;

    public ProjectRequestDto(ProjectStatus status) {
        this.status = status;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }
}
