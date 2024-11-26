package com.example.demo;

public class Producto {

    private Integer idProducto;
    private String  nombre;
    private Integer precio;
    private Integer stock;

//CLASE PERSISTENTE: CONSTRUCTOR VACIO, ATRIBUTOS, GET Y SET 
    public Producto() {
    }

    public Producto(String nombre, int precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Integer getidProducto() {
        return idProducto;
    }

    public void setidProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getprecio() {
        return precio;
    }

    public void setprecio(int precio) {
        this.precio = precio;
    }

    public Integer getstock() {
        return stock;
    }

    public void setstock(int stock) {
        this.stock = stock;
    }



    
}
