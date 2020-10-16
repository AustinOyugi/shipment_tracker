package com.myshipment.tracker.services;

import com.myshipment.tracker.models.Shipment;
import com.myshipment.tracker.models.ShipmentTransaction;
import com.myshipment.tracker.models.User;
import com.myshipment.tracker.repositories.ShipmentRepository;
import com.myshipment.tracker.repositories.ShipmentTransactionRepository;
import com.myshipment.tracker.repositories.UserRepository;
import com.myshipment.tracker.utils.GenerateRandomID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Austin Oyugi
 * @date 10/12/2020
 * @email austinoyugi@gmail.com
 */

@Service
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final UserRepository userRepository;
    private final ShipmentTransactionRepository shipmentTransactionRepository;

    @Autowired
    public ShipmentService(ShipmentRepository shipmentRepository, UserRepository userRepository
            ,ShipmentTransactionRepository shipmentTransactionRepository) {
        this.shipmentRepository = shipmentRepository;
        this.userRepository = userRepository;
        this.shipmentTransactionRepository = shipmentTransactionRepository;
    }

    public ResponseEntity<?> addNewShipment(Shipment shipmentRequest, String userId) {
        Optional<User> user = userRepository.findById(Long.parseLong(userId));
        AtomicReference<Shipment> shipment = new AtomicReference<>(shipmentRequest);
        user.ifPresent(customer -> {
                shipmentRequest.setUserId(user.get().getUserId());
            shipment.set(shipmentRepository.save(shipmentRequest));
        });
        return ResponseEntity.ok(shipment.get());
    }

    public ResponseEntity<?> addShipmentTransaction(ShipmentTransaction shipmentTransactionRequest
            , String trackingNumber) {
        Optional<Shipment> shipment = shipmentRepository.findByTrackingNumber(trackingNumber);
        AtomicReference<ShipmentTransaction> shipmentTransaction = new AtomicReference<>(shipmentTransactionRequest);
        shipment.ifPresent(shipment1 -> {
            shipmentTransactionRequest.setShipment(shipment.get());
            shipmentTransaction.set(shipmentTransactionRepository.save(shipmentTransactionRequest));
        });
        return ResponseEntity.ok(shipmentTransaction.get());
    }

    public ResponseEntity<?> getShipmentNumber(String userId) {
        Optional<User> optionalUser = userRepository.findById(Long.parseLong(userId));
        if (optionalUser.isPresent())
            return ResponseEntity.ok(GenerateRandomID.getRandomId());

        return ResponseEntity.badRequest().body("Error, User Not found");
    }
}
