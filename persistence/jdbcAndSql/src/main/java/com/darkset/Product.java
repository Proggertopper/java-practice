package com.darkset;

import java.math.BigDecimal;

public record Product(
        int id ,
        String name,
        BigDecimal price,
        int stock
) {
    public boolean isAvailable(){
        return stock > 0;
    }
}
