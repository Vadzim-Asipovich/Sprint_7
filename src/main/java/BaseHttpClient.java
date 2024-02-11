import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public abstract class BaseHttpClient {

    private RequestSpecification baseRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(URL.HOST)
                .addHeader("Content-Type", "application/json")
                .build();
    }

    protected Response doGetRequest(String path) {
        return given()
                .spec(baseRequestSpec())
                .get(path)
                .thenReturn();
    }

    protected Response doPostRequest(String path, Object body) {
        return given()
                .spec(baseRequestSpec())
                .body(body)
                .post(path)
                .thenReturn();
    }
    protected Response doDeleteRequest(String path) {
        return given()
                .spec(baseRequestSpec())
                .delete(path)
                .thenReturn();
    }

    protected Response doPutRequest(String path) {
        return given()
                .spec(baseRequestSpec())
                .put(path)
                .thenReturn();
    }



}
