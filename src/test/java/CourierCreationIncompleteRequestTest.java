import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;

public class CourierCreationIncompleteRequestTest {
    public static String sampleLogin = "SampleLogin135";
    public static String samplePassword = "qwerty123!@#";
    public static String sampleFirstName = "John";
    private CourierCreationSteps createSteps = new CourierCreationSteps();

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
}