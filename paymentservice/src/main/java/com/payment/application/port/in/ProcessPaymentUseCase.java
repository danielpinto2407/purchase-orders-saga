package com.payment.application.port.in;

import com.payment.domain.model.Payment;

public interface ProcessPaymentUseCase {
    void processPayment(Payment payment);
}
