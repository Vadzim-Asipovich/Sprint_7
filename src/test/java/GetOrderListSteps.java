import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.Assert;

public class GetOrderListSteps {
    private OrderAPI api = new OrderAPI();
    private ResponseOrderList responseOrderList;
    private Response response;
    @Step("check if get order list query got 200 response code")
    public void checkOrderListResponseCode(){
        response.then().assertThat()
                .statusCode(200);
    }
    @Step("get order list without limit param (first 30 orders)")
    public void getOrderListWithoutParams(){
        response = api.getOrderList();
        responseOrderList = response.body().as(ResponseOrderList.class);
    }
    @Step("check if order lists length is equal to the specified quantity")
    public void checkOrderListLength(int expected){
        Assert.assertEquals("count should be the same", expected, responseOrderList.getOrders().size());
    }
    @Step("check if order lists length is equal to the default - 30")
    public void checkDefaultOrderListLength(){
        checkOrderListLength(30);
    }
}
