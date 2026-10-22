package com.ecommerce.checkout.strategy;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

@Component
public class CouponDiscountStrategy implements DiscountStrategy {
    @Override
    public BigDecimal calculateDiscount(BigDecimal subtotal, String coupon) {
        if (coupon == null) return BigDecimal.ZERO;
        return switch (coupon.trim().toUpperCase(Locale.ROOT)) {
            case "DIO10" -> subtotal.multiply(new BigDecimal("0.10")).setScale(2, RoundingMode.HALF_UP);
            case "DIO20" -> subtotal.multiply(new BigDecimal("0.20")).setScale(2, RoundingMode.HALF_UP);
            default -> BigDecimal.ZERO;
        };
    }

    @Override
    public String name() {
        return "CUPOM";
    }
}
