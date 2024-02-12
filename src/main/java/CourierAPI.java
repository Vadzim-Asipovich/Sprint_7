import io.restassured.response.Response;

public class CourierAPI extends BaseHttpClient {
    private final String apiPath = "/api/v1/courier";
    private final String apiPathLogin = apiPath + "/login";

    public Response loginCourier(CourierCredentials credentials) {
        return doPostRequest(apiPathLogin, credentials);
    }
    public Response createCourier(Courier courier) {
        return doPostRequest(apiPath, courier);
    }
    public Response deleteCourier(String id) {
        return doDeleteRequest(apiPath + "/" + id);
    }
}
