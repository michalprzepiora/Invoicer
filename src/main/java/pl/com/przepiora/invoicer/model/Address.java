package pl.com.przepiora.invoicer.model;

import lombok.Data;


@Data
public class Address {
    private String street;
    private String number;
    private String zipCode;
    private String city;
}
