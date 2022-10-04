package stepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {
    @Before("@DeletePlace")
    public void beforeScenario() throws Exception {
        StepDefinitn m=new StepDefinitn();
        if(StepDefinitn.Place_id==null)
        {
        m.add_place_payload_with("Stephen","Arabic","72,New Blvd" );
        m.user_calls_using_http_request("AddPlaceAPI","POST");
        m.verify_place_id_created_maps_to_using("Stephen","getPlaceAPI");
    }}
}
