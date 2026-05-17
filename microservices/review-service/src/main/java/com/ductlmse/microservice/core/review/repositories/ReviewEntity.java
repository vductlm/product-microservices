package com.ductlmse.microservice.core.review.repositories;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;


@Entity
@Table(name = "reviews", indexes = {
        @Index(name = "review", unique = true, columnList = "productId, reviewId")
})
public class ReviewEntity {

    @Id
    @Generated
    private int id;

    @Version
    private int version;
    private int productId;
    private int reviewId;
    private String author;
    private String subject;
    private String content;

}
