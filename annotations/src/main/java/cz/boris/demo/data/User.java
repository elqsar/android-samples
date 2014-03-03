package cz.boris.demo.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Boris Musatov on 3.3.14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    public String name;
    public String company;
    public String email;
    public String location;
    public int publicRepos;
}
