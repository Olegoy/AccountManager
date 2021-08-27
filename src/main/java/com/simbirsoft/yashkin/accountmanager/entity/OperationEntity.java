package com.simbirsoft.yashkin.accountmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "operations")
public class OperationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "operation_sum")
    private Long operationSum;

    @Column(name = "balance_after")
    private Long balanceAfter;

    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    private AccountEntity account;

    public OperationEntity() {
    }

    public OperationEntity(Long id, String description, Long operationSum, Long balanceAfter, LocalDateTime date, AccountEntity account) {
        this.id = id;
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

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }
}
