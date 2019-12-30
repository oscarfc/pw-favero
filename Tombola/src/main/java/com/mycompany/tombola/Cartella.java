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
public class Cartella {

    private Casella[] caselle;
    private final int NUMERO_CASELLE = 15;

    public Cartella() {
        caselle = new Casella[NUMERO_CASELLE];

        for (int i = 0; i < caselle.length; i++) {
            caselle[i] = creaCasella(caselle, i);
        }
    }

    private Casella creaCasella(Casella[] caselle1, int i) {
        Casella newCasella;
        do {
            newCasella = new Casella(generaNumero());
        } while (verificaCasella(caselle1, newCasella, i));
        return newCasella;
    }

    private int generaNumero() {
        int numero = (int) (Math.round((Math.random() * 90)));
        if (numero == 0) {
            numero++;
        }
        return numero;
    }

    private boolean verificaCasella(Casella[] caselle1, Casella newCasella, int numeroCaselleGenerate) {
        boolean verifica = false;

        if (numeroCaselleGenerate > 0) {
            // faccio controlli solo dopo genarazione della prima casella
            for (int j = 0; j < numeroCaselleGenerate; j++) {
                // verifica che nella cartella non siano presenti 2 numeri uguali
                if (caselle1[j].equals(newCasella)) {
                    verifica = true;
                    break;
                }
            }
            if (!verifica) {
                // verifica che nella riga non siano presenti 2 numeri nella stessa 
                // decina, ad esempio 11 e 13
                if (numeroCaselleGenerate < 5) {
                    // prima riga
                    if (checkDecinaEquals(caselle1, 0, numeroCaselleGenerate, newCasella)) {
                        verifica = true;
                    }
                }
                if (!verifica && numeroCaselleGenerate >= 5 && numeroCaselleGenerate < 10) {
                    // seconda riga
                    if (checkDecinaEquals(caselle1, 5, numeroCaselleGenerate, newCasella)) {
                        verifica = true;
                    }
                }
                if (!verifica && numeroCaselleGenerate < NUMERO_CASELLE && numeroCaselleGenerate >= 10) {
                    // terza riga
                    if (checkDecinaEquals(caselle1, 10, numeroCaselleGenerate, newCasella)) {
                        verifica = true;
                    }
                }
            }
        }
        return verifica;
    }

    @Override
    public String toString() {
        return "Cartella{" + "caselle=" + caselle + ", NUMERO_CASELLE=" + NUMERO_CASELLE + '}';
    }

    private boolean checkDecinaEquals(Casella[] caselle1, int primaCasellaDaVerificare, int ultimaCaselleGenerate, Casella casella) {
        boolean verifica = false;
        for (int i = primaCasellaDaVerificare; i < ultimaCaselleGenerate; i++) {
            if (casella.getDecina() == caselle[i].getDecina()) {
                verifica = true;
                break;
            }
        }
        return verifica;
    }

    private String getRow(int begin, int end) {
        String row = "- ";
        for (int i = begin; i < end; i++) {
            row += caselle[i].getNumero() + (caselle[i].isSegnato() ? "*" : "") + ", ";
        }
        return row;
    }

    public String getFirstRow() {
        return getRow(0, 5);
    }

    public String getSecondRow() {
        return getRow(5, 10);
    }

    public String getThirdRow() {
        return getRow(10, 15);
    }

    public boolean segnaEstratto(int estratto) {
        boolean cartellaContieneNumero = false;
        for (int i = 0; i < NUMERO_CASELLE; i++) {
            if (caselle[i].getNumero() == estratto) {
                caselle[i].setSegnato(true);
                cartellaContieneNumero = true;
                break;
            }
        }
        return cartellaContieneNumero;
    }
}
