package com.simbirsoft.yashkin.accountmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
public class AccountEntity {

    @Id
    @Column(name = "number")
    private Long number;

    @Column(name = "amount")
    private Long amount;

    @JsonIgnore
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumn(name = "account_number")
    private List<OperationEntity> operations;

    public AccountEntity() {
    }

    public AccountEntity(Long number, Long amount) {
        this.number = number;
        this.amount = amount;
    }

    public AccountEntity(Long number, Long amount, List<OperationEntity> operations) {
        this.number = number;
        this.amount = amount;
        this.operations = operations;
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

    public List<OperationEntity> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationEntity> operations) {
        this.operations = operations;
    }
}
