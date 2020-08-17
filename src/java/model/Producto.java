package model;

public class Producto {
    
    private String nombreProducto;
    private String descripProducto;
    private double precioProducto;
    private String urlPhotoProducto;
    
    
    public Producto() {
        
    }

    public Producto(String nombreProducto, String descripProducto, double precioProducto, String urlPhotoProducto) {
        this.nombreProducto = nombreProducto;
        this.descripProducto = descripProducto;
        this.precioProducto = precioProducto;
        this.urlPhotoProducto = urlPhotoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripProducto() {
        return descripProducto;
    }

    public void setDescripProducto(String descripProducto) {
        this.descripProducto = descripProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getUrlPhotoProducto() {
        return urlPhotoProducto;
    }

    public void setUrlPhotoProducto(String urlPhotoProducto) {
        this.urlPhotoProducto = urlPhotoProducto;
    }

}
