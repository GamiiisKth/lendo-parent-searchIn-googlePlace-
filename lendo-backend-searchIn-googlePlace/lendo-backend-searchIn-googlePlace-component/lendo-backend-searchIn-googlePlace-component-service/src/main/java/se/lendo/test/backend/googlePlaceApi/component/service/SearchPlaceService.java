package se.lendo.test.backend.googlePlaceApi.component.service;

import org.json.JSONObject;

import java.io.InputStream;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha.hasan@gmail.com>}
 */
public interface SearchPlaceService {


    //    JsonObject getSearchDetailes( String type, String where, int radious )

   // this is what we will get from  backend client and we will return a json

   // we should get a PlaceModels from integration side instead
   // solution should be this json object should be mapped to a model in integration-mapper och modelMapper
   JSONObject getSearchDetailes(String type, String where, int radious );
}
