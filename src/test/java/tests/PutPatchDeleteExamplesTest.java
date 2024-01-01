package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PutPatchDeleteExamplesTest {

    @Test
    public void testPut(){
        JSONObject request = new JSONObject();

        request.put("name", "Raghav");
        request.put("job", "Teacher");

        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";

        given().header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("/users/2")
                .then()
                .statusCode(200);
    }

    @Test
    public void testPatch(){
        JSONObject request = new JSONObject();

        request.put("name", "Raghav");
        request.put("job", "Teacher");

        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in";

        given().header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("/api/users/2")
                .then()
                .statusCode(200);
    }

    @Test
    public void testDelete(){
        baseURI = "https://reqres.in";

                when()
                .delete("/api/users/2")
                .then()
                .statusCode(204);
    }

}
