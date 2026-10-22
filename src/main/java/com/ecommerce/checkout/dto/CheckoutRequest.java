package com.ecommerce.checkout.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.List;

public record CheckoutRequest(
        @NotEmpty(message = "O pedido precisa ter pelo menos um item")
        List<@NotNull @Positive(message = "Cada item deve ter valor positivo") BigDecimal> items,
        @NotNull @PositiveOrZero(message = "O frete não pode ser negativo")
        BigDecimal shipping,
        String coupon
) {}
