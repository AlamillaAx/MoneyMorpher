package com.aluracursos.proyecto.conversor.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Conversion {
    private String monedaBase;
    private String monedaConv;
    private double valorAConvertir;
    private double valorConvMoneda;
    private double convResult;
    private String fechaConvert;


    public Conversion(String monedaBase, String monedaConv, double valorAConvertir, double valorConvMoneda) {
        this.monedaBase = monedaBase;
        this.monedaConv = monedaConv;
        this.valorAConvertir = valorAConvertir;
        this.valorConvMoneda = valorConvMoneda;
        this.convResult = valorAConvertir * valorConvMoneda;
        this.fechaConvert = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public String getMonedaConv() {
        return monedaConv;
    }

    public double getValorBaseMoneda() {
        return valorAConvertir;
    }

    public double getValorConvMoneda() {
        return valorConvMoneda;
    }

    public double getConvResult() {
        return convResult;
    }

    @Override
    public String toString() {
        return "Moneda base: " + monedaBase +
                ", Moneda final: " + monedaConv +
                ", Valor a convertir: " + valorAConvertir +
                ", Taza de cambio: " + valorConvMoneda +
                ", Valor convertido: " + convResult +
                ", Fecha de conversion: " +fechaConvert;
    }
}
