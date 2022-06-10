package com.example.javaweb.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double totalPrice;

    private int itemsNumber;

    public Summary() {
        items = new ArrayList<SummaryItem>();
    }

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<SummaryItem> items;

    private String sessionToken;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        Double sum = 0.0;
        for(SummaryItem item : this.items) {
            sum = sum + item.getMaterial().getPrice();
        }
        return sum;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getItemsNumber() {
        return this.items.size();
    }

    public void setItemsNumber(int itemsNumber) {
        this.itemsNumber = itemsNumber;
    }

    public Collection<SummaryItem> getItems() {
        return items;
    }

    public void setItems(Collection<SummaryItem> items) {
        this.items = items;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
