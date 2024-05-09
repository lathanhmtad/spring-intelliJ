package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderTrackingNumber;
    private int totalQuantity;
    private BigDecimal totalPrice;
    private String status;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

//    @OneToOne(cascade = {
//            CascadeType.MERGE,
//            CascadeType.DETACH
//    })
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
//    private Address billingAddress;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private Address billingAddress;

//    OneToMany: unidirectional mapping
    // default fetch type one to many is Lazy
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "order_id", referencedColumnName = "id")
//    private Set<OrderItem> orderItems = new HashSet<>();

    // OneToMany; bidirectional mapping
    // mappedBy will tells hibernate that we are using one to many bidirectional mapping
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    private Set<OrderItem> orderItems = new HashSet<>();

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderTrackingNumber='" + orderTrackingNumber + '\'' +
                ", totalQuantity=" + totalQuantity +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

    public BigDecimal getTotalAmount() {
        BigDecimal amount = new BigDecimal(0.0);

        for (OrderItem item : this.orderItems) {
            amount = amount.add(item.getPrice());
        }
        return amount;
    }
}
