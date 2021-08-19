package com.simbirsoft.yashkin.accountmanager.feign;

import com.simbirsoft.yashkin.accountmanager.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectManagerClientImpl implements ProjectManagerClient {

    @Override
    public ResponseEntity<ProjectResponseDto> updateProject(Long id, ProjectRequestDto requestDto) {
        return null;
    }
}
