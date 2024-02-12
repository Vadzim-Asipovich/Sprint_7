import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class GetOrderListTest {
    private GetOrderListSteps getOrderListSteps = new GetOrderListSteps();

    @Test
    @DisplayName("orders endpoint without limit param returns 30 entries")
    public void getAllOrderListWithoutLimitParamTest(){
        getOrderListSteps.getOrderListWithoutParams();
        getOrderListSteps.checkDefaultOrderListLength();
        getOrderListSteps.checkOrderListResponseCode();
    }
}
