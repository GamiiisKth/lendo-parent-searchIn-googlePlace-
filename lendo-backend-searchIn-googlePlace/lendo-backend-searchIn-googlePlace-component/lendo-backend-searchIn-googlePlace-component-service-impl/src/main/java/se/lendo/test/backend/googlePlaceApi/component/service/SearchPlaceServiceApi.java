package se.lendo.test.backend.googlePlaceApi.component.service;

import org.json.JSONObject;
import se.lendo.test.intergration.googleplace.api.client.GooglePlaceApiSearchClient;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha.hasan@gmail.com>}
 */
public class SearchPlaceServiceApi implements SearchPlaceService {

    // create a bean and inject implementation to it
    private GooglePlaceApiSearchClient inegrationSearchClient;

    private JSONObject jsonObject;


    public JSONObject getSearchDetailes(String type, String where, int radious) {
        return null;
    }
}
