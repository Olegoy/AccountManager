package com.simbirsoft.yashkin.accountmanager.rest;

import com.simbirsoft.yashkin.accountmanager.rest.dto.OwnerRequestDto;
import com.simbirsoft.yashkin.accountmanager.rest.dto.OwnerResponseDto;
import com.simbirsoft.yashkin.accountmanager.service.OwnerService;
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
import java.util.ArrayList;
import java.util.List;

@Tag(name = "Владельцев счетов", description = "CRUD Владельцев счетов")
@RestController
@RequestMapping("${project.uri}/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Operation(summary = "Получить список владельцев счетов")
    @GetMapping("/")
    public ResponseEntity<List<OwnerResponseDto>> getOwners() {

        List<OwnerResponseDto> results =  new ArrayList<>();
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Получить владельца по id")
    @GetMapping("/{id}")
    public ResponseEntity<OwnerResponseDto> getUserById(@PathVariable Long id) {
        OwnerResponseDto responseDto = ownerService.getById(id);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Добавить владельца")
    @PostMapping("/add/")
    public ResponseEntity<OwnerResponseDto> addUser(@RequestBody OwnerRequestDto requestDto) {
        // добавление в БД
        OwnerResponseDto responseDto = ownerService.addOwner(requestDto);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Обновление владельца")
    @PutMapping("/update/{id}")
    public ResponseEntity<OwnerResponseDto> updateOwner(@PathVariable Long id,
                                                      @RequestBody OwnerRequestDto requestDto) throws IOException {
        // обновление сущности в БД
        OwnerResponseDto responseDto = ownerService.updateOwner(id, requestDto);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Удаление владельца")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable Long id) {
        // удаление сущности из БД
        OwnerResponseDto responseDto = ownerService.deleteOwner(id);

        return new ResponseEntity<>(
                String.format("Владелец с id #%d успешно удален", id),
                HttpStatus.OK
        );
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        //
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
