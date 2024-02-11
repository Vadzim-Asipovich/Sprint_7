import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;

public class CourierLoginSteps {
    private CourierAPI api = new CourierAPI();
    private ValidatableResponse response;
    @Step("Login courier with credentials provided")
    public void loginCourier(CourierCredentials credentials) {
        response = api.loginCourier(credentials).then();
    }
    @Step("Check successful login response")
    public void checkIfLoginSuccessful(){
        response.assertThat()
                .statusCode(200)
                .and()
                .body("id", notNullValue());
    }
    @Step("Get courier ID")
    public String getCourierID(){
        return response.extract().body().path("id").toString();
    }
    @Step("Check failed login response without providing login or password")
    public void checkIncompleteLoginResponse(){
        response.assertThat()
                .statusCode(400)
                .and()
                .body("message", equalTo("Недостаточно данных для входа"));
    }
    @Step("Check failed login response when login-pass pair doesn't exist")
    public void checkNonexistentLoginResponse(){
        response.assertThat()
                .statusCode(404)
                .and()
                .body("message", equalTo("Учетная запись не найдена"));
    }
}
