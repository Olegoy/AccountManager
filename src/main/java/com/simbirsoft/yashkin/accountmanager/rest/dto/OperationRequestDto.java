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

    @JsonIgnore
    @Schema(description = "Баланс счета после операции")
    private Long balanceAfter;

    @Schema(description = "Дата операции")
    private LocalDateTime date;

    @Schema(description = "Счет")
    private Long accountNumber;

    public OperationRequestDto() {
    }

    public OperationRequestDto(Long id, String description, Long operationSum, Long balanceAfter, LocalDateTime date, Long accountNumber) {
        this.id = id;
        this.description = description;
        this.operationSum = operationSum;
        this.balanceAfter = balanceAfter;
        this.date = date;
        this.accountNumber = accountNumber;
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

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }
}
