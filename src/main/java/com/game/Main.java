package com.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static byte CHANCES;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        try{
            String texto=leerArchivo();
            System.out.print(texto);
        }catch(IOException e){
            System.out.println("Error al leer el archivo");
            System.exit(0);
        }
        int dificultad=scanner.nextInt();
        String dificultT="";
        switch(dificultad){
            case 1:
                CHANCES=10;
                dificultT="Easy";
                break;
            case 2:
                CHANCES=5;
                dificultT="Medium";
                break;
            case 3:
                CHANCES=3;
                dificultT="Hard";
                break;
        }
        System.out.println("Great! You have selected the "+dificultT+" difficulty level.\nLet's start the game!\n");
        System.out.print("Enter your guess: ");
        byte guess=scanner.nextByte();
        

        

    }

    public static String  leerArchivo() throws IOException {
        BufferedReader lector;
        try(FileReader archivo = new FileReader("src/main/resources/Welcome.txt");) {
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
        throw new IOException();
    }

}

