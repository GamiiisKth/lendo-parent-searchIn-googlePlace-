package se.lendo.test.googlePlaceApi.endpoint.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha.hasan@gmail.com>}
 */
@Controller
public class SearchPlaceRestService {


    /**
     * the path which will map the request ("/")
     * @return
     */
    @RequestMapping("/")
    public String showHome() {

        return "home";
    }

}
