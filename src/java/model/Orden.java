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
public class Orden {
     private int id_carro;
    private int id_producto;
    private int cantidad;

    public Orden() {
    }

    public Orden(int id_carro, int id_producto, int cantidad) {
        this.id_carro = id_carro;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }
    

    public int getId_carro() {
        return id_carro;
    }

    public void setId_carro(int id_carro) {
        this.id_carro = id_carro;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    
}
