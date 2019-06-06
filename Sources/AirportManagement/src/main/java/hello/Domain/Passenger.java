package hello.Domain;

import hello.Shared.GenericResult;

public final class Passenger extends Entity {
    private String name;

    private Passenger(String name) {
        super();

        this.name = name;
    }

    public static GenericResult<Passenger> Create(String name) {
        if(name == null || name.isEmpty()) {
            return GenericResult.fail("Invalid passenger name");
        }

        return GenericResult.ok(new Passenger(name));
    }

    public String getName() {
        return name;
    }
}
