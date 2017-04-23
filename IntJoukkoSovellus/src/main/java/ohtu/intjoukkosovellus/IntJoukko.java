package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        ljono = new int[KAPASITEETTI];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        this();
        if (kapasiteetti < 0) {
            return;
        }
        ljono = new int[kapasiteetti];
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        this(kapasiteetti);
        if (kasvatuskoko < 0) {
            return;
        }
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaaLukuJoukkoon(int luku) {
        if (!lukuKuuluuJoukkoon(luku)) {
            ljono[alkioidenLkm++] = luku;

            if (alkioidenLkm == ljono.length) {
                int[] taulukkoOld = ljono;
                ljono = new int[alkioidenLkm + kasvatuskoko];
                kopioiTaulukko(taulukkoOld, ljono);
            }
            return true;
        }
        return false;
    }

    public boolean lukuKuuluuJoukkoon(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poistaLukuJoukosta(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                ljono[i] = 0;
                for (int j = i; j < alkioidenLkm - 1; j++) {
                    ljono[j] = ljono[j + 1];
                }
                alkioidenLkm--;
                return true;
            }
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{");
        for (int i = 0; i < alkioidenLkm - 1; i++) str.append(ljono[i] + ", ");
        if (alkioidenLkm >= 1) str.append(ljono[alkioidenLkm - 1]);
        str.append("}");

        return str.toString();
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) taulu[i] = ljono[i];
        return taulu;
    }

    public static IntJoukko palautaJoukkojenYhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaaLukuJoukkoon(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaaLukuJoukkoon(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko palautaJoukkojenLeikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaaLukuJoukkoon(bTaulu[j]);
                }
            }
        }
        return y;

    }

    public static IntJoukko palautaJoukkojenErotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaaLukuJoukkoon(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poistaLukuJoukosta(bTaulu[i]);
        }
        return z;
    }

}
