package ohtu;

import javax.swing.JTextField;

public class Nollaa implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        sovellus.nollaa();
        tuloskentta.setText("" + sovellus.tulos());
    }

    @Override
    public void peru() {

    }
    
}
