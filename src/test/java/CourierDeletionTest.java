import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

public class CourierDeletionTest {
    private CourierCreationSteps createSteps = new CourierCreationSteps();
    private CourierLoginSteps loginSteps = new CourierLoginSteps();
    private CourierDeletionSteps deletionSteps = new CourierDeletionSteps();
    @Before
    public void setUp() {
        Courier courier = new Courier(CourierCreationTest.sampleLogin,
                CourierCreationTest.samplePassword,
                CourierCreationTest.sampleFirstName);
        createSteps.createCourier(courier);
    }
    @Test
    @DisplayName("It's possible to delete a courier")
    public void deleteCourierTest(){
        //Setup
        CourierCredentials credentials = new CourierCredentials(CourierCreationTest.sampleLogin,
                CourierCreationTest.samplePassword);
        loginSteps.loginCourier(credentials);
        String courierId = loginSteps.getCourierID();
        //Test
        deletionSteps.deleteCourier(courierId);
        deletionSteps.checkIfDeletionSuccessful();
    }
}
