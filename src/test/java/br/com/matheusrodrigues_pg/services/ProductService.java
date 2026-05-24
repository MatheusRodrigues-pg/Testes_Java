package br.com.matheusrodrigues_pg.services;

import br.com.matheusrodrigues_pg.models.UserDataApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class ProductService {

    private final String BASE_URL = "https://automationexercise.com/api";

    public ProductService() {
        RestAssured.baseURI = BASE_URL;
    }
    public Response buscarTodosOsProdutos() {
        return RestAssured.given()
                .when()
                .get("/productsList");
    }
    public Response buscarTodosOsProdutosPOST() {
        return RestAssured.given()
                .when()
                .post("/productsList");
    }

    public Response buscarTodasMarcas() {
        return RestAssured.given()
                .when()
                .get("/brandsList");
    }

    public Response criarContaUsuario(UserDataApi usuario) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mapeamentoDosCampos = mapper.convertValue(usuario, Map.class);

        return RestAssured.given()
                .contentType("application/x-www-form-urlencoded")
                .formParams(mapeamentoDosCampos)
                .when()
                .post("/createAccount");
    }

    public Response deletarContaUsuario(UserDataApi usuario) {
        return RestAssured.given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("email", usuario.getEmail())
                .formParam("password", usuario.getPassword())
                .when()
                .delete("/deleteAccount");
    }
}
