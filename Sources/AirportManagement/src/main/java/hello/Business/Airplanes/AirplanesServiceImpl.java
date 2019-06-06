package hello.Business.Airplanes;

import hello.Domain.Repositories.AirplanesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public final class AirplanesServiceImpl implements AirplanesService {

    @Autowired
    private AirplanesRepository repository;

    public List<AirplaneDto> getAll() {
        return repository.getAll().stream()
                .map(AirplaneDto::new)
                .collect(Collectors.toList());
    }
}
