import org.junit.After;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;

public class CourierCreationTest {
    public static String sampleLogin = "SampleLogin135";
    public static String samplePassword = "qwerty123!@#";
    public static String sampleFirstName = "John";
    private CourierCreationSteps createSteps = new CourierCreationSteps();
    private CourierLoginSteps loginSteps = new CourierLoginSteps();
    private CourierDeletionSteps deletionSteps = new CourierDeletionSteps();
    @After
    public void tearDown(){
        CourierCredentials credentials = new CourierCredentials(sampleLogin, samplePassword);
        loginSteps.loginCourier(credentials);
        deletionSteps.deleteCourier(loginSteps.getCourierID());
    }
    @Test
    @DisplayName("It's possible to create a unique courier")
    public void createUniqueCourierTest() {
        Courier courier = new Courier(sampleLogin, samplePassword, sampleFirstName);
        createSteps.createCourier(courier);
        createSteps.checkUserCreationSuccessfulResponse();
    }
    @Test
    @DisplayName("It's impossible to create a courier with repeated login")
    public void createRepeatedCourierTest() {
        //Setup
        Courier courier = new Courier(sampleLogin, samplePassword, sampleFirstName);
        createSteps.createCourier(courier);
        //Test
        createSteps.createCourier(courier);
        createSteps.checkRepeatedDataResponse();
    }
}