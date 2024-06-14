package com.ednilton.picpay.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name="tb_transfer")
public class Transfer {

    public Transfer() {
    }

    public Transfer(Wallet sender, Wallet receiver, BigDecimal value) {
        this.sender = sender;
        this.receiver = receiver;
        this.value = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "wallet_sender_id")
    private Wallet sender;

    @ManyToOne
    @JoinColumn(name = "wallet_receiver_id")
    private Wallet receiver;

    @Column(name = "value")
    private BigDecimal value;

}
