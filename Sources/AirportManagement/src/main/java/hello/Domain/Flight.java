package hello.Domain;

import hello.Shared.GenericResult;
import hello.Shared.Result;

import java.util.ArrayList;
import java.util.List;

public final class Flight extends Entity {
    private Airplane airplane;
    private List<Passenger> passengers;
    private String departure;
    private String destination;

    private Flight(Airplane airplane, String departure, String destination){
        super();

        this.airplane = airplane;
        this.departure = departure;
        this.destination = destination;

        this.passengers = new ArrayList<>();
    }

    public static GenericResult<Flight> create(Airplane airplane, String departure, String destination) {
        if(airplane == null) {
            return GenericResult.fail("Invalid airplane");
        }

        if(departure == null || departure.isEmpty()) {
            return GenericResult.fail("Invalid departure");
        }

        if(destination == null || destination.isEmpty()) {
            return GenericResult.fail("Invalid departure");
        }

        return GenericResult.ok(new Flight(airplane, departure, destination));
    }

    public Result changeDestination(String destination) {
        if(destination == null || destination.isEmpty()) {
            return Result.fail("Invalid destination");
        }

        if(this.passengers.size() > 1) {
            return Result.fail("Cannot change destination of flight which has passengers!");
        }

        this.destination = destination;
        return Result.ok();
    }

    public Result embarkPassenger(Passenger passenger) {
        if(passenger == null) {
            return Result.fail("Invalid passenger");
        }

        if(this.passengers.size() >= this.airplane.getNumberOfSeats()) {
            return Result.fail("Airplane is full");
        }

        passengers.add(passenger);
        return Result.ok();
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }
}
