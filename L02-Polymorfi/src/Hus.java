public class Hus extends Beboelse {

    private int grundKvm;

    public Hus(String adresse, int kvm, int erboboet) {
        super(adresse, kvm);
        this.grundKvm = grundKvm;
    }

    public int ejendomsværdi() {
        int værdi = super.getKvm() * 290 + this.grundKvm * 40;
        return værdi;
    }
}
