package br.com.matheusrodrigues_pg.factories;

import br.com.matheusrodrigues_pg.models.UserData;
import com.github.javafaker.Faker;

import java.util.Locale;

public class UserFactory {
    private static final Faker faker = new Faker(new Locale("pt-BR"));

    public static UserData usuarioValido() {

        return UserData.builder()
                .name(faker.name().username())
                .email(faker.internet().emailAddress())
                .password("123456")
                .dayBirth(String.valueOf(faker.number().numberBetween(1, 28)))
                .monthBirth(String.valueOf(faker.number().numberBetween(1, 12)))
                .yearBirth(String.valueOf(faker.number().numberBetween(1950, 2000)))
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .company(faker.company().name())
                .address(faker.address().streetAddress())
                .address2(faker.address().secondaryAddress())
                .country(String.valueOf(faker.number().numberBetween(1, 6)))
                .state(faker.address().state())
                .city(faker.address().city())
                .zipcode(faker.address().zipCode())
                .mobileNumber(faker.phoneNumber().cellPhone())
                .build();
    }

}