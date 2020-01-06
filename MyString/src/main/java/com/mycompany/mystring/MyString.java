/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mystring;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oscar.favero
 */
public class MyString implements Cloneable {

    String stringa;

    @Override
    public MyString clone() throws CloneNotSupportedException {
        return (MyString) super.clone();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        int hash1 = 0;
        hash = 73 * hash;
        char[] lettere = inventarioChar();
        for (int i = 0; i < lettere.length; i++) {
            hash1 += lettere[i] * hash;
        }
        return hash + hash1;
    }

    @Override
    public boolean equals(Object obj) {
        char[] lettere;
        char[] lettereOther;
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        lettere = inventarioChar();
        final MyString other = (MyString) obj;
        lettereOther = other.inventarioChar();
        return checkIfEquals(lettere, lettereOther);
    }

    @Override
    public String toString() {
        return "MyString{" + "stringa=" + stringa + '}';
    }

    public String getStringa() {
        return stringa;
    }

    public MyString(String stringa) {
        this.stringa = stringa;
    }

    private char[] inventarioChar() {
        List<Character> lettere = new ArrayList<>();
        for (int i = 0; i < stringa.length(); i++) {
            if (!lettere.contains(stringa.charAt(i))) {
                lettere.add(stringa.charAt(i));
            }
        }
        char[] lett = new char[lettere.size()];
        for (int i = 0; i < lettere.size(); i++) {
            lett[i] = lettere.get(i);

        }
        return lett;
    }

    private boolean checkIfEquals(char[] lettere, char[] lettereOther) {
        if (lettere.length != lettereOther.length) {
            return false;
        }
        for (char lettereOther1 : lettereOther) {
            if (!contiene(lettere, lettereOther1)) {
                return false;
            }
        }
        return true;
    }

    private boolean contiene(char[] lettere, char lettereOther) {
        for (int i = 0; i < lettere.length; i++) {
            if (lettereOther == lettere[i]) {
                return true;
            }
        }
        return false;
    }
}
