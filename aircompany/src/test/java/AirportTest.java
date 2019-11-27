import entity.plane.ExperimentalPlane;
import action.AirportCreator;
import action.PlanesSorting;
import entity.airport.Airport;
import enums.ClassificationPlaneLevel;
import enums.MilitaryPlaneType;
import org.testng.Assert;
import org.testng.annotations.Test;
import entity.plane.PassengerPlane;
import entity.plane.Plane;

import java.util.List;

public class AirportTest {

    @Test
    public void getTransportMilitaryPlanes() {
        Airport airport = new Airport(AirportCreator.getPlanes());
        Assert.assertTrue(airport.getMilitaryPlanesOfCertainType(MilitaryPlaneType.TRANSPORT)
                .stream()
                .allMatch(militaryPlane -> MilitaryPlaneType.TRANSPORT.equals(militaryPlane.getMilitaryPlaneType())));
    }

    @Test
    public void sortByMaxLoadCapacity() {
        Airport airport = new Airport(AirportCreator.getPlanes());
        PlanesSorting.sortPlanesByMaxLoadCapacity(airport);
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();

        boolean planesAreSorted = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            if (planesSortedByMaxLoadCapacity.get(i).getMaxLoadCapacity() > planesSortedByMaxLoadCapacity.get(i + 1).getMaxLoadCapacity()) {
                planesAreSorted = false;
                break;
            }
        }
        Assert.assertTrue(planesAreSorted);
    }

    @Test
    public void hasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(AirportCreator.getPlanes());
        Assert.assertTrue(airport.getMilitaryPlanesOfCertainType(MilitaryPlaneType.BOMBER)
                .stream()
                .allMatch(militaryPlane ->  MilitaryPlaneType.BOMBER.equals(militaryPlane.getMilitaryPlaneType())));
    }

    @Test
    public void experimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        Airport airport = new Airport(AirportCreator.getPlanes());
        Assert.assertFalse(airport.getPlanesOfCertainType(ExperimentalPlane.class)
                .stream()
                .allMatch(experimentalPlane -> ClassificationPlaneLevel.UNCLASSIFIED
                        .equals(experimentalPlane.getClassificationPlaneLevel())));
    }

    @Test
    public void getPassengerPlaneWithMaxCapacity() {
        PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);
        Airport airport = new Airport(AirportCreator.getPlanes());
        Assert.assertTrue(airport.getPassengerPlaneWithMaxPassengersCapacity()
                .equals(planeWithMaxPassengerCapacity));
    }
}
