package ohtu;

import javax.swing.JTextField;

public class Summa implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinen;

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.edellinen = 0;
    }

    @Override
    public void suorita() {
        edellinen = Integer.parseInt(tuloskentta.getText());
        sovellus.plus(Integer.parseInt(syotekentta.getText()));
        tuloskentta.setText("" + sovellus.tulos());
    }

    @Override
    public void peru() {
        tuloskentta.setText("" + edellinen);
    }
    
}
