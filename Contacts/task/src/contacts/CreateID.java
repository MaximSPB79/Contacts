package contacts;

import java.util.concurrent.atomic.AtomicInteger;

public class CreateID {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);

    private final Integer id;

    public CreateID() {
        this.id = idGenerator.getAndIncrement();
    }

    public int getId() {
        return id;
    }
}
