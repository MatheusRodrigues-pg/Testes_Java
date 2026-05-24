package br.com.matheusrodrigues_pg.tests;

import br.com.matheusrodrigues_pg.utils.BaseTest;
import br.com.matheusrodrigues_pg.factories.UserFactory;
import br.com.matheusrodrigues_pg.models.UserData;
import br.com.matheusrodrigues_pg.pages.LoginPage;
import br.com.matheusrodrigues_pg.pages.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Front_AutomationExecTest extends BaseTest {


    @Test
    @DisplayName("Login com sucesso")
    public void testLogin() {
        UserData usuario = UserFactory.usuarioValido();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.elementIsVisible(homePage.divCarousel);
        loginPage.navSignupLogin.click();

        loginPage.assertText(loginPage.h2NewUserSignup,"New User Signup!");
        loginPage.sigNup(usuario);

        loginPage.elementIsVisible(loginPage.bEnterAccountInformation);
        loginPage.enterInformation(usuario);

        loginPage.assertText(loginPage.bAccountCreated,"ACCOUNT CREATED!");
        loginPage.click(loginPage.buttonContinueCreateAccount);

        loginPage.assertText(homePage.aLogged, "Logged in as " + usuario.getName());
        loginPage.click(homePage.linkLogout);


        loginPage.navSignupLogin.click();
        loginPage.login(usuario);

        loginPage.click(homePage.deleteAccount);
        loginPage.assertText(homePage.bAccountDeleted,"ACCOUNT DELETED!");
        loginPage.click(homePage.linkContinueButton);

    }

    @Test
    @DisplayName("Cadastro com sucesso")
    public void testCadastro() {
        UserData usuario = UserFactory.usuarioValido();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.waitPageLoad();
        loginPage.elementIsVisible(homePage.divCarousel);
        loginPage.navSignupLogin.click();

        loginPage.waitPageLoad();
        loginPage.assertText(loginPage.h2NewUserSignup,"New User Signup!");
        loginPage.sigNup(usuario);

        loginPage.waitPageLoad();
        loginPage.elementIsVisible(loginPage.bEnterAccountInformation);
        loginPage.enterInformation(usuario);

        loginPage.waitPageLoad();
        loginPage.assertText(loginPage.bAccountCreated,"ACCOUNT CREATED!");
        loginPage.click(loginPage.buttonContinueCreateAccount);

        loginPage.waitPageLoad();
        loginPage.assertText(homePage.aLogged, "Logged in as " + usuario.getName());
        loginPage.click(homePage.deleteAccount);

        loginPage.waitPageLoad();
        loginPage.assertText(homePage.bAccountDeleted,"ACCOUNT DELETED!");
        loginPage.click(homePage.linkContinueButton);
    }

    @Test
    @DisplayName("Login sem sucesso")
    public void testLoginSemSucesso() {
        UserData usuario = UserFactory.usuarioValido();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.waitPageLoad();
        loginPage.elementIsVisible(homePage.divCarousel);
        loginPage.navSignupLogin.click();

        loginPage.assertText(loginPage.h2LoginYourAccount,"Login to your account");
        loginPage.login(usuario);
        loginPage.esperarExibir(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]"));
        loginPage.elementIsVisible(loginPage.pYourEmailPasswordIncorrect);
        loginPage.assertText(loginPage.pYourEmailPasswordIncorrect,"Your email or password is incorrect!");

        
    }
    
    @Test
    @DisplayName("Adicionar produto no carrinho")
    public void testAdicionarCarrinho() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.elementIsVisible(homePage.divCarousel);
        String item = loginPage.getText(homePage.item1);
        homePage.linkViewProduct1.click();

        loginPage.elementIsVisible(homePage.h2Bitem1);
        loginPage.assertText(homePage.h2Bitem1, item);
        homePage.inputQuantity.clear();
        homePage.inputQuantity.sendKeys("4");
        homePage.buttonAddCart.click();
        homePage.esperarExibir(By.xpath("//*[@id=\"cartModal\"]/div/div"));
        homePage.uViewCart.click();

        String itemCarrinho = loginPage.getText(homePage.descriptionItem);
        assertEquals(item, itemCarrinho);
        loginPage.assertText(homePage.quantityDesc, "4");
    }
}