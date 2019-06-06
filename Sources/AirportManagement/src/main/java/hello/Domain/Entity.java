package hello.Domain;

import java.util.UUID;

public abstract class Entity {
    private UUID id;

    protected Entity(){
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return this.id;
    }
}
