package com.purchaseorders.saga.application.port.out;

import com.purchaseorders.saga.domain.event.OrderEvent;

public interface OrderEventPort {
    void publish(OrderEvent event);
}
