import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;

public class CourierCreationTest {
    public static String sampleLogin = "SampleLogin135";
    public static String samplePassword = "qwerty123!@#";
    public static String sampleFirstName = "John";
    private CourierCreationSteps createSteps = new CourierCreationSteps();
    private CourierLoginSteps loginSteps = new CourierLoginSteps();
    private CourierDeletionSteps deletionSteps = new CourierDeletionSteps();

    @Test
    @DisplayName("It's possible to create a unique courier")
    public void createUniqueCourierTest() {
        Courier courier = new Courier(sampleLogin, samplePassword, sampleFirstName);
        createSteps.createCourier(courier);
        createSteps.checkUserCreationSuccessfulResponse();
        //Tear down
        CourierCredentials credentials = new CourierCredentials(sampleLogin, samplePassword);
        loginSteps.loginCourier(credentials);
        deletionSteps.deleteCourier(loginSteps.getCourierID());
    }

    @Test
    @DisplayName("It's impossible to create a courier without login")
    public void createUniqueCourierWithoutLoginTest() {
        Courier courier = new Courier("", samplePassword, sampleFirstName);
        createSteps.createCourier(courier);
        createSteps.checkNoEnoughDataResponse();
    }

    @Test
    @DisplayName("It's impossible to create a courier without password")
    public void createUniqueCourierWithoutPasswordTest() {
        Courier courier = new Courier(sampleLogin, "", sampleFirstName);
        createSteps.createCourier(courier);
        createSteps.checkNoEnoughDataResponse();
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
        //Tear down
        CourierCredentials credentials = new CourierCredentials(sampleLogin, samplePassword);
        loginSteps.loginCourier(credentials);
        deletionSteps.deleteCourier(loginSteps.getCourierID());
    }
}