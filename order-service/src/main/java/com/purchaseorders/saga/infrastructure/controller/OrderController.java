package com.purchaseorders.saga.infrastructure.controller;

import com.purchaseorders.saga.application.usecase.CreateOrderUseCase;
import com.purchaseorders.saga.infrastructure.controller.dto.CreateOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;

    @PostMapping
    public void createOrder(@RequestBody CreateOrderRequest request) {
        createOrderUseCase.execute(request);
    }
}
