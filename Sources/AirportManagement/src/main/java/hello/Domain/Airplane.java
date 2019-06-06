package hello.Domain;

import hello.Shared.GenericResult;

public final class Airplane extends Entity{
    private int numberOfSeats;
    private String name;

    private Airplane(int numberOfSeats, String name){
        super();

        this.numberOfSeats = numberOfSeats;
        this.name = name;
    }

    public static GenericResult<Airplane> create(int numberOfSeats, String name) {
        if(name == null || name.isEmpty()) {
            return GenericResult.fail("Invalid name");
        }

        if(numberOfSeats < 1) {
            return GenericResult.fail("Number of seats should be at least 1");
        }

        Airplane airplane = new Airplane(numberOfSeats, name);
        return GenericResult.ok(airplane);
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getName() {
        return name;
    }
}
