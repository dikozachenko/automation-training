package manager;

import entity.plane.MilitaryPlane;
import entity.plane.PassengerPlane;
import enums.MilitaryPlaneType;

public class PlaneManager {

    public static MilitaryPlane constructMilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryPlaneType militaryPlaneType) {
        return new MilitaryPlane(model, maxSpeed, maxFlightDistance, maxLoadCapacity, militaryPlaneType);
    }

    public static PassengerPlane constructPassengerPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity) {
        return new PassengerPlane(model, maxSpeed, maxFlightDistance, maxLoadCapacity, passengersCapacity);
    }
}
