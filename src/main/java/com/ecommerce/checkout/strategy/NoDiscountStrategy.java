package com.ecommerce.checkout.strategy;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public BigDecimal calculateDiscount(BigDecimal subtotal, String coupon) {
        return BigDecimal.ZERO;
    }

    @Override
    public String name() {
        return "SEM_DESCONTO";
    }
}
