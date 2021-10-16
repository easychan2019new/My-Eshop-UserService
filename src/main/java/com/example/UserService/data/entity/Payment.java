package com.example.UserService.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@Table(name = "payment")
public class Payment {

    @Id
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "cvv")
    private String cvv;

    @Column(name = "name")
    private String name;

    @Column(name = "valid_until_month")
    private int validUntilMonth;

    @Column(name = "valid_until_year")
    private int validUntilYear;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}
