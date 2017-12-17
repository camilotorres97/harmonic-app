package co.com.harmonic.domain.model;

/**
 * Created by Rodolhan on 16/12/2017.
 */

public class Instructor {
    private String apodo;
    private String biografia;
    private String nombre;
    private String precio;
    private float rating;
    private String rol;
    private String image;

    public Instructor() {
    }

    public Instructor(String apodo, String biografia, String nombre, String precio, int rating, String rol, String image) {
        this.apodo = apodo;
        this.biografia = biografia;
        this.nombre = nombre;
        this.precio = precio;
        this.rating = rating;
        this.rol = rol;
        this.image = image;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}