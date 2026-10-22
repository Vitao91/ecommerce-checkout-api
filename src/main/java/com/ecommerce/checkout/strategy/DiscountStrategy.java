package com.ecommerce.checkout.strategy;

import java.math.BigDecimal;

public interface DiscountStrategy {
    BigDecimal calculateDiscount(BigDecimal subtotal, String coupon);
    String name();
}
