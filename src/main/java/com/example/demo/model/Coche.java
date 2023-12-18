package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

@Getter
@Setter
public class Coche {
    private String matricula;
    private String modelo;
    private Cliente cliente;
    private String tipoTarifa;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Double costeTotal;


    public Coche( String matricula , String modelo , Cliente cliente , String tipoTarifa , LocalDate fechaEntrada , LocalDate fechaSalida ) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.cliente = cliente;
        this.tipoTarifa = tipoTarifa;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        costeTotal = 0.0;
    }
}
