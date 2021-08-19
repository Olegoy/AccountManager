package com.simbirsoft.yashkin.accountmanager.service.impl;

import com.simbirsoft.yashkin.accountmanager.feign.ProjectManagerClient;
import com.simbirsoft.yashkin.accountmanager.feign.ProjectRequestDto;
import com.simbirsoft.yashkin.accountmanager.feign.ProjectStatus;
import com.simbirsoft.yashkin.accountmanager.service.AccountService;
import com.simbirsoft.yashkin.accountmanager.service.ProjectManagerService;
import org.springframework.stereotype.Service;

@Service
public class ProjectManagerServiceImpl implements ProjectManagerService {

    ProjectManagerClient projectManagerClient;
    AccountService accountService;

    public ProjectManagerServiceImpl(ProjectManagerClient projectManagerClient, AccountService accountService) {
        this.projectManagerClient = projectManagerClient;
        this.accountService = accountService;
    }

    @Override
    public void startProject(Long id, Long sum, String description) {
        accountService.withdrawAccount(id, sum, description);
        ProjectRequestDto requestDto = new ProjectRequestDto(ProjectStatus.IN_PROGRESS);
        projectManagerClient.updateProject(id, requestDto);
    }
}
