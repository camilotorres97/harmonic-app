package co.com.harmonic.domain.model;

/**
 * Created by Rodolhan on 16/12/2017.
 */

public class Instrument {
    private String image;
    private String instrumento;
    private Integer id_categoria;


    public Instrument() {
    }

    public Instrument(String image, String instrumento, Integer id_categoria) {
        this.image = image;
        this.instrumento = instrumento;
        this.id_categoria = id_categoria;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

}
