package com.planet.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "JOBS")
public class Job {

    @Id
    private String id;

    private String title;

    private Integer minSalary;

    private Integer maxSalary;
}
