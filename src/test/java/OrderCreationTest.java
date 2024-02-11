import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderCreationTest {
    private final String[] color;
    OrderCreationSteps creationSteps = new OrderCreationSteps();
    public OrderCreationTest(String[] color) {
        this.color = color;
    }
    @Parameterized.Parameters
    public static Object[][] getColorData() {
        return new Object[][] {
                {new String[] {"BlACK"}},
                {new String[] {"BlACK","GREY"}},
                {new String[] {}}
        };
    }
    @Test
    @DisplayName("It's possible to create an order")
    public void createNewOrderTest(){
        Order coloredOrder = new Order(color);
        creationSteps.createOrder(coloredOrder);
        creationSteps.checkOrderCreationSuccessfulResponse();
        String orderTrack = creationSteps.getOrderTrack();
        creationSteps.getOrderByTrack(orderTrack);
        creationSteps.checkOrderColors(color);
        //Tear down
        creationSteps.cancelOrderByTrack(orderTrack);
    }

}
