import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        System.out.println(findPlanesLeavingInTheNextTwoHours(airport));
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        return airport.getTerminals().stream()
                .flatMap(s -> s.getFlights().stream())
                .filter(flight -> flight.getDate().getTime() < System.currentTimeMillis() + 7_200_000
                        && flight.getDate().getTime() > System.currentTimeMillis() &&
                        flight.getType() == Flight.Type.DEPARTURE)
                .collect(Collectors.toList());
    }

}