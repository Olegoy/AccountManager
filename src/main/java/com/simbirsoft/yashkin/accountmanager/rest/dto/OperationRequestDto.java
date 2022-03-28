package com.simbirsoft.yashkin.accountmanager.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Операция счета")
public class OperationRequestDto {

    @JsonIgnore
    @Schema(description = "ID операции счета")
    private Long id;

    @Schema(description = "Описание операции")
    private String description;

    @Schema(description = "Сумма операции")
    private Long operationSum;

    @Schema(description = "Баланс счета после операции")
    private Long balanceAfter;

    @Schema(description = "Дата операции")
    private LocalDateTime date;

    @Schema(description = "Счет")
    private AccountRequestDto account;

    public OperationRequestDto(String description, Long operationSum, Long balanceAfter, LocalDateTime date, AccountRequestDto account) {
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
