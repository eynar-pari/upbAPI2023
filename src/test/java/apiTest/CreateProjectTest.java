package apiTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateProjectTest {


    /*
    * given() --> requirement/configuration
    * when() --> method + url
    * then() --> response -> verification
    * */

    @Test
    public void verifyCreateProject(){

            given()
                    .auth()
                    .preemptive()
                    .basic("upb2023@upb.com","12345")
                    .header("Content-Type","application/json")
                    .body("{\n" +
                            "   \"Content\":\"API\",\n" +
                            "   \"Icon\":3\n" +
                            "}")
                    .log().all()
            .when()
                    .post("https://todo.ly/api/projects.json")
            .then()
                    .log().all()
                    .statusCode(200)
                    .body("Icon",equalTo(3))
                    .body("Content",equalTo("API"));

    }

}
