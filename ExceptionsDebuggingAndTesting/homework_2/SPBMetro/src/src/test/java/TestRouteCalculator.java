import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class TestRouteCalculator extends TestCase {


    private StationIndex stationIndex = new StationIndex();
    private Line line1 = new Line(1, "First line");
    private Line line2 = new Line(2, "Second line");
    private Line line3 = new Line(3, "Third line");
    private Station station1 = new Station("Павловская", line1);
    private Station station2 = new Station("Петровская", line1);
    private Station station3 = new Station("Московская", line1);
    private Station station4 = new Station("Одиночная", line2);
    private Station station5 = new Station("Питерская", line2);
    private Station station6 = new Station("Иркутская", line2);
    private Station station7 = new Station("Красноярская", line3);
    private Station station8 = new Station("Оренбуржская", line3);
    private Station station9 = new Station("Кемеровская", line3);

    private List<Station> stationList;
    private List<Station> connectedStations;
    private List<Station> route;


    @Override
    protected void setUp() throws Exception {
        stationIndex.addLine(line1);
        stationIndex.addStation(station1);
        line1.addStation(station1);
        stationIndex.addStation(station2);
        line1.addStation(station2);
        stationIndex.addStation(station3);
        line1.addStation(station3);
        stationIndex.addLine(line2);
        stationIndex.addStation(station4);
        line2.addStation(station4);
        stationIndex.addStation(station5);
        line2.addStation(station5);
        stationIndex.addStation(station6);
        line2.addStation(station6);
        stationIndex.addLine(line3);
        stationIndex.addStation(station7);
        line3.addStation(station7);
        stationIndex.addStation(station8);
        line3.addStation(station8);
        stationIndex.addStation(station9);
        line3.addStation(station9);

        stationList = new ArrayList<>();
        stationList.addAll(line1.getStations());
        stationList.addAll(line2.getStations());
        stationList.addAll(line3.getStations());

        connectedStations = new ArrayList<>();
        connectedStations.add(station3);
        connectedStations.add(station4);
        stationIndex.addConnection(connectedStations);
        connectedStations.clear();
        connectedStations.add(station6);
        connectedStations.add(station7);
        stationIndex.addConnection(connectedStations);
        connectedStations.clear();

        route = new ArrayList<>();
        route.add(station3);
        route.add(station4);
        route.add(station5);
        route.add(station6);
        route.add(station7);

    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 12;
        assertEquals(expected, actual);
    }

    public void testGetRouteOnTheLine() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        List<Station> actual = routeCalculator.getShortestRoute(station1, station3);
        route.clear();
        route.add(station1);
        route.add(station2);
        route.add(station3);
        assertEquals(route, actual);
    }

    public void testGetRouteWithOneConnection() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        List<Station> actual = routeCalculator.getShortestRoute(station1, station5);
        route.clear();
        route.add(station1);
        route.add(station2);
        route.add(station3);
        route.add(station4);
        route.add(station5);
        assertEquals(route, actual);
    }

    public void testGetRouteWithTwoConnection() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        List<Station> actual = routeCalculator.getShortestRoute(station1, station8);
        route.clear();
        route.add(station1);
        route.add(station2);
        route.add(station3);
        route.add(station4);
        route.add(station5);
        route.add(station6);
        route.add(station7);
        route.add(station8);
        assertEquals(route, actual);
    }

    @Override
    protected void tearDown() throws Exception {
    }
}
