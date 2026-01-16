package edu.pedro.ortega.actividad0.ui;

import edu.pedro.ortega.actividad0.process.Switch;

import java.util.Scanner;

public class CLI {

    public static void start(){
        Switch switch_wifi= new Switch();
        Scanner scanner = new Scanner (System.in);
        System.out.println("Bienvenido al programa");
        System.out.println("El estado del Switch es = " + switch_wifi.isOn());
        String respuesta;
        if(switch_wifi.isOn()){
            System.out.println("Desea apagar el switch?: s/n");
            respuesta = scanner.nextLine();
            if(respuesta.equals("n")) switch_wifi.prenderSwitch();

        }else {
            System.out.println("Desea prender el switch?: s/n");
            respuesta = scanner.nextLine();
            if(respuesta.equals("s")) switch_wifi.prenderSwitch();
        }

        System.out.println("El estado del Switch es = " + switch_wifi.isOn());

    }
}
