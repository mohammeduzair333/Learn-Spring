package com.example.demo;

public class Bill {
    String name;
    int quantity;
    int totalprice;

    public Bill(String name, int quantity, int totalprice) {
        this.name = name;
        this.quantity = quantity;
        this.totalprice = totalprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
}
