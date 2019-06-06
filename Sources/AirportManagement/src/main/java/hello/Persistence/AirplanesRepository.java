package hello.Persistence;

import hello.Domain.Airplane;
import hello.Shared.GenericResult;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public final class AirplanesRepository implements hello.Domain.Repositories.AirplanesRepository {
    private static List<Airplane> airplanes = new ArrayList<Airplane>(){
        {
            add(Airplane.create(10, "Small airplane").getValue());
            add(Airplane.create(30, "Medium airplane").getValue());
            add(Airplane.create(50, "Big airplane").getValue());
            add(Airplane.create(70, "Enterprise airplane").getValue());
        }
    };

    public List<Airplane> getAll() {
        return Collections.unmodifiableList(airplanes);
    }

    public GenericResult<Airplane> getById(UUID id) {
        Optional<Airplane> airplaneOrNothing = airplanes.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();

        if(airplaneOrNothing.isEmpty()){
            return GenericResult.fail("No airplane found");
        }

        return GenericResult.ok(airplaneOrNothing.get());
    }
}
