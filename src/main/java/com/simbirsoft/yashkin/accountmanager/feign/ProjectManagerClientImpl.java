package com.simbirsoft.yashkin.accountmanager.feign;

import com.simbirsoft.yashkin.accountmanager.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ProjectManagerClientImpl implements ProjectManagerClient {

    @Override
    public NotFoundException updateProject(Long id, ProjectRequestDto requestDto) {
        return new NotFoundException("Неудачная попытка. Такого проекта не существует");
    }
}
