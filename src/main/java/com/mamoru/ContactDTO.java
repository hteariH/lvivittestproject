package com.mamoru;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;

/**
 * Created by Mamoru on 6/26/2017.
 */
@Entity
@Table(name = "contact")
public class ContactDTO {

    @Id
    @GeneratedValue
    Long id;

    String name;
    String phone;

    public ContactDTO(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ContactDTO() {
    }
}
