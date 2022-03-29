package com.simbirsoft.yashkin.accountmanager.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Счет")
public class AccountResponseDto {

    @Schema(description = "Номер счета")
    private Long number;

    @Schema(description = "Сумма счета")
    private Long amount;

    public AccountResponseDto() {
    }

    public AccountResponseDto(Long number, Long amount) {
        this.number = number;
        this.amount = amount;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
