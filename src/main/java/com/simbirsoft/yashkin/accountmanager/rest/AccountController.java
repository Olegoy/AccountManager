package com.simbirsoft.yashkin.accountmanager.rest;

import com.simbirsoft.yashkin.accountmanager.rest.dto.AccountRequestDto;
import com.simbirsoft.yashkin.accountmanager.rest.dto.AccountResponseDto;
import com.simbirsoft.yashkin.accountmanager.service.AccountService;
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

@Tag(name = "Счета", description = "CRUD счетов")
@RestController
@RequestMapping("${project.uri}/accounts/")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Operation(summary = "Получить список счетов")
    @GetMapping("/")
    public ResponseEntity<List<AccountResponseDto>> getAccounts() {

        List<AccountResponseDto> results =  accountService.getAll();
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Получить счет по id")
    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDto> getAccountById(@PathVariable Long id) {
        AccountResponseDto responseDto = accountService.getById(id);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Добавить счет")
    @PostMapping("/add/")
    public ResponseEntity<AccountResponseDto> addAccount(@RequestBody AccountRequestDto requestDto) {
        // добавление в БД
        AccountResponseDto responseDto = accountService.addAccount(requestDto);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Обновление счета")
    @PutMapping("/update/{id}")
    public ResponseEntity<AccountResponseDto> updateAccount(@PathVariable Long id,
                                                        @RequestBody AccountRequestDto requestDto) throws IOException {
        // обновление сущности в БД
        AccountResponseDto responseDto = accountService.updateAccount(id, requestDto);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Удаление счета")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        // удаление сущности из БД
        AccountResponseDto responseDto = accountService.deleteAccount(id);

        return new ResponseEntity<>(
                String.format("Счет с id #%d успешно удален", id),
                HttpStatus.OK
        );
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        //
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
