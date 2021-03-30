package pl.com.przepiora.invoicer.model;

import lombok.Data;

import java.util.List;

@Data
public class Company {
    private String companyName;
    private String nip;
    private Address address;
    private List<String> phoneList;
    private List<Person> employeeList;
    private String email;
    private String webAddress;
}
