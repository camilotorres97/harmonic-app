package co.com.harmonic.domain.model;

/**
 * Created by Rodolhan on 16/12/2017.
 */

public class Instrument {
    private String image;
    private String instrumento;

    public Instrument() {
    }

    public Instrument(String image, String instrumento) {
        this.image = image;
        this.instrumento = instrumento;
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
}
