package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Accepted extends AbstractEvent {

    private Long id;
    private String orderId;

    public Accepted(Cooking aggregate) {
        super(aggregate);
    }

    public Accepted() {
        super();
    }
}
