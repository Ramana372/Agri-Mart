package com.example.Controller;

import com.example.Model.Payment;
import com.example.Repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "*")
public class PaymentController {
    @Autowired
    private PaymentRepo paymentRepo;

    @PostMapping("/add")
    public Payment savePayment(@RequestBody Payment payment){
        return paymentRepo.save(payment);
    }
}
