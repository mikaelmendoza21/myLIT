package myLiTAPI;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller
{
    @RequestMapping("/")
    public ActionResponse Home()
    {
        return new ActionResponse("0");
    }
}
