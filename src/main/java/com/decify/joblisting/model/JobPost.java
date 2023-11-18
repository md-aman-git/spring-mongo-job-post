package com.decify.joblisting.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Data
@Document(collection = "job-post")
public class JobPost {
    private String profile;
    private String desc;
    private int exp;
    private String [] techs;
}
