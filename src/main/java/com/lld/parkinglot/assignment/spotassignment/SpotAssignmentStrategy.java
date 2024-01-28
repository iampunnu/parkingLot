package com.lld.parkinglot.assignment.spotassignment;

import com.lld.parkinglot.models.Gate;
import com.lld.parkinglot.models.ParkingSpot;
import com.lld.parkinglot.models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(VehicleType vehicleType, Gate gate);

}
