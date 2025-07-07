package com.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static byte LIMIT_CHACES;
    private static byte CHACES;

    public static final Service service=new Service();
    
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
        service.setDificulty((byte) dificultad);
        switch(dificultad){
            case 1:
                LIMIT_CHACES=10;
                dificultT="Easy";
                break;
            case 2:
                dificultT="Medium";
                LIMIT_CHACES=5;
                break;
            case 3:
                dificultT="Hard";
                LIMIT_CHACES=3;
                break;
            default:
                System.out.println("Invalid option");
                System.exit(0);
        }
        service.setRandomNumber();
        System.out.println("Great! You have selected the "+dificultT+" difficulty level.\nLet's start the game!\n");
        System.out.print("Enter your guess: ");
        byte guess=scanner.nextByte();
        switch(service.checkGuess(guess)){
            case 1:
                System.out.println("Incorrect! The number is greater than "+guess+".");
            break;
            case -1:
                System.out.println("Incorrect! The number is less than " + guess + ".");
            break;
            default:
                System.out.println("Congratulations! You guessed the correct number in 4 attempts.");
        }


        

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

