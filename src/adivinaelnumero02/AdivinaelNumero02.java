/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adivinaelnumero02;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Alejandro
 */
public class AdivinaelNumero02 {
    static Scanner sc = new Scanner(System.in);  
    static Random rnd = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int gameover = 0;
        int no_repetir = 0;
        int numero = 0;
        int intentos_bucle = 0;
        int intentos = 0;
        int respuesta = 0;
        int positivo = 0;
        int ganadas = 0;
        int perdidas = 0;
        char repetir;
        char principio;
        int random = 0;
        
        while (gameover == 0){
            int errores = 0;
            while (positivo == 0){
                System.out.println("Numero max");
                numero = sc.nextInt();
                System.out.println("Numero de intentos:");
                intentos_bucle = sc.nextInt();
                intentos = intentos_bucle;
                no_repetir = 0;
                
                if (numero <= 0 || intentos_bucle <= 0){
                System.out.println("No puede ser 0 o negativo");
                } else{
                    positivo = 1;
                }
            }
                
            while (no_repetir == 0){

                    while (intentos_bucle > 0){
                        
                        random = rnd.nextInt(0, numero);
                        if (intentos_bucle != 1){
                            System.out.println("Intento numero " + intentos_bucle);
                            respuesta = sc.nextInt();
                        } else {
                            System.out.println("Ultimo intento ");
                            respuesta = sc.nextInt();
                        }

                        if (respuesta != random && respuesta > random){
                            System.out.println("Mas bajo");
                            errores += 1;
                        } else if (respuesta != random && respuesta < random) {
                            System.out.println("Mas alto");
                            errores += 1;
                        } else if (respuesta == random){
                            System.out.println("Lo has adivinado!");
                            intentos_bucle = 0;
                            ganadas += 1;
                        }
                    
                        if (errores == intentos) {
                            perdidas += 1;
                            System.out.println("No lo has adivinado, el numero era " + random);
                            intentos_bucle = 0;  
                        }
                    
                        intentos_bucle -= 1;
                        
                    
                    }
                    System.out.println("Has ganado " + ganadas + " y has perdido " + perdidas);
                    
                    System.out.println("Quieres jugar de nuevo? (S/N)");
                    repetir = sc.next().charAt(0);
                
                    if (repetir == 'N' || repetir == 'n'){
                        System.out.println("Bien jugado");
                        System.exit(0);
                    } else if (repetir == 'S' ||repetir == 's'){
                        System.out.println("¿Quieres hacerlo desde el principio? (S/N)");
                        principio = sc.next().charAt(0);
                        if (principio == 'S' || principio == 's'){
                            no_repetir = 1;
                            positivo = 0;
                        } else if (principio == 'N' || principio == 'n'){
                            intentos_bucle = intentos;
                        }
                }   
            }
        }
    }
    
}
