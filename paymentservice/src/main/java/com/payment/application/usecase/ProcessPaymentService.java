package com.payment.application.usecase;

import com.payment.application.port.in.ProcessPaymentUseCase;
import com.payment.domain.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProcessPaymentService implements ProcessPaymentUseCase {

    @Override
    public void processPayment(Payment payment) {
        log.info("💰 Processing payment for order: {}", payment.getOrderId());
        // Aquí podrías validar, persistir o llamar otro microservicio
    }
}
