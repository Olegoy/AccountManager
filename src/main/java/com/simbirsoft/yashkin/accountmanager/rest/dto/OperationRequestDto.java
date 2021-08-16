package com.simbirsoft.yashkin.accountmanager.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Операция счета")
public class OperationRequestDto {

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
    private AccountRequestDto account;

    public OperationRequestDto(String type, Long operationSum, Long balanceAfter, LocalDateTime date, AccountRequestDto account) {
        this.type = type;
        this.operationSum = operationSum;
        this.balanceAfter = balanceAfter;
        this.date = date;
        this.account = account;
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

    public AccountRequestDto getAccount() {
        return account;
    }

    public void setAccount(AccountRequestDto account) {
        this.account = account;
    }
}
