package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookStarted extends AbstractEvent {

    private Long id;
    private String orderId;

    public CookStarted(Cooking aggregate) {
        super(aggregate);
    }

    public CookStarted() {
        super();
    }
}
