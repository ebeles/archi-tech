package com.example.javaweb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name="summary")
public class Sum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Transient
    private Double total;

    @Transient
    private Integer itemsNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<SumItem> items;

    public Sum() {
        items = new ArrayList<SumItem>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotal() {
        Double sum = 0.0;
        for(SumItem item : this.items) {
            sum = sum + item.getMaterial().getPrice();
        }
        return sum;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getItemsNumber() {
        return this.items.size();
    }

    public void setItemsNumber(Integer itemsNumber) {
        this.itemsNumber = itemsNumber;
    }

    public Collection<SumItem> getItems() {
        return items;
    }

    public void setItems(Collection<SumItem> items) {
        this.items = items;
    }
}
