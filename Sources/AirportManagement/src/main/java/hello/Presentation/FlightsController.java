package hello.Presentation;

import hello.Business.Flights.Dtos.CreateFlightDto;
import hello.Business.Flights.Dtos.EmbarkPassengerDto;
import hello.Business.Flights.Dtos.FlightDto;
import hello.Business.Flights.EmbarkPassengerCommand;
import hello.Business.Flights.FlightsService;
import hello.Shared.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public final class FlightsController {
    @Autowired
    private FlightsService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<FlightDto>> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody()CreateFlightDto dto) {
        Result result = this.service.create(dto);
        if(result.isSuccess()) {
            return new ResponseEntity(HttpStatus.CREATED);
        }

        return new ResponseEntity(result.getError(), HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/{id}/passengers", method = RequestMethod.PATCH)
    public ResponseEntity embark(@PathVariable  UUID id, @RequestBody() EmbarkPassengerDto dto) {
        EmbarkPassengerCommand command = new EmbarkPassengerCommand();
        command.flightId = id;
        command.passenger = dto.passenger;

        Result result = this.service.embarkNew(command);
        if(!result.isSuccess()) {
            return new ResponseEntity(result.getError(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
