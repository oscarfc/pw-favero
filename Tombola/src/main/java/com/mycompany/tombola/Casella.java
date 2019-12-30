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
public class Casella {
    private int numero;
    private boolean segnato;

    public Casella(int numero) {
        this.numero = numero;
        setSegnato(false);
    }

    public int getNumero() {
        return numero;
    }

    public boolean isSegnato() {
        return segnato;
    }

    public void setSegnato(boolean segnato) {
        this.segnato = segnato;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.numero;
        hash = 97 * hash + (this.segnato ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Casella other = (Casella) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.segnato != other.segnato) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Casella{" + "numero=" + numero + ", segnato=" + segnato + '}';
    }    
    
    public int getDecina(){
        return numero / 10;
    }
}
