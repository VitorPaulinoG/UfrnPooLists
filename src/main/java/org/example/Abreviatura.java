package org.example;

import java.util.Arrays;

public class Abreviatura {
    public static void main(String[] args) {
        String abreviatura = "";
        for (String subnome : args)
        {
            String subAbreviatura = "";
            if(subnome.length() > 2)
            {
                subAbreviatura += Character.toUpperCase(subnome.charAt(0))  + ". ";
            } else {
                subAbreviatura = subnome + " ";
            }

            abreviatura += subAbreviatura;

        }

        System.out.println(abreviatura);

    }
}
