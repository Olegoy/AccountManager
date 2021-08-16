package com.simbirsoft.yashkin.accountmanager.rest;

import com.simbirsoft.yashkin.accountmanager.rest.dto.OperationRequestDto;
import com.simbirsoft.yashkin.accountmanager.rest.dto.OperationResponseDto;
import com.simbirsoft.yashkin.accountmanager.service.OperationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Tag(name = "Операции со счетом", description = "CRUD Операций со счетом")
@RestController
@RequestMapping("${project.uri}/operations/")
public class OperationController {

    private final OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @Operation(summary = "Получить список операций")
    @GetMapping("/")
    public ResponseEntity<List<OperationResponseDto>> getOperations() {

        List<OperationResponseDto> results =  operationService.getAll();
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Получить операцию по id")
    @GetMapping("/{id}")
    public ResponseEntity<OperationResponseDto> getOperationById(@PathVariable Long id) {
        OperationResponseDto responseDto = operationService.getById(id);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Добавить операцию")
    @PostMapping("/add/")
    public ResponseEntity<OperationResponseDto> addOperation(@RequestBody OperationRequestDto requestDto) {
        // добавление в БД
        OperationResponseDto responseDto = operationService.addOperation(requestDto);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Обновление операции")
    @PutMapping("/update/{id}")
    public ResponseEntity<OperationResponseDto> updateOperation(@PathVariable Long id,
                                                        @RequestBody OperationRequestDto requestDto) throws IOException {
        // обновление сущности в БД
        OperationResponseDto responseDto = operationService.updateOperation(id, requestDto);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Удаление операции")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOperation(@PathVariable Long id) {
        // удаление сущности из БД
        OperationResponseDto responseDto = operationService.deleteOperation(id);

        return new ResponseEntity<>(
                String.format("Операция с id #%d успешно удален", id),
                HttpStatus.OK
        );
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        //
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
