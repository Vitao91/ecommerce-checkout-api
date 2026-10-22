package com.ecommerce.checkout;

import com.ecommerce.checkout.dto.CheckoutRequest;
import com.ecommerce.checkout.dto.CheckoutResponse;
import com.ecommerce.checkout.strategy.CouponDiscountStrategy;
import com.ecommerce.checkout.strategy.DiscountStrategy;
import com.ecommerce.checkout.strategy.NoDiscountStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class CheckoutService {
    private final CouponDiscountStrategy couponStrategy;
    private final NoDiscountStrategy noDiscountStrategy;

    public CheckoutService(CouponDiscountStrategy couponStrategy, NoDiscountStrategy noDiscountStrategy) {
        this.couponStrategy = couponStrategy;
        this.noDiscountStrategy = noDiscountStrategy;
    }

    public CheckoutResponse checkout(CheckoutRequest request) {
        BigDecimal subtotal = request.items().stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);

        boolean hasCoupon = request.coupon() != null && !request.coupon().isBlank();
        DiscountStrategy strategy = hasCoupon ? couponStrategy : noDiscountStrategy;
        BigDecimal discount = strategy.calculateDiscount(subtotal, request.coupon());
        // Cupom desconhecido não concede desconto e é identificado como sem desconto.
        if (discount.signum() == 0) strategy = noDiscountStrategy;

        BigDecimal shipping = request.shipping().setScale(2, RoundingMode.HALF_UP);
        BigDecimal total = subtotal.subtract(discount).add(shipping).setScale(2, RoundingMode.HALF_UP);

        return new CheckoutResponse(subtotal, discount, shipping, total, strategy.name());
    }
}
