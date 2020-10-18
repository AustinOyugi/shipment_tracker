package com.myshipment.tracker.controllers;

import com.myshipment.tracker.models.Shipment;
import com.myshipment.tracker.models.ShipmentTransaction;
import com.myshipment.tracker.services.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Austin Oyugi
 * @date 10/12/2020
 * @email austinoyugi@gmail.com
 */

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    private final ShipmentService shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping("add_new_shipment")
    private ResponseEntity<?> addNewShipment(@RequestBody Shipment shipment
            , @RequestParam String userId){
        return shipmentService.addNewShipment(shipment,userId);
    }

    @PostMapping("add_shipment_transaction")
    private ResponseEntity<?> addShipmentTransaction(@RequestBody ShipmentTransaction shipmentTransactionRequest
            , @RequestParam String trackingNumber){
        return shipmentService.addShipmentTransaction(shipmentTransactionRequest,trackingNumber);
    }

    @GetMapping("get_tracking_number")
    private ResponseEntity<?> getShipmentNumber(@RequestParam String userId){
        return shipmentService.getShipmentNumber(userId);
    }

    @GetMapping("all_shipments")
    private ResponseEntity<?> getAllShipment(@RequestParam String userName){
        return shipmentService.getAllShipment(userName);
    }
}