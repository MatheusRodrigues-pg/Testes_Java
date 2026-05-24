package br.com.matheusrodrigues_pg.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserData {

    private String name;
    private String email;
    private String password;
    private String dayBirth;
    private String monthBirth;
    private String yearBirth;
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String address2;
    private String country;
    private String state;
    private String city;
    private String zipcode;
    private String mobileNumber;
}