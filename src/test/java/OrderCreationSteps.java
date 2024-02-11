import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.notNullValue;

public class OrderCreationSteps {
    private OrderAPI api = new OrderAPI();
    private ValidatableResponse response;
    @Step("Create an order")
    public void createOrder(Order order){
        response = api.createOrder(order).then();
    }
    @Step("Check if order creation response was successful")
    public void checkOrderCreationSuccessfulResponse(){
        response
                .assertThat()
                .statusCode(201)
                .and()
                .body("track",notNullValue());
    }
    @Step("Get order's track number")
    public String getOrderTrack(){
        return response
                .extract()
                .body()
                .path("track")
                .toString();
    }
    @Step("Get order by track number")
    public void getOrderByTrack(String track){
        response = api.getOrderByTrack(track).then();
    }
    @Step("Cancel order by track number")
    public void cancelOrderByTrack(String track){
        api.cancelOrder(track);
    }
    @Step("Check if created order contains the colors provided during its creation")
    public void checkOrderColors(String[] color){
        ArrayList<String> orderColor = response
                .extract()
                .body()
                .path("order.color");
        Assert.assertEquals("Colors should match", color, orderColor.toArray());
    }


}
