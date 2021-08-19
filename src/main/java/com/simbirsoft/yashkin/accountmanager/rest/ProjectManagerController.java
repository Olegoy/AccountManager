package com.simbirsoft.yashkin.accountmanager.rest;

import com.simbirsoft.yashkin.accountmanager.service.ProjectManagerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Tag(name = "Старт проекта", description = "обновление статуса и старт проекта")
@RestController
@RequestMapping("${project.uri}/payment/")
public class ProjectManagerController {
    ProjectManagerService projectManagerService;

    public ProjectManagerController(ProjectManagerService projectManagerService) {
        this.projectManagerService = projectManagerService;
    }

    @Operation(summary = "Обновление статуса проекта")
    @PutMapping("/{id}")
    public ResponseEntity<String> startProject(@PathVariable Long id,
                                               Long sum, String description) throws IOException {
        // обновление сущности в БД
        projectManagerService.startProject(id, sum, description);

        return ResponseEntity.ok().body(description);
    }
}
