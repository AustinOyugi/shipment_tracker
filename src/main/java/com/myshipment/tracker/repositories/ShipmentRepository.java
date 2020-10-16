package com.myshipment.tracker.repositories;

import com.myshipment.tracker.models.Shipment;
import com.myshipment.tracker.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Austin Oyugi
 * @date 10/12/2020
 * @email austinoyugi@gmail.com
 */

@Repository
public interface ShipmentRepository extends CrudRepository<Shipment,Long> {
    Optional<Shipment> findByUser(User user);
    Optional<Shipment> findByTrackingNumber(String trackingNumber);
}
