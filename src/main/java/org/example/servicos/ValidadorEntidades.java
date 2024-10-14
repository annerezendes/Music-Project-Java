package org.example.servicos;

public class ValidadorEntidades {

    public static boolean validarVazio (String atributo){
        if(atributo == null){
            System.out.println("Este campo não pode estar vazio!");
            return false;
        }
            return true;

    }

    public static boolean validarDouble (Double atributo){
        if(atributo <0){
            System.out.println("Este campo não pode ser negativo!");
            return false;
        }
        return true;
    }

    public static boolean validarInt (int atributo){
        if(atributo<0){
            System.out.println("Este campo não pode ser negativo!");
            return false;
        }

        return true;
    }

}
