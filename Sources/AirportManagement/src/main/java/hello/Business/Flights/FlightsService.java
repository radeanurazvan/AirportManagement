package hello.Business.Flights;

import hello.Business.Flights.Dtos.CreateFlightDto;
import hello.Business.Flights.Dtos.FlightDto;
import hello.Shared.Result;

import java.util.List;

public interface FlightsService {
    List<FlightDto> getAll();
    Result create(CreateFlightDto dto);
    Result embarkNew(EmbarkPassengerCommand dto);
}
