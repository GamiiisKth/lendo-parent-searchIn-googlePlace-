package se.lendo.test.googlePlaceApi.endpoint.api;

import io.swagger.annotations.Api;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
    @RequestMapping(value = "/{place}", method = RequestMethod.GET)
    @ResponseBody
    public Place getPlaces(@PathVariable String place, @PathVariable int limit) {

        System.out.println("hej");

        List<Place> places = searchPlaceClient.getPlacesByQuery(place, limit, TypeParam.valueOf("types").searchTypeValue(SearchType.TYPE_GYM));


        return places.get(1);
    }


    /*public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lendo-endpoint-searchIn-googlePlace-client.xml");
        SearchPlaceClient searchPlaceClient = (SearchPlaceClient) context.getBean("searchPlaceClient");

        List<Place> places = searchPlaceClient.getPlacesByQuery("sats", 60, TypeParam.valueOf("types").searchTypeValue(SearchType.TYPE_GYM));

        for (Place place1 : places) {
            System.out.println(place1);
        }

    }*/

}
