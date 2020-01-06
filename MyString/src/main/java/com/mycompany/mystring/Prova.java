/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mystring;

/**
 *
 * @author oscar.favero
 */
public class Prova {

    public static void main(String[] args) throws CloneNotSupportedException {
        MyString a = new MyString("freddo");
        MyString b = new MyString("defro");
        MyString c = new MyString("caldo");
        MyString d = c.clone();
        System.out.println(a.equals(b));
        System.out.println(b.equals(c));
        System.out.println(a.hashCode() == b.hashCode());
    }
}
