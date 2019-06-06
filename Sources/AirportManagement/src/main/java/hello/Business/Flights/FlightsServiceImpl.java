package hello.Business.Flights;

import hello.Business.Flights.Dtos.CreateFlightDto;
import hello.Business.Flights.Dtos.EmbarkPassengerDto;
import hello.Business.Flights.Dtos.FlightDto;
import hello.Domain.Airplane;
import hello.Domain.Flight;
import hello.Domain.Passenger;
import hello.Domain.Repositories.AirplanesRepository;
import hello.Domain.Repositories.FlightsRepository;
import hello.Shared.GenericResult;
import hello.Shared.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public final class FlightsServiceImpl implements FlightsService{

    @Autowired
    private AirplanesRepository airplanesRepository;
    @Autowired
    private FlightsRepository flightsRepository;

    @Override
    public List<FlightDto> getAll() {
        return this.flightsRepository.getAll().stream()
                .map(FlightDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public Result create(CreateFlightDto dto) {
        GenericResult<Airplane> airplaneResult = this.airplanesRepository.getById(dto.airplaneId);
        if(!airplaneResult.isSuccess()) {
            return Result.fail(airplaneResult.getError());
        }

        GenericResult<Flight> flightResult = Flight.create(airplaneResult.getValue(), dto.departure, dto.destination);
        if(!flightResult.isSuccess()) {
            return Result.fail(flightResult.getError());
        }

        this.flightsRepository.add(flightResult.getValue());
        return Result.ok();
    }

    @Override
    public Result embarkNew(EmbarkPassengerCommand command) {
        GenericResult<Flight> flightResult = this.flightsRepository.getById(command.flightId);
        if(!flightResult.isSuccess()) {
            return Result.fail(flightResult.getError());
        }

        GenericResult<Passenger> passengerResult = Passenger.create(command.passenger);
        if(!passengerResult.isSuccess()) {
            return Result.fail(passengerResult.getError());
        }

        Result embarkResult = flightResult.getValue().embarkPassenger(passengerResult.getValue());
        if(!embarkResult.isSuccess()) {
            return Result.fail(embarkResult.getError());
        }

        return Result.ok();
    }
}
