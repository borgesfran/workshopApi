package com.cdes.workshops.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WK01_WORKSHOP")
@SequenceGenerator(name="WK01_WORKSHOP_SEQ", sequenceName = "WK01_WORKSHOP_SEQ", allocationSize = 1
)
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WK01_WORKSHOP_SEQ")
    @Column(name="WK01_COD_WORKSHOP")
    private Long id;

    @NotNull(message = "O nome do workshop não pode ser nulo")
    @Column(name="WK01_NOME_WORKSHOP")
    private  String nome;
}
