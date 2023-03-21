package food.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import food.config.kafka.KafkaProcessor;
import food.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStarted'"
    )
    public void wheneverCookStarted_UpdateStatus(
        @Payload CookStarted cookStarted
    ) {
        CookStarted event = cookStarted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + cookStarted + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookFinished'"
    )
    public void wheneverCookFinished_UpdateStatus(
        @Payload CookFinished cookFinished
    ) {
        CookFinished event = cookFinished;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + cookFinished + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryConfirmed'"
    )
    public void wheneverDeliveryConfirmed_UpdateStatus(
        @Payload DeliveryConfirmed deliveryConfirmed
    ) {
        DeliveryConfirmed event = deliveryConfirmed;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + deliveryConfirmed + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FoodPicked'"
    )
    public void wheneverFoodPicked_UpdateStatus(
        @Payload FoodPicked foodPicked
    ) {
        FoodPicked event = foodPicked;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + foodPicked + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Accepted'"
    )
    public void wheneverAccepted_UpdateStatus(@Payload Accepted accepted) {
        Accepted event = accepted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + accepted + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Rejected'"
    )
    public void wheneverRejected_UpdateStatus(@Payload Rejected rejected) {
        Rejected event = rejected;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + rejected + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }
}
