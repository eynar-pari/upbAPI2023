package apiTest;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateProjectJsonTest {


    /*
    * given() --> requirement/configuration
    * when() --> method + url
    * then() --> response -> verification
    * */

    @Test
    public void verifyCreateProject(){

            JSONObject body = new JSONObject();
            body.put("Content","EynarJSON");
            body.put("Icon",1);
            given()
                    .auth()
                    .preemptive()
                    .basic("upb2023@upb.com","12345")
                    .header("Content-Type","application/json")
                    .body(body.toString())
                    .log().all()
            .when()
                    .post("https://todo.ly/api/projects.json")
            .then()
                    .log().all()
                    .statusCode(200)
                    .body("Icon",equalTo(body.get("Icon")))
                    .body("Content",equalTo(body.get("Content")));

    }

}
