package com.example.Controller;

import com.example.Model.Payment;
import com.example.Repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "*")
public class PaymentController {
    @Autowired
    private PaymentRepo paymentRepo;

    @PostMapping("/add")
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        if (payment.getProductName() == null || payment.getPrice() <= 0 || payment.getDays() <= 0 ||
                payment.getTotalAmount() <= 0 || payment.getPaymentMethod() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        if ("rent".equalsIgnoreCase(payment.getCategory()) &&
                (payment.getStartDate() == null || payment.getEndDate() == null)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        payment.setOwnerName(userDetails.getUsername());
        Payment savedPayment = paymentRepo.save(payment);
        return ResponseEntity.ok(savedPayment);
    }

    @GetMapping("/history")
    public ResponseEntity<List<Payment>> getOrderHistory(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(List.of());
        }
        String email = userDetails.getUsername();
        List<Payment> payments = paymentRepo.findByOwnerName(email);
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/admin/all")
    public ResponseEntity<List<Payment>> getAllPaymentsAdmin() {
        List<Payment> payments = paymentRepo.findAll();
        return ResponseEntity.ok(payments);
    }
}