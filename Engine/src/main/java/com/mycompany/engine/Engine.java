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
public class Engine {
    private double cilindata;
    private double potenza;

    public Engine(double cilindata, double potenza) {
        this.cilindata = cilindata;
        this.potenza = potenza;
    }

    public double getCilindata() {
        return cilindata;
    }

    public double getPotenza() {
        return potenza;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.cilindata) ^ (Double.doubleToLongBits(this.cilindata) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.potenza) ^ (Double.doubleToLongBits(this.potenza) >>> 32));
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
        final Engine other = (Engine) obj;
        if (Double.doubleToLongBits(this.cilindata) != Double.doubleToLongBits(other.cilindata)) {
            return false;
        }
        if (Double.doubleToLongBits(this.potenza) != Double.doubleToLongBits(other.potenza)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Engine{" + "cilindata=" + cilindata + " cm3, potenza=" + potenza + " CV }";
    }
     
    Volume vol = new Volume (){
        public boolean equals(Engine e) {
            return true;
        }
    };

    public Engine byVolume() {
        return new Engine(this.cilindata, this.potenza) {
            public boolean equals(Engine e) {
                return true;
            }
        };
//       vol.equals(this);
    }
}
