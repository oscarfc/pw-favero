/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tombola;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oscar.favero
 */
public class Tombola {
    private final static int NUMERO_ESTRAZINONI = 30;
    private Cartella[] cartelle = new Cartella[30];
    private int[] archivioEstratti = new int[90];
    int numeroEstratti = 0;

    public static void main(String[] args) {
        Tombola tombola = new Tombola();
        int ultimoEstratto;
        List<Integer> listaCartelleTrovate;
        boolean amboDaTrovare = true;
        boolean ternoDaTrovare = false;
        boolean quaternaDaTrovare = false;
        boolean cinquinaDaTrovare = false;
        boolean tombolaDaTrovare = false;

        tombola.creaCartelle();
        tombola.stampaCartelle();
        for (int i = 0; i < NUMERO_ESTRAZINONI; i++) {
            ultimoEstratto = tombola.estraiNumero();
            tombola.segnaEstratto(ultimoEstratto);
            if (amboDaTrovare && (listaCartelleTrovate = tombola.verificaAmbo()) != null) {
                amboDaTrovare = false;
                ternoDaTrovare = true;
                for (Integer id : listaCartelleTrovate) {
                    System.out.println("Ambo nella Cartella " + (id + 1));
                }
            } else if (ternoDaTrovare && (listaCartelleTrovate = tombola.verificaTerno()) != null) {
                ternoDaTrovare = false;
                quaternaDaTrovare = true;
                for (Integer id : listaCartelleTrovate) {
                    System.out.println("Terno nella Cartella " + (id + 1));
                }
            } else if (quaternaDaTrovare && (listaCartelleTrovate = tombola.verificaQuaterna()) != null) {
                quaternaDaTrovare = false;
                cinquinaDaTrovare = true;
                for (Integer id : listaCartelleTrovate) {
                    System.out.println("Quaterna nella Cartella " + (id + 1));
                }
            } else if (cinquinaDaTrovare && (listaCartelleTrovate = tombola.verificaCinquina()) != null) {
                cinquinaDaTrovare = false;
                for (Integer id : listaCartelleTrovate) {
                    System.out.println("Cinquina nella Cartella " + (id + 1));
                }
            }
        }
        tombola.stampaListaEstratti();
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
        archivioEstratti[numeroEstratti] = estratto;
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

    private List<Integer> verificaAmbo() {
        List<Integer> cartelleConAmbo = new ArrayList();

        for (int i = 0; i < 30; i++) {
            if (cartelle[i].verificaAmbo()) {
                cartelleConAmbo.add(i);
            }
        }
        if (cartelleConAmbo.isEmpty()) {
            return null;
        } else {
            return cartelleConAmbo;
        }
    }

    private List<Integer> verificaTerno() {
        List<Integer> cartelleConTerno = new ArrayList();
        for (int i = 0; i < 30; i++) {
            if (cartelle[i].verificaTerno()) {
                cartelleConTerno.add(i);
            }
        }
        if (cartelleConTerno.isEmpty()) {
            return null;
        } else {
            return cartelleConTerno;
        }
    }

    private List<Integer> verificaQuaterna() {
        List<Integer> cartelleConQuaterna = new ArrayList();
        for (int i = 0; i < 30; i++) {
            if (cartelle[i].verificaQuaterna()) {
                cartelleConQuaterna.add(i);
            }
        }
        if (cartelleConQuaterna.isEmpty()) {
            return null;
        } else {
            return cartelleConQuaterna;
        }
    }

    private List<Integer> verificaCinquina() {
        List<Integer> cartelleConCinquina = new ArrayList();
        for (int i = 0; i < 30; i++) {
            if (cartelle[i].verificaCinquina()) {
                cartelleConCinquina.add(i);
            }
        }
        if (cartelleConCinquina.isEmpty()) {
            return null;
        } else {
            return cartelleConCinquina;
        }
    }

    private void stampaListaEstratti() {
        String estratti = "";
        for (int i = 0; i < NUMERO_ESTRAZINONI; i++) {
            estratti += archivioEstratti[i] + ", ";
        }
        System.out.println("Elenco numeri Estratti: " + estratti);
    }
}
