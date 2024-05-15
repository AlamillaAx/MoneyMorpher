package com.aluracursos.proyecto.conversor.principal;

import com.aluracursos.proyecto.conversor.modelos.Consulta;
import com.aluracursos.proyecto.conversor.modelos.Conversion;
import com.aluracursos.proyecto.conversor.modelos.Usuario;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String menuTxt="""
                +++++++++++++++++++++++++++++++++++++++++++++++++++++
                ++++++ Bienvenido al conversor de MoneyMorpher ++++++
                Por favor seleccione la conversion que desea realizar
                +++++++++++ 1) Dolar ---> Peso argentino ++++++++++++
                +++++++++++ 2) Peso argentino --> Dolar +++++++++++++
                +++++++++++ 3) Dolar --> Real brasileno +++++++++++++
                +++++++++++ 4) Real brasileno --> Dolar +++++++++++++
                +++++++++++ 5) Dolar --> Peso colombiano ++++++++++++
                +++++++++++ 6) Peso colombiano --> Dolar ++++++++++++
                +++++++++++ 7) Resumen de conversiones ++++++++++++++
                +++++++++++ 8) Salir ++++++++++++++++++++++++++++++++
                +++++++++++++++++++++++++++++++++++++++++++++++++++++
                """;
        String decisionTxt = """
                +++++++++++++++++++++++++++++++++++++++++++++++++++++
                ++++++++++ Conversion realizada con exito! ++++++++++
                +++++++ ¿Desea realizar una nueva conversion? +++++++
                +++++++++++++++++++ Si = 1 No = 0 +++++++++++++++++++
                +++++++++++++++++++++++++++++++++++++++++++++++++++++
                """;
        String decisionTxtCons = """
                +++++++++++++++++++++++++++++++++++++++++++++++++++++
                ++++++++++ Consulta realizada con exito! ++++++++++
                ++++++++ ¿Desea realizar una nueva consulta? ++++++++
                +++++++++++++++++++ Si = 1 No = 0 +++++++++++++++++++
                +++++++++++++++++++++++++++++++++++++++++++++++++++++
                """;
        Scanner userEnt = new Scanner(System.in);
        System.out.println("Ingrese un nombre de usuario");
        String userName = userEnt.nextLine();
        Usuario newUser = new Usuario(userName);
        String monedaBaseValor = "";
        String monedaConvValor = "";
        double valorAConvertir = 0;
        boolean conversionRealizada = false;
        Consulta monCons = new Consulta();

        int salir = 1;
        while (salir!=0){
            System.out.println(menuTxt);
            try{
                var userOp = userEnt.nextInt();
                switch (userOp){
                    case 1:
                        monedaBaseValor = "USD";
                        monedaConvValor = "ARS";
                        break;
                    case 2:
                        monedaBaseValor = "ARS";
                        monedaConvValor = "USD";
                        break;
                    case 3:
                        monedaBaseValor = "USD";
                        monedaConvValor = "BRL";
                        break;
                    case 4:
                        monedaBaseValor = "BRL";
                        monedaConvValor = "USD";
                        break;
                    case 5:
                        monedaBaseValor = "USD";
                        monedaConvValor = "COP";
                        break;
                    case 6:
                        monedaBaseValor = "COP";
                        monedaConvValor = "USD";
                        break;
                    case 7:
                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        System.out.println("Resumen de conversiones realizadas por el usuario: " + newUser.getNombreUsuario());
                        for (Conversion conversiones : newUser.getListaConversiones()){
                            System.out.println(conversiones);
                        }
                        System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        System.out.println("\n Conversiones hasta el momento: " + newUser.getNumeroConversiones());
                        break;
                    case 8:
                        salir = 0;
                        break;
                }
                if (userOp!= 7){
                    System.out.println("Ingrese el valor que desea convertir");
                    valorAConvertir = userEnt.nextDouble();
                    Conversion newConversion = monCons.buscaMonedas(monedaBaseValor, monedaConvValor, valorAConvertir);
                    conversionRealizada = newUser.realizarConversion(newConversion);
                    if (conversionRealizada){
                        System.out.println(decisionTxt);
                        salir = userEnt.nextInt();
                    }
                }else{
                    System.out.println(decisionTxtCons);
                    salir = userEnt.nextInt();
                }


            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Resumen de conversiones realizadas por el usuario: " + newUser.getNombreUsuario());
        for (Conversion conversiones : newUser.getListaConversiones()){
            System.out.println(conversiones);
        }
        System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\n Conversiones totales: " + newUser.getNumeroConversiones());
    }
}
