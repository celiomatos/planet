package com.planet.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PLANETS", schema = "HR")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HR.PLANET_SEQ")
    @SequenceGenerator(name = "HR.PLANET_SEQ", sequenceName = "HR.PLANET_SEQ", allocationSize = 1)
    @Column(name = "PLANET_ID", nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;
}
