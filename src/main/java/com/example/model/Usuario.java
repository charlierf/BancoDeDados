package com.example.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="cpf")
    private int cpf;
    @Column(name="nome")
    private String nome;
    @Column(name="data_nascimento")
    private Date dataNascimento;
}