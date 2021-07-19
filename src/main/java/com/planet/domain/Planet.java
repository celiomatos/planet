package com.planet.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PLANETS")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLANET_ID", nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String username;
}
