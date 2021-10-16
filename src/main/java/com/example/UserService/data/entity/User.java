package com.example.UserService.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Address> addressList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Payment> paymentList = new ArrayList<>();

    public void addPayment(Payment payment){
        if (payment != null) {
            if (paymentList == null) {
                paymentList = new ArrayList<>();
            }

            paymentList.add(payment);
            payment.setUser(this);
        }
    }

    public void addAddress(Address address){
        if (address != null) {
            if (addressList == null) {
                addressList = new ArrayList<>();
            }

            addressList.add(address);
            address.setUser(this);
        }
    }
}
