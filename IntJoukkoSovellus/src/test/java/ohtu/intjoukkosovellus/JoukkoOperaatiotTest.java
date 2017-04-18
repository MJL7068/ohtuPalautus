
package ohtu.intjoukkosovellus;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JoukkoOperaatiotTest {
    IntJoukko a, b;
    
    @Before
    public void setUp() {
        a = uusiJoukko(1,2,3);
        b = uusiJoukko(3,4);
    }
    
    @Test
    public void joukkojenYhdisteToimii() {
        IntJoukko tulos = IntJoukko.palautaJoukkojenYhdiste(a, b);
        int[] vastauksenLuvut = tulos.toIntArray();
        Arrays.sort(vastauksenLuvut);
        
        int[] odotettu = {1,2,3,4};
        
        assertArrayEquals(odotettu, vastauksenLuvut);        
    } 
    
    @Test
    public void joukkojenLeikkausToimii() {
        IntJoukko tulos = IntJoukko.palautaJoukkojenLeikkaus(a, b);
        int[] vastauksenLuvut = tulos.toIntArray();
        
        int[] odotettu = {3};
        
        assertArrayEquals(odotettu, vastauksenLuvut); 
    }
    
    @Test
    public void joukkojenErotusToimii() {
        IntJoukko tulos = IntJoukko.palautaJoukkojenErotus(a, b);
        int[] vastauksenLuvut = tulos.toIntArray();
        Arrays.sort(vastauksenLuvut);
        
        int[] odotettu = {1,2};
        
        assertArrayEquals(odotettu, vastauksenLuvut); 
    }

    private IntJoukko uusiJoukko(int... luvut) {
        IntJoukko joukko = new IntJoukko();
        
        for (int luku : luvut) {
            joukko.lisaaLukuJoukkoon(luku);
        }
        
        return joukko;
    }
}
