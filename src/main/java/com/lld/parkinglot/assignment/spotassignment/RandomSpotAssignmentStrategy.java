package com.lld.parkinglot.assignment.spotassignment;

import com.lld.parkinglot.models.*;
import com.lld.parkinglot.repository.ParkingLotRepository;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {
    private ParkingLotRepository parkingLotRepository;

    public RandomSpotAssignmentStrategy(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate) {
//        ParkingLot parkingLot = ParkingLotRepository.getParkingLotWithGate();
//        List<ParkingSpot> parkingSpots = ParkingSpotRepository.getParkingSpotsByLot();
//
//        for (ParkingSpot parkingSpot: parkingSpots) {
//            if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) && parkingSpot.getSupportedVehicleTypes().contains(vehicleType)) {
//                return parkingSpot;
//            }
//        }
//        return null;

        return null;
    }
}
