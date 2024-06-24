package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product ID is mandatory")
    private String idProduto;

    @NotBlank(message = "Description is mandatory")
    private String descricao;

    @NotNull(message = "Quantity is mandatory")
    private Integer quantidade;

    @NotNull(message = "Value is mandatory")
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

}
