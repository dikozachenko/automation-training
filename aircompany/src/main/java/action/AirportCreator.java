package action;

import entity.plane.Plane;
import manager.PlaneManager;
import enums.MilitaryPlaneType;

import java.util.Arrays;
import java.util.List;

public class AirportCreator {

    public static List<Plane> getPlanes() {
        return Arrays.asList(PlaneManager.constructPassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                PlaneManager.constructPassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                PlaneManager.constructPassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                PlaneManager.constructPassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                PlaneManager.constructPassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                PlaneManager.constructPassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                PlaneManager.constructPassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
                PlaneManager.constructPassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
                PlaneManager.constructMilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
                PlaneManager.constructMilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
                PlaneManager.constructMilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
                PlaneManager.constructMilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
                PlaneManager.constructMilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
                PlaneManager.constructMilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT));
    }

}
