package br.com.matheusrodrigues_pg.factories;

import br.com.matheusrodrigues_pg.models.UserDataApi;
import com.github.javafaker.Faker;

import java.util.Locale;

public class UserApiFactory {
    private static final Faker faker = new Faker(new Locale("pt-BR"));

    public static UserDataApi usuarioValidoAPI() {

        return UserDataApi.builder()
                .name(faker.name().username())
                .email(faker.internet().emailAddress())
                .password("123456")
                .title("Mr")
                .birthDate(String.valueOf(faker.number().numberBetween(1, 28)))
                .birthMonth(String.valueOf(faker.number().numberBetween(1, 12)))
                .birthYear(String.valueOf(faker.number().numberBetween(1950, 2000)))
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .company(faker.company().name())
                .address1(faker.address().streetAddress())
                .address2(faker.address().secondaryAddress())
                .country(String.valueOf(faker.number().numberBetween(1, 6)))
                .state(faker.address().state())
                .city(faker.address().city())
                .zipcode(faker.address().zipCode())
                .mobile_number(faker.phoneNumber().cellPhone())
                .build();
    }
}
