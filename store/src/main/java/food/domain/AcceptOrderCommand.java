package food.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class AcceptOrderCommand {

    private String orderId;
    private String status;
}
