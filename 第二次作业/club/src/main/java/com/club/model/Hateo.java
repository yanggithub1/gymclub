package com.club.model;


import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import javax.persistence.Entity;
@Relation(value = "Hateo", collectionRelation = "Hateo")
public class Hateo extends ResourceSupport {
    private String content;


    public Hateo(String content) {
        this.content = content;
    }


    public String getContent() {
        return content;
    }

}
