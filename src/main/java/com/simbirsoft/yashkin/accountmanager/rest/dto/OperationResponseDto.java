package com.simbirsoft.yashkin.accountmanager.rest.dto;

import com.simbirsoft.yashkin.accountmanager.entity.AccountEntity;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Операция счета")
public class OperationResponseDto {

    @Schema(description = "ID операции счета")
    private Long id;

    @Schema(description = "Тип операции")
    private String type;

    @Schema(description = "Сумма операции")
    private Long operationSum;

    @Schema(description = "Баланс счета после операции")
    private Long balanceAfter;

    @Schema(description = "Дата операции")
    private LocalDateTime date;

    @Schema(description = "Счет")
    private AccountResponseDto accountEntity;

    public OperationResponseDto(Long id, String type, Long operationSum, Long balanceAfter, LocalDateTime date, AccountResponseDto accountEntity) {
        this.id = id;
        this.type = type;
        this.operationSum = operationSum;
        this.balanceAfter = balanceAfter;
        this.date = date;
        this.accountEntity = accountEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getOperationSum() {
        return operationSum;
    }

    public void setOperationSum(Long operationSum) {
        this.operationSum = operationSum;
    }

    public Long getBalanceAfter() {
        return balanceAfter;
    }

    public void setBalanceAfter(Long balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public AccountResponseDto getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountResponseDto accountEntity) {
        this.accountEntity = accountEntity;
    }
}
