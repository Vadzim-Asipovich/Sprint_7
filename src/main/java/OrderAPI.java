import io.restassured.response.Response;

public class OrderAPI extends BaseHttpClient {
    private final String apiPath = "/api/v1/orders";
    private final String apiCancelOrderPath = apiPath + "/cancel";
    private final String apiGetOrderByTrackPath = apiPath + "/track";
    public Response createOrder(Order order){
        return doPostRequest(apiPath, order);
    }
    public Response cancelOrder(String track){
        return doPutRequest(apiCancelOrderPath + "?track=" + track);
    }
    public Response getOrderByTrack(String track){
        return doGetRequest(apiGetOrderByTrackPath + "?t=" + track);
    }
    public Response getOrderList(){
        return doGetRequest(apiPath);
    }


}






