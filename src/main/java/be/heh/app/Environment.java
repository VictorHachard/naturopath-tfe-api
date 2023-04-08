package be.heh.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Environment {

    //Dev
    //public static final String DATA_FOLDER = "C:/tfe-images/";
    //public static final List<String> ACCESS_CONTROL_ALLOW_ORIGIN_URL = new ArrayList<>(List.of("http://localhost:4200"));

    //Prod
    public static final String DATA_FOLDER = "/var/www/html/naturopath-data/";
    public static final List<String> ACCESS_CONTROL_ALLOW_ORIGIN_URL = new ArrayList<>(Arrays.asList("https://naturopath.victorhachard.fr/"));

}