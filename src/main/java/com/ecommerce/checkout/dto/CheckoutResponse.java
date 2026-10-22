package com.ecommerce.checkout.dto;

import java.math.BigDecimal;

public record CheckoutResponse(
        BigDecimal subtotal,
        BigDecimal discount,
        BigDecimal shipping,
        BigDecimal total,
        String appliedStrategy
) {}
