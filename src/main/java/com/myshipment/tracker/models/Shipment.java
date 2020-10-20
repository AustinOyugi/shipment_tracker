package com.myshipment.tracker.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myshipment.tracker.models.audit.DateAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Austin Oyugi
 * @date 10/12/2020
 * @email austinoyugi@gmail.com
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Shipment extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipmentId;

    private String shipmentName;

    private boolean delivered;

    private String shipmentCompany;

    private String trackingNumber;

    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    private ShipmentTransaction shipmentTransaction;

    private Long userId;
}
