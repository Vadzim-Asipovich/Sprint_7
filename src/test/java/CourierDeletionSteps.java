import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;

public class CourierDeletionSteps {
    private CourierAPI api = new CourierAPI();
    private ValidatableResponse response;
    @Step("Delete courier by ID")
    public void deleteCourier(String id){
        response = api.deleteCourier(id).then();
    }
    @Step("Check if response shows that deletion was successful")
    public void checkIfDeletionSuccessful(){
        response.assertThat().statusCode(200).and().body("ok",equalTo(true));
    }
}
