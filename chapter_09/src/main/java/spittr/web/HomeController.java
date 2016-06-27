package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/") //Map controller to /
public class HomeController {

    /* Handle GET requests */
    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home"; /*View name is home*/
    }

}