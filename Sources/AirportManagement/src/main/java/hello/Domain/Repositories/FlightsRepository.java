package hello.Domain.Repositories;

import hello.Domain.Flight;
import hello.Shared.GenericResult;
import hello.Shared.Result;

import java.util.List;
import java.util.UUID;

public interface FlightsRepository {
    List<Flight> getAll();
    GenericResult<Flight> getById(UUID id);
    Result add(Flight flight);
    Result delete(UUID id);
}
