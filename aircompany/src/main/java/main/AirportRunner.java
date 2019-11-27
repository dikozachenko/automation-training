package main;

import entity.plane.MilitaryPlane;
import entity.plane.PassengerPlane;
import action.AirportCreator;
import action.PlanesSorting;
import entity.airport.Airport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AirportRunner {

    private static final Logger logger = LoggerFactory.getLogger(AirportRunner.class);

    public static void main(String[] args) {
        Airport airport = new Airport(AirportCreator.getPlanes());

        Airport militaryAirport = new Airport(airport.getPlanesOfCertainType(MilitaryPlane.class));
        Airport passengerAirport = new Airport(airport.getPlanesOfCertainType(PassengerPlane.class));

        PlanesSorting.sortPlanesByMaxDistance(militaryAirport);
        logger.info("Military airport sorted by max distance: {}", militaryAirport);

        PlanesSorting.sortPlanesByMaxSpeed(passengerAirport);
        logger.info("Passenger airport sorted by max speed: {}", passengerAirport);

        logger.info("Plane with max passenger capacity: {}", passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }
}
