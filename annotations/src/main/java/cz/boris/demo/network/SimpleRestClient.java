package cz.boris.demo.network;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import cz.boris.demo.data.User;

/**
 * Created by Boris Musatov on 3.3.14.
 */
@Rest(rootUrl = RouteConstants.ROOT_URL, converters = {MappingJackson2HttpMessageConverter.class})
public interface SimpleRestClient {

    @Get(RouteConstants.USER_ROUTE)
    public User getUser(String name);
}
