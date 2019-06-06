package hello.Domain.Repositories;

import hello.Domain.Airplane;
import hello.Shared.GenericResult;

import java.util.List;
import java.util.UUID;

public interface AirplanesRepository {
    List<Airplane> getAll();
    GenericResult<Airplane> getById(UUID id);
}
