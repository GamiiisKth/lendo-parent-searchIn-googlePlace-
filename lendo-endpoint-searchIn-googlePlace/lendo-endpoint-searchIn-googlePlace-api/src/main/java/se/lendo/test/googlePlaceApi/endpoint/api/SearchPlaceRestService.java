package se.lendo.test.googlePlaceApi.endpoint.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import se.lendo.test.common.googlePlaceApi.domain.Place;
import se.lendo.test.common.googlePlaceApi.param.SearchType;
import se.lendo.test.common.googlePlaceApi.param.TypeParam;
import se.lendo.test.search.backend.component.clinet.SearchPlaceClient;

import java.util.List;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha.hasan@gmail.com>}
 */
@RestController("SearchPlaceRestService")
@Api(value = "SearchPlaceRestService-docs")
@RequestMapping("/search")
public class SearchPlaceRestService {

    private SearchPlaceClient searchPlaceClient;

    public SearchPlaceRestService(SearchPlaceClient searchPlaceClient) {
        this.searchPlaceClient = searchPlaceClient;
    }

    /**
     * the path which will map the request ("/")
     *
     * @return
     */
    @RequestMapping(value = "{place}/{radius}", method = RequestMethod.GET)
    @ResponseBody
    public List<Place> getPlaces(@PathVariable String place, @PathVariable int radius) {

      //  System.out.println("hej");

        return searchPlaceClient.getPlacesByQueryBasedOnRadar(place, 60, radius, TypeParam.valueOf("types").searchTypeValue(SearchType.BICYCLE_STORE));


    }


}
