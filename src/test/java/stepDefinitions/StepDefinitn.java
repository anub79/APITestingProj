package stepDefinitions;

import Resources.APIResources;
import Resources.TestDataBuild;
import Resources.ities;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class StepDefinitn extends ities {
    RequestSpecification req;
    ResponseSpecification resspec;
    RequestSpecification res;
    Response response;
    String status_code;
    String response_scope;

    static String Place_id;
    JsonPath jsonPath;
    TestDataBuild p=new TestDataBuild();
    APIResources resourceAPI;
    @Given("AddPlace payload with {string} {string} {string}")
    public void add_place_payload_with(String name,String language,String Address) throws Exception {


        res=given().spec(requestSpecification()).body(p.addPlaceAPIPayload( name, language, Address));
    }

    @When("User calls {string} using {string} http request")
    public void user_calls_using_http_request(String resource, String method) {
        resourceAPI=APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());
        resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        if(method.equalsIgnoreCase("POST"))
            response=res.when().post(resourceAPI.getResource());
        else if (method.equalsIgnoreCase("GET")) {
            response=res.when().get(resourceAPI.getResource());

        }}

    @Then("the API call got success with status code {string}")
    public void the_api_call_got_success_with_status_code(String string) {
        //
        //String status_line=response.getStatusLine();
       // int status_code=response.getStatusCode();

        //Assert.assertTrue(status_line.contains(string));
       // Assert.assertEquals(string,String.valueOf(status_code));
        //assertEquals(string,String.valueOf(response.getStatusCode()));
       // System.out.println("The Status line assertion has Passed...!!!"+status_line);
        assertEquals(response.getStatusCode(),200);

    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String Expectedvalue) {
        //status_code=
        //String expected_obj= JsonPath.from(response.getBody().asString()).getString(string);
      //  assertThat((new Object[]{expected_obj}),is((new Object[]{string2})));
        //String respo=response.asString();
        //JsonPath jsonPath=new JsonPath(respo);
       // Place_id= jsonPath.get("place_id");
        //assertEquals(jsonPath.get(key),ExpectedValue);
        assertEquals(getJsonPath(response,keyValue),Expectedvalue);
   }
    @Then("verify place_Id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
        Place_id=(getJsonPath(response,"place_id"));
        res=given().spec(requestSpecification()).queryParam("place_id",Place_id);
        user_calls_using_http_request(resource, "GET");

        String actual_name= getJsonPath(response,"name");
        assertEquals(expectedName,actual_name);
    }
    @Given("DeletePlace payload")
    public void deletePlace_payload() throws IOException {
        res=given().spec(requestSpecification()).body(p.deletePlacePayload(Place_id));
    }


    @Given("User is on Registration page")
    public void user_is_on_registration_page() {
        System.out.println("User is on Registration page");

    }
    @When("User enters following user details")
    public void user_enters_following_user_details(DataTable dataTable) {
        List<List<String>> userList=dataTable.asLists(String.class);
        for(List<String> e:userList){
            System.out.println(e);
        }
    }
    @Then("user registration should be success")
    public void user_registration_should_be_success() {
        System.out.println("User is able to Register");
    }
}



