package com.simbirsoft.yashkin.accountmanager.entity;

import javax.persistence.*;
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

    @Column(name = "account_number")
    private Long accountNumber;

//    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
//    @JoinColumn(name = "account_number")
//    private AccountEntity accountEntity;

    public OperationEntity() {
    }

    public OperationEntity(Long id, String description, Long operationSum, Long balanceAfter, LocalDateTime date) {
        this.id = id;
        this.description = description;
        this.operationSum = operationSum;
        this.balanceAfter = balanceAfter;
        this.date = date;
    }

    public OperationEntity(Long id, String description, Long operationSum, Long balanceAfter, LocalDateTime date, Long accountNumber) {
        this.id = id;
        this.description = description;
        this.operationSum = operationSum;
        this.balanceAfter = balanceAfter;
        this.date = date;
        this.accountNumber = accountNumber;
    }

    //    public OperationEntity(Long id, String description, Long operationSum, Long balanceAfter, LocalDateTime date, AccountEntity accountEntity) {
//        this.id = id;
//        this.description = description;
//        this.operationSum = operationSum;
//        this.balanceAfter = balanceAfter;
//        this.date = date;
//        this.accountEntity = accountEntity;
//    }

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

    //    public AccountEntity getAccountEntity() {
//        return accountEntity;
//    }
//
//    public void setAccountEntity(AccountEntity accountEntity) {
//        this.accountEntity = accountEntity;
//    }
//
}
