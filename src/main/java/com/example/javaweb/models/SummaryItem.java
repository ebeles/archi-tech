package com.example.javaweb.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class SummaryItem {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    private Material material;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SummaryItem that = (SummaryItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
