package com.company.application;

import net.kriter.rcsdk.model.APIData;

/**
 * Created by RepCamp on 07/01/15.
 */
public final class ApiDataMaker {

    public static APIData getAPIData() throws Exception
    {
        //API Data to be modified. Retrieve it from a *.properties file or just stick it in your code!

        String url = "http://repcamp.com:3200";
        String username = "your@email.com";
        String password = "Sha1_encrypted_password";
        String secretkey = "your_secret_key";
        String apikey = "your_api_key";
        String apiversion = "v1";

        return new APIData(url, username,password,apikey,secretkey,apiversion);
    }
}
