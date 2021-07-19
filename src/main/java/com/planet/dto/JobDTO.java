package com.planet.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {

    @NotBlank(message = "Informar o ID do Job é obrigatório")
    @Size(max = 10, message = "ID do Job deve ter no maximo 10 caracteres")
    private String id;

    @NotBlank(message = "Informar o titulo do Job é obrigatório")
    @Size(max = 35, message = "Titutlo do Job deve ter no maximo 35 caracteres")
    private String title;

    @Min(value = 1, message = "Minimo valor permitido é 1")
    @Max(value = Integer.MAX_VALUE , message = "Valor ultrapassa maximo valor permitido")
    private Integer minSalary;

    @Min(value = 1, message = "Minimo valor permitido é 1")
    @Max(value = Integer.MAX_VALUE , message = "Valor ultrapassa maximo valor permitido")
    private Integer maxSalary;
}
