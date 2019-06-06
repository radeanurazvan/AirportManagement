package hello.Business.Flights.Dtos;

import hello.Business.Airplanes.AirplaneDto;
import hello.Domain.Flight;
import hello.Domain.Passenger;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public final class FlightDto {
    public UUID id;
    public AirplaneDto airplane;
    public List<String> passengers;
    public String departure;
    public String destination;

    public FlightDto(Flight entity) {
        this.id = entity.getId();
        this.airplane = new AirplaneDto(entity.getAirplane());
        this.passengers = entity.getPassengers().stream()
                .map(Passenger::getName)
                .collect(Collectors.toList());

        this.departure = entity.getDeparture();
        this.destination = entity.getDestination();
    }

}
