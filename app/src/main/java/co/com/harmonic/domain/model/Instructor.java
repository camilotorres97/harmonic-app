package co.com.harmonic.domain.model;

/**
 * Created by Rodolhan on 16/12/2017.
 */

public class Instructor {
    private String apodo;
    private String biografia;
    private String nombre;
    private String precio;
    private String rating;
    private String rol;
    private String image;
    private String id_instructor;

    public Instructor() {
    }

    public Instructor(String apodo, String biografia, String nombre, String precio, String rating, String rol, String image, String id_instructor) {
        this.apodo = apodo;
        this.biografia = biografia;
        this.nombre = nombre;
        this.precio = precio;
        this.rating = rating;
        this.rol = rol;
        this.image = image;
        this.id_instructor = id_instructor;

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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
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

    public String getId_instructor() {
        return id_instructor;
    }

    public void setId_instructor(String id_instructor) {
        this.id_instructor = id_instructor;
    }
}