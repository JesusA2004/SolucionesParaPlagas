package com.modelo.entidad;

import java.util.List;

public class ProductoResponse {
    private List<Producto> value;
    private String nextLink;
    private int count;

    public List<Producto> getValue() {
        return value;
    }

    public void setValue(List<Producto> value) {
        this.value = value;
    }

    public String getNextLink() {
        return nextLink;
    }

    public void setNextLink(String nextLink) {
        this.nextLink = nextLink;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
