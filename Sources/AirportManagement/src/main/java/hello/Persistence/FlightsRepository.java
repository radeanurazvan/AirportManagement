package hello.Persistence;

import hello.Domain.Flight;
import hello.Shared.GenericResult;
import hello.Shared.Result;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public final class FlightsRepository  implements hello.Domain.Repositories.FlightsRepository {
    private static List<Flight> flights = new ArrayList<>();

    public List<Flight> getAll() {
        return flights;
    }

    public GenericResult<Flight> getById(UUID id) {
        Optional<Flight> flightOrNothing = flights.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();

        if(flightOrNothing.isEmpty()) {
            return GenericResult.fail("No flight found");
        }

        return GenericResult.ok(flightOrNothing.get());
    }

    public Result add(Flight flight) {
        if(flight == null) {
            return Result.fail("Invalid flight");
        }

        flights.add(flight);
        return Result.ok();
    }

    public Result delete(UUID id) {
        GenericResult<Flight> flightResult = this.getById(id);
        if(!flightResult.isSuccess()) {
            return Result.fail(flightResult.getError());
        }

        flights.remove(flightResult.getValue());
        return Result.ok();
    }
}
