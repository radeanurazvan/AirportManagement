package hello.Business.Airplanes;

import hello.Domain.Airplane;

import java.util.UUID;

public class AirplaneDto {
    public UUID id;
    public String name;
    public int numberOfSeats;

    public AirplaneDto(Airplane entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.numberOfSeats = entity.getNumberOfSeats();
    }
}
