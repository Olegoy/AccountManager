package com.simbirsoft.yashkin.accountmanager.rest.dto;

import com.simbirsoft.yashkin.accountmanager.entity.AccountEntity;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Владелец счета")
public class OwnerResponseDto {

    @Schema(description = "ID владельца счета")
    private Long id;

    @Schema(description = "Логин владельца счета")
    private String login;

    @Schema(description = "Первое имя владельца счета")
    private String firstName;

    @Schema(description = "Последнее имя владельца счета")
    private String lastName;

    @Schema(description = "Счет клиента")
    private AccountEntity account;

    public OwnerResponseDto() {
    }

    public OwnerResponseDto(Long id, String login, String firstName, String lastName) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public OwnerResponseDto(Long id, String login, String firstName, String lastName, AccountEntity account) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }
}
