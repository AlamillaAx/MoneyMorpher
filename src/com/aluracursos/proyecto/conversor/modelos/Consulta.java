package com.aluracursos.proyecto.conversor.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {
    public Conversion buscaMonedas (String tipoMoneda, String monedaConv, double valorAConvertir){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/e048e6e5fbcdeb9f1167dc4e/latest/"+ tipoMoneda);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request,HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();

            String json = response.body();
            JsonObject jsonArray = gson.fromJson(json, JsonObject.class);
            double monConValue = jsonArray.getAsJsonObject("conversion_rates").get(monedaConv).getAsDouble();
            return new Conversion(tipoMoneda, monedaConv, valorAConvertir, monConValue);
        } catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("No es una moneda valida");
        }
    }
}
