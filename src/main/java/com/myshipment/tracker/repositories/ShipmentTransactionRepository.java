package com.myshipment.tracker.repositories;

import com.myshipment.tracker.models.ShipmentTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Austin Oyugi
 * @date 10/13/2020
 * @email austinoyugi@gmail.com
 */

@Repository
public interface ShipmentTransactionRepository extends CrudRepository<ShipmentTransaction,Long> {
}
