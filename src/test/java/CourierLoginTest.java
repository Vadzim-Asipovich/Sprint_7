import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourierLoginTest {
    private CourierLoginSteps loginSteps = new CourierLoginSteps();
    private CourierCreationSteps createSteps = new CourierCreationSteps();
    private CourierDeletionSteps deletionSteps = new CourierDeletionSteps();
    @Before
    public void setUp() {
        Courier courier = new Courier(CourierCreationTest.sampleLogin,
                CourierCreationTest.samplePassword,
                CourierCreationTest.sampleFirstName);
        createSteps.createCourier(courier);
    }
    @After
    public void tearDown(){
        CourierCredentials credentials = new CourierCredentials(
                CourierCreationTest.sampleLogin,
                CourierCreationTest.samplePassword);
        loginSteps.loginCourier(credentials);
        deletionSteps.deleteCourier(loginSteps.getCourierID());
    }

    @Test
    @DisplayName("It's possible to login as an existing courier with valid credentials")
    public void loginCourierTest(){
        CourierCredentials credentials = new CourierCredentials(CourierCreationTest.sampleLogin,
                CourierCreationTest.samplePassword);
        loginSteps.loginCourier(credentials);
        loginSteps.checkIfLoginSuccessful();
    }
    @Test
    @DisplayName("It's impossible to login without providing login value")
    public void loginCourierWithoutLoginValueTest(){
        CourierCredentials credentials = new CourierCredentials("",
                CourierCreationTest.samplePassword);
        loginSteps.loginCourier(credentials);
        loginSteps.checkIncompleteLoginResponse();
    }
    @Test
    @DisplayName("It's impossible to login without providing password value")
    public void loginCourierWithoutPasswordValueTest(){
        CourierCredentials credentials = new CourierCredentials(CourierCreationTest.sampleLogin,
                "");
        loginSteps.loginCourier(credentials);
        loginSteps.checkIncompleteLoginResponse();
    }
    @Test
    @DisplayName("It's impossible to login with nonexistent login value")
    public void loginCourierWithIncorrectLoginValueTest(){
        CourierCredentials credentials = new CourierCredentials(CourierCreationTest.sampleLogin + "1",
                CourierCreationTest.samplePassword);
        loginSteps.loginCourier(credentials);
        loginSteps.checkNonexistentLoginResponse();
    }

}
