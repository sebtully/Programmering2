public class Sommerhus extends Hus{

    private boolean erboboet;
    public Sommerhus(String adresse, int kvm, int grundKvm, boolean erboboet) {
        super(adresse, kvm, grundKvm);

        this.erboboet = erboboet;

    }

    @Override
    public int ejendomsværdi() {
        return super.ejendomsværdi() - 24;
    }
}
