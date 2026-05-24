package br.com.matheusrodrigues_pg.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDataApi {
    private String name;
    private String email;
    private String password;
    private String title;
    private String birthDate;
    private String birthMonth;
    private String birthYear;
    private String firstname;
    private String lastname;
    private String company;
    private String address1;
    private String address2;
    private String country;
    private String zipcode;
    private String state;
    private String city;
    private String mobile_number;
}
