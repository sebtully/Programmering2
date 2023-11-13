package Opgave1;

public class Værkfører extends Mekaniker{

    private int udnævnelsesÅr;
    private int tillæg;
    public Værkfører(String navn, String adresse, int svendeprøveÅr, int timelønssats, int udnævnelsesÅr, int tillæg) {
        super(navn, adresse, svendeprøveÅr, timelønssats);
        this.udnævnelsesÅr = udnævnelsesÅr;
        this.tillæg = tillæg;


    }

    public void setUdnævnelsesÅr(int udnævnelsesÅr) {
        this.udnævnelsesÅr = udnævnelsesÅr;
    }

    public void setTilæg(int tillæg) {
        this.tillæg = tillæg;
    }

    public int getUdnævnelsesÅr() {
        return udnævnelsesÅr;
    }

    public int getTillæg() {
        return tillæg;
    }

    @Override
    public int beregnLøn() {
        int løn = super.beregnLøn() + getTillæg();
        return løn;
    }
}
