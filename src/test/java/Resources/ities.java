package Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class ities {
    public static RequestSpecification req;

    public RequestSpecification requestSpecification() throws IOException {

        if(req==null){
        PrintStream log=new PrintStream(new FileOutputStream("loggin.txt"));

        req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
            return req;
        }
        return req;
    }
    public static String getGlobalValue(String key) throws IOException {
        Properties pro=new Properties();
        FileInputStream fis=new FileInputStream("src/test/java/Resources/global.properties");
        pro.load(fis);
        return pro.getProperty(key);

    }
    public String getJsonPath(Response response, String key)
    {
        String resp=response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }

}