package se.lendo.test.intergration.googleplace.api.client;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha.hasan@gmail.com>}
 */
public class GoogleIntegrationClientImpl implements GoogleIntegrationClient {

    // remove it and change it to spring static bean
    public static final String UTF8_CHARACTER_ENCODING = "UTF-8";

    // remove and change it to spring bean and add it to constructor
    private final HttpClient httpClient = HttpClientBuilder.create().build();

    private String characterEncoding;


    public GoogleIntegrationClientImpl(String characterEncoding) {
        this.characterEncoding = characterEncoding;
    }

    public GoogleIntegrationClientImpl() {
        this(UTF8_CHARACTER_ENCODING);
    }


    public String getCharacterEncoding() {
        return characterEncoding;
    }

    private String readString(HttpResponse response) throws IOException {
        String str = IOUtils.toString(response.getEntity().getContent(), characterEncoding);
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        return str.trim();
    }


    public InputStream getInputStream(String uri) throws IOException {
        HttpGet get = new HttpGet(uri);
        try {
            return httpClient.execute(get).getEntity().getContent();
        } catch (Exception e) {
            throw new IOException(e);
        } finally {
            get.releaseConnection();
        }
    }

    public String getUriData(String uri) {
        return null;
    }

    public String HttpPostData(HttpPost httpPost) {
        return null;
    }
}