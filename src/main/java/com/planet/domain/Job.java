package com.planet.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "JOBS", schema = "HR")
public class Job {

    @Id
    @Column(name = "JOB_ID", nullable = false)
    private String id;

    @Column(name = "JOB_TITLE", nullable = false)
    private String title;

    @Column(name = "MIN_SALARY")
    private Integer minSalary;

    @Column(name = "MAX_SALARY")
    private Integer maxSalary;
}
