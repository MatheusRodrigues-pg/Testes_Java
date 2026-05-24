package br.com.matheusrodrigues_pg.tests;

import br.com.matheusrodrigues_pg.factories.UserApiFactory;
import br.com.matheusrodrigues_pg.models.UserDataApi;
import br.com.matheusrodrigues_pg.services.ProductService;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class API_AutomationExecTest {

    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productService = new ProductService();
    }

    @Test
    public void deveRetornarListaDeProdutosComSucesso() {
        Response response = productService.buscarTodosOsProdutos();
        response.then().statusCode(200);

        io.restassured.path.json.JsonPath json = response.jsonPath();

        org.junit.jupiter.api.Assertions.assertEquals(200, json.getInt("responseCode"));
        org.junit.jupiter.api.Assertions.assertNotNull(json.get("products"));
        org.junit.jupiter.api.Assertions.assertEquals(1, json.getInt("products[0].id"));
        org.junit.jupiter.api.Assertions.assertEquals("Blue Top", json.getString("products[0].name"));
        org.junit.jupiter.api.Assertions.assertEquals("Rs. 500", json.getString("products[0].price"));
        org.junit.jupiter.api.Assertions.assertEquals("Women", json.getString("products[0].category.usertype.usertype"));
        org.junit.jupiter.api.Assertions.assertEquals("Tops", json.getString("products[0].category.category"));
    }

    @Test
    public void deveRetornarListaDeProdutosComErro() {
        Response response = productService.buscarTodosOsProdutosPOST();

        io.restassured.path.json.JsonPath json = response.jsonPath();

        org.junit.jupiter.api.Assertions.assertEquals(405, json.getInt("responseCode"));
        org.junit.jupiter.api.Assertions.assertEquals("This request method is not supported.", json.getString("message"));
    }

    @Test
    public void deveRetornarListaBrand() {
        Response response = productService.buscarTodasMarcas();
        response.then().statusCode(200);

        io.restassured.path.json.JsonPath json = response.jsonPath();

        org.junit.jupiter.api.Assertions.assertEquals(200, json.getInt("responseCode"));
        org.junit.jupiter.api.Assertions.assertEquals(21, json.getInt("brands[17].id"));
        org.junit.jupiter.api.Assertions.assertEquals("Biba", json.getString("brands[19].brand"));

    }

    @Test
    public void deveCriarConta() {
        UserDataApi usuario = UserApiFactory.usuarioValidoAPI();
        Response response = productService.criarContaUsuario(usuario);
        response.then().statusCode(200);

        io.restassured.path.json.JsonPath json = response.jsonPath();
        org.junit.jupiter.api.Assertions.assertEquals(201, json.getInt("responseCode"));
        org.junit.jupiter.api.Assertions.assertEquals("User created!", json.getString("message"));
    }

    @Test
    public void deveDeletarConta() {
        UserDataApi usuario = UserApiFactory.usuarioValidoAPI();
        productService.criarContaUsuario(usuario);
        Response response = productService.deletarContaUsuario(usuario);
        response.then().statusCode(200);

        io.restassured.path.json.JsonPath json = response.jsonPath();
        org.junit.jupiter.api.Assertions.assertEquals(200, json.getInt("responseCode"));
        org.junit.jupiter.api.Assertions.assertEquals("Account deleted!", json.getString("message"));
    }
}

