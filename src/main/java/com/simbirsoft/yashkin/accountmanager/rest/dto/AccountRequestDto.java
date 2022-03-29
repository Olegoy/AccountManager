package com.simbirsoft.yashkin.accountmanager.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Счет")
public class AccountRequestDto {

    @Schema(description = "Номер счета")
    private Long number;

    @Schema(description = "Сумма счета")
    private Long amount;

    public AccountRequestDto() {
    }

    public AccountRequestDto(Long number, Long amount) {
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
