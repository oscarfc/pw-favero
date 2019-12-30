/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tombola;

/**
 *
 * @author oscar.favero
 */
public class Tombola {

    private Cartella[] cartelle = new Cartella[30];

    public static void main(String[] args) {
        Tombola tombola = new Tombola();

        tombola.creaCartelle();
        tombola.stampaCartelle();
    }

    private void creaCartelle() {
        for (int i = 0; i < cartelle.length; i++) {
            cartelle[i] = new Cartella();
        }
    }

    private void stampaCartelle() {
        for (int i = 0; i < cartelle.length; i++) {
            System.out.println("Cartella numero: " + (i + 1));
            System.out.println(cartelle[i].getFirstRow());
            System.out.println(cartelle[i].getSecondRow());
            System.out.println(cartelle[i].getThirdRow());
        }
    }
}
