package apiTest;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateProjectFileTest {


    /*
    * given() --> requirement/configuration
    * when() --> method + url
    * then() --> response -> verification
    * */

    @Test
    public void verifyCreateProject(){
        String filePath = new File("").getAbsolutePath();
        given()
                    .auth()
                    .preemptive()
                    .basic("upb2023@upb.com","12345")
                    .header("Content-Type","application/json")
                    .body(new File(filePath+"/src/test/resources/createProjectBody.json"))
                    .log().all()
            .when()
                    .post("https://todo.ly/api/projects.json")
            .then()
                    .log().all()
                    .statusCode(200)
                    .body("Icon",equalTo(9))
                    .body("Content",equalTo("ExampleFile"));
    }
}
