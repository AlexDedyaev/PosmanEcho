package ru.netology;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    public void shouldPostRawTextTest() {
        //Given - When - Then
        // Предисловие
        given()
                .baseUri("https://postman-echo.com")
                .body("Hello, World")
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверка
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .header("connection","keep-alive")
                .body("data", equalTo("Hello, World"));
    }
}