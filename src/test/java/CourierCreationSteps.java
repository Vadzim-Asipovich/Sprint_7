import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;

public class CourierCreationSteps {
    private CourierAPI api = new CourierAPI();
    private ValidatableResponse response;
    @Step("Create a courier")
    public void createCourier(Courier courier) {
        response = api.createCourier(courier).then();
    }
    @Step("Check if response is successful")
    public void checkUserCreationSuccessfulResponse(){
        response
                .assertThat()
                .statusCode(201)
                .and()
                .body("ok",equalTo(true));
    }
    @Step("Check if response shows that the login already exists")
    public void checkRepeatedDataResponse(){
        response
                .assertThat()
                .statusCode(409).
                and()
                .body("message",equalTo("Этот логин уже используется. Попробуйте другой."));
    }
    @Step("Check if response shows that the login can't be created due the lack of information")
    public void checkNoEnoughDataResponse(){
        response
                .assertThat()
                .statusCode(400)
                .and()
                .body("message",equalTo("Недостаточно данных для создания учетной записи"));
    }

}
