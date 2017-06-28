package com.mamoru;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by admin on 6/26/2017.
 */

public class Contact {

    String name;

    String phones;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    @JsonProperty("phones")
    public List<String> getListPhones() {
        if (phones != null) {
            return Arrays.asList(phones.split(","));
        }
        return Collections.emptyList();
    }
    @JsonProperty("phones")
    public void setListPhones(List<String> phones) {
        this.phones = phones.stream().collect(Collectors.joining(","));
    }
}
