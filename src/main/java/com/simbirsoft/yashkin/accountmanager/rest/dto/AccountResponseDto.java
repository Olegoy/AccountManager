package com.simbirsoft.yashkin.accountmanager.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Счет")
public class AccountResponseDto {

    @Schema(description = "ID счета")
    private Long id;

    @Schema(description = "Номер счета")
    private Long number;

    @Schema(description = "Сумма счета")
    private Long amount;

    @Schema(description = "Владелец счета")
    private OwnerResponseDto owner;

    public AccountResponseDto(Long id, Long number, Long amount, OwnerResponseDto owner) {
        this.id = id;
        this.number = number;
        this.amount = amount;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public OwnerResponseDto getOwner() {
        return owner;
    }

    public void setOwner(OwnerResponseDto owner) {
        this.owner = owner;
    }
}
