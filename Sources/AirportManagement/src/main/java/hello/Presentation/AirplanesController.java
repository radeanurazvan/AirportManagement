package hello.Presentation;


import hello.Business.Airplanes.AirplaneDto;
import hello.Business.Airplanes.AirplanesService;
import hello.Domain.Airplane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/airplanes")
public class AirplanesController {

    @Autowired
    private AirplanesService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<AirplaneDto>> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }
}
