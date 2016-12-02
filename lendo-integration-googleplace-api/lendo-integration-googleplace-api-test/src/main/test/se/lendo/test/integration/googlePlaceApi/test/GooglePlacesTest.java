package se.lendo.test.integration.googlePlaceApi.test;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import se.lendo.test.common.googlePlaceApi.param.Param;
import se.lendo.test.common.googlePlaceApi.param.TypeParam;
import se.lendo.test.common.googlePlaceApi.search.SearchType;
import se.lendo.test.integration.googlePlaceApi.domain.Place;
import se.lendo.test.integration.googlePlaceApi.service.GoogleIntegrationServiceImpl;
import se.lendo.test.intergration.googleplace.api.client.GooglePlaceApiSearchClient;
import se.lendo.test.intergration.googleplace.api.client.GooglePlaceApiSearchClientImpl;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.fail;


import static se.lendo.test.intergration.googleplace.api.client.GooglePlaceApiSearchClient.MAXIMUM_PAGE_RESULTS;
import static se.lendo.test.intergration.googleplace.api.client.GooglePlaceApiSearchClient.MAXIMUM_RADIUS_SEARCH;


public class GooglePlacesTest {
    private static final String API_KEY_FILE_NAME = "";
    private static final String TEST_PLACE_NAME = "University of Vermont";
    private static final double TEST_PLACE_LAT = 44.478025, TEST_PLACE_LNG = -73.196475;
    private GooglePlaceApiSearchClient google;

    @Before
    public void setUp() {
        try {
           // InputStream in = GooglePlacesTest.class.getResourceAsStream("/" + API_KEY_FILE_NAME);
            google = new GooglePlaceApiSearchClientImpl("AIzaSyD4ztDjzUZ047Wpqvl36uPiiddocI8p-rY");
            google.setDebugModeEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetNearbyPlacesRankedByDistance() {
        System.out.println("******************** getNearbyPlacesRankedByDistance ********************");
        if (!findPlace(google.getNearbyPlaces(TEST_PLACE_LAT, TEST_PLACE_LNG, MAXIMUM_RADIUS_SEARCH,
                MAXIMUM_PAGE_RESULTS, TypeParam.name("types").value(SearchType.TYPE_UNIVERSITY)), TEST_PLACE_NAME))
            fail("Test place could not be found at coordinates.");

       /* if (!hasAtLeastAPlace(google.getNearbyPlacesRankedByDistance(TEST_PLACE_LAT, TEST_PLACE_LNG, MAXIMUM_PAGE_RESULTS,
                Param.name("name").value(TEST_PLACE_NAME))))
            fail("Test place could not be found at coordinates.");*/
        // contain within one method to prevent threading problemstestGetNearbyPlaces();
    }

    public void testGetNearbyPlaces() {
        System.out.println("******************** getNearbyPlaces ********************");
        if (!findPlace(google.getNearbyPlaces(TEST_PLACE_LAT, TEST_PLACE_LNG, MAXIMUM_RADIUS_SEARCH,
                MAXIMUM_PAGE_RESULTS, TypeParam.name("types").value(SearchType.TYPE_UNIVERSITY)), TEST_PLACE_NAME))
            fail("Test place could not be found at coordinates.");

       /* if (!hasAtLeastAPlace(google.getNearbyPlaces(TEST_PLACE_LAT, TEST_PLACE_LNG, MAXIMUM_RADIUS_SEARCH,
                TypeParam.name("types").value(Arrays.asList(SearchType.BICYCLE_STORE, SearchType.BUS_STATION)))))
            fail("Test place could not be found at coordinates.");
*/
        // testGetPlacesByQuery();
    }


   /* public void testGetPlacesByQuery() {
        System.out.println("******************** getPlacesByQuery ********************");
        if (!findPlace(google.getPlacesByQuery(TEST_PLACE_NAME, MAXIMUM_RESULTS), TEST_PLACE_NAME))
            fail("Test place could not be found by name");
        testGetPlacesByRadar();
    }

    public void testGetPlacesByRadar() {
        System.out.println("******************** getPlacesByRadar ********************");
        List<Place> places = google.getPlacesByRadar(TEST_PLACE_LAT, TEST_PLACE_LNG, MAXIMUM_RADIUS,
                MAXIMUM_RESULTS, Param.name("name").value(TEST_PLACE_NAME));
        boolean found = false;
        for (Place place : places) {
            if (place.getDetails().getName().equals(TEST_PLACE_NAME))
                found = true;
        }
        if (!found)
            fail("Test place could not be found using the radar method.");
    }

   */

    private boolean findPlace(List<Place> places, String name) {
        boolean found = false;
        for (Place place : places) {
            if (place.getName().equals(name))
                found = true;
        }
        return found;
    }
    private boolean hasAtLeastAPlace(List<Place> places) {
        return (places != null) && places.size() > 0;
    }
}
