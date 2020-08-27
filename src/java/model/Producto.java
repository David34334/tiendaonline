package model;

public class Producto {
    
    private int id;
    private int id_carrito;
    private String nombre;
    private double precio;
    private String imagen;
    private String descripcion;
    
    public Producto() {
        
    }

    public Producto(int id, int id_carrito, String nombre, double precio, String imagen, String descripcion) {
        this.id = id;
        this.id_carrito = id_carrito;
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", id_carrito=" + id_carrito + ", nombre=" + nombre + ", precio=" + precio + ", imagen=" + imagen + ", descripcion=" + descripcion + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
