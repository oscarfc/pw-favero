/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.engine;

/**
 *
 * @author oscar.favero
 */
public class Prova {

    public static void main(String[] args) {
        Engine a = new Engine(1200, 69);
        Engine b = new Engine(1200, 75);
        Engine c = new Engine(1400, 75);
        System.out.println(a);
        System.out.println(a.equals(b));
        Engine aVol = a.byVolume();
        Engine bVol = b.byVolume();
        System.out.println(aVol);
        System.out.println(aVol.equals(bVol));
        System.out.println(a == aVol);
    }
}
