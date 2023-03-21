package food.infra;

import food.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/cookings")
@Transactional
public class CookingController {
    @Autowired
    CookingRepository cookingRepository;

    @RequestMapping(
        value = "cookings/{id}/menustatus",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cooking setMenuStatus(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cooking/setMenuStatus  called #####");
        Optional<Cooking> optionalCooking = cookingRepository.findById(id);

        optionalCooking.orElseThrow(() -> new Exception("No Entity Found"));
        Cooking cooking = optionalCooking.get();
        cooking.setMenuStatus();

        cookingRepository.save(cooking);
        return cooking;
    }

    @RequestMapping(
        value = "cookings/{id}/accept",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cooking acceptOrder(
        @PathVariable(value = "id") Long id,
        @RequestBody AcceptOrderCommand acceptOrderCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cooking/acceptOrder  called #####");
        Optional<Cooking> optionalCooking = cookingRepository.findById(id);

        optionalCooking.orElseThrow(() -> new Exception("No Entity Found"));
        Cooking cooking = optionalCooking.get();
        cooking.acceptOrder(acceptOrderCommand);

        cookingRepository.save(cooking);
        return cooking;
    }
}
