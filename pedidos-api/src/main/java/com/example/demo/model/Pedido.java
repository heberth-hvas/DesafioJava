package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Client name is mandatory")
    private String clientName;

    @NotBlank(message = "Tipo is mandatory")
    private String tipo;

    @NotBlank(message = "CNPJ or CPF is mandatory")
    private String cnpjouCpf;

    @NotNull(message = "Data da compra is mandatory")
    private LocalDate dataCompra;

    @NotNull(message = "Valor total is mandatory")
    private Double valorTotal;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pedido")
    @NotEmpty(message = "Items are mandatory")
    private List<Item> items;

}
