/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author b_urb
 */
public class Carro {
    private double precio;
    private int id_usuario;

    public Carro() {
    }

    public Carro(double precio, int id_usuario) {
        this.precio = precio;
        this.id_usuario = id_usuario;
    }
    
    

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
    
    
}
