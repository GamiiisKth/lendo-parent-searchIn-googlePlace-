package se.lendo.test.intergration.googleplace.api.client;

import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha.hasan@gmail.com>}
 *
 *  request forwarder to google api
 */


public interface GoogleIntegrationClient {


    InputStream getInputStream(String uri) throws IOException;

    String getUriData(String uri);

    String HttpPostData(HttpPost httpPost);



}
