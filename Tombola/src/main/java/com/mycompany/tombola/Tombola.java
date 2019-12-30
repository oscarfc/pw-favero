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
    private int[] archivioEstratti = new int[90];
    int numeroEstratti = 0;

    public static void main(String[] args) {
        Tombola tombola = new Tombola();
        int ultimoEstratto;

        tombola.creaCartelle();
        tombola.stampaCartelle();
        for (int i = 0; i < 30; i++) {
            ultimoEstratto = tombola.estraiNumero();
            tombola.segnaEstratto(ultimoEstratto);
        }
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

    private int generaNumero() {
        int numero = (int) (Math.round((Math.random() * 90)));
        if (numero == 0) {
            numero++;
        }
        return numero;
    }

    private int estraiNumero() {
        int estratto;

        do {
            estratto = generaNumero();
        } while (controllaEstratti(estratto));
        numeroEstratti++;
        return estratto;
    }

    private boolean controllaEstratti(int estratto) {
        boolean giaEstratto = false;
        for (int i = 0; i < numeroEstratti; i++) {
            if (archivioEstratti[i] == estratto) {
                giaEstratto = true;
                break;
            }
        }
        return giaEstratto;
    }

    private void segnaEstratto(int ultimoEstratto) {
        for (Cartella cartella : cartelle) {
            cartella.segnaEstratto(ultimoEstratto);            
        }
    }
}
