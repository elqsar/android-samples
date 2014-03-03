package cz.boris.demo.network;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import cz.boris.demo.data.User;

/**
 * Created by Boris Musatov on 3.3.14.
 */
@Rest(rootUrl = "https://api.github.com/", converters = {MappingJackson2HttpMessageConverter.class})
public interface SimpleRestClient {
    @Get("users/{name}")
    public User getUser(String name);

}
