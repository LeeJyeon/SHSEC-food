package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Rejected extends AbstractEvent {

    private Long id;
    private String orderId;

    public Rejected(Cooking aggregate) {
        super(aggregate);
    }

    public Rejected() {
        super();
    }
}
