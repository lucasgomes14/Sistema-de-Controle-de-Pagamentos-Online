package com.ifpb.payment.decorator;

import java.math.BigDecimal;

public interface Payment {
    BigDecimal getAmount();
    String getDescription();
}
