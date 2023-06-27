package au.com.ncs;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AusPostAPITests {

    @Test
    public void tascottStatusTest() {
        given().
                header("auth-key", "88737804-3df1-492c-9b97-9ad4a4bdcfe9").and().
                param("q", "tascott").and().
                param("state", "NSW").
        when().
                get("https://digitalapi.auspost.com.au/postcode/search.json").
        then().
                assertThat().statusCode(is(200));
    }

    // here's a test. I'll talk later why comments are code smell
    @Test
    public void tascottPostcodeTest() {
        given().
                header("auth-key", "88737804-3df1-492c-9b97-9ad4a4bdcfe9").and().
                param("q", "tascott").and().
                param("state", "NSW").
        when().
                get("https://digitalapi.auspost.com.au/postcode/search.json").
        then().
                assertThat().body("localities.locality.postcode", equalTo(2250));
    }
}
