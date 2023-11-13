package Opgave1;

public class Mekaniker extends Person{

    private int svendeprøveÅr;
    private int timelønssats;


    public Mekaniker(String navn, String adresse, int svendeprøveÅr, int timelønssats) {
        super(navn, adresse);
        this.svendeprøveÅr = svendeprøveÅr;
        this.timelønssats = timelønssats;
    }

    public void setSvendeprøveÅr(int svendeprøveÅr) {
        this.svendeprøveÅr = svendeprøveÅr;
    }

    public void setTimelønssats(int timelønssats) {
        this.timelønssats = timelønssats;
    }

    public int getSvendeprøveÅr() {
        return svendeprøveÅr;
    }

    public int getTimelønssats() {
        return timelønssats;
    }

    public int beregnLøn(){
        int løn = getTimelønssats() * 37;
        return løn;
    }

}
