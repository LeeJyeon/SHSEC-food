package food.infra;

import food.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class OrderHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Order>> {

    @Override
    public EntityModel<Order> process(EntityModel<Order> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/pay")
                .withRel("pay")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/cancel")
                .withRel("cancel")
        );

        return model;
    }
}
