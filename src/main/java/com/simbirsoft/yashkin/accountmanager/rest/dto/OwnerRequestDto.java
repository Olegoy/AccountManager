package com.simbirsoft.yashkin.accountmanager.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Владелец счета")
public class OwnerRequestDto {

    @Schema(description = "ID владельца счета")
    private Long id;

    @Schema(description = "Логин владельца счета")
    private String login;

    @Schema(description = "Пароль владельца счета")
    private String password;

    @Schema(description = "Первое имя владельца счета")
    private String firstName;

    @Schema(description = "Последнее имя владельца счета")
    private String lastName;

    public OwnerRequestDto(String login, String firstName, String lastName) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
