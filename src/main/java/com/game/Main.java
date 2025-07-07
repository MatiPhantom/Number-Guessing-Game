package com.game;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

        
        System.out.println(leerArchivo());

    }

    public static String leerArchivo() {
        FileReader archivo;
        BufferedReader lector;
        try {
            archivo = new FileReader("src/main/resources/Welcome.txt");
            if (archivo.ready()) { // Verificar si esta listo para ser leido
                lector = new BufferedReader(archivo);
                String linea;
                StringBuilder texto = new StringBuilder();
                while ((linea = lector.readLine()) != null) {
                    texto.append(linea+"\n");
                }
                return texto.toString();
            } else {
                System.out.println("El archivo no esta listo para ser leido");
            }

        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
        }
        return null;
    }

}

