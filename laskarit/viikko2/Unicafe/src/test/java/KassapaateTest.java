import com.mycompany.unicafe.Kassapaate;
import com.mycompany.unicafe.Maksukortti;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class KassapaateTest {
    
    Kassapaate kassa;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }
    
    //luodun kassapäätteen rahamäärä ja myytyjen lounaiden määrä on oikea (rahaa 1000, lounaita myyty 0)
    @Test
    public void luodunKassanRahaOikein() {
        assertEquals(Double.toString(1000), Double.toString(kassa.kassassaRahaa()));
    }
    
    @Test
    public void luodunKassanMyydytLounaatOikein() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty()+kassa.maukkaitaLounaitaMyyty());
    }
   
    //käteisosto toimii sekä edullisten että maukkaiden lounaiden osalta
    //jos maksu riittävä: kassassa oleva rahamäärä kasvaa lounaan hinnalla ja vaihtorahan suuruus on oikea
    @Test
    public void kassaKasvaaOikeinEdullisenOstosta() {
        double rahaa = kassa.kassassaRahaa();
        kassa.syoEdullisesti(500);
        assertEquals(Double.toString(rahaa+2.4), Double.toString(kassa.kassassaRahaa()));
    }
    
    @Test
    public void vahtorahaOikeinEdullisesta() {
        assertEquals(Double.toString(5-2.4), Double.toString(kassa.syoEdullisesti(5)));
    }
    
    @Test
    public void kassaKasvaaOikeinMaukkaanOstosta() {
        double rahaa = kassa.kassassaRahaa();
        kassa.syoMaukkaasti(5);
        assertEquals(Double.toString(rahaa+4), Double.toString(kassa.kassassaRahaa()));
    }
    
    @Test
    public void vahtorahaOikeinMaukkaasta() {
        assertEquals(Double.toString(5-4), Double.toString(kassa.syoMaukkaasti(5)));
    }
    
    //jos maksu on riittävä: myytyjen lounaiden määrä kasvaa
    @Test
    public void myydytEdullisetKasvaaOikein() {
        kassa.syoEdullisesti(5);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void myydytMaukkaatKasvaaOikein() {
        kassa.syoMaukkaasti(5);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    //jos maksu ei ole riittävä: kassassa oleva rahamäärä ei muutu, kaikki rahat palautetaan vaihtorahana ja myytyjen lounaiden määrässä ei muutosta
    @Test
    public void riittamatonMaksuEiMuutaKassaa() {
        double rahaa = kassa.kassassaRahaa();
        kassa.syoEdullisesti(1);
        kassa.syoMaukkaasti(2);
        assertEquals(Double.toString(rahaa), Double.toString(kassa.kassassaRahaa()));
    }
    
    @Test
    public void riittamatonMaksuPalauttaaKaikkiVaihtorahat() {
        assertEquals(Double.toString(1.0), Double.toString(kassa.syoEdullisesti(1)));
        assertEquals(Double.toString(2.0), Double.toString(kassa.syoMaukkaasti(2)));
    }
    
    @Test
    public void riittamatonMaksuEiMuutaMyytyjaLounaita() {
        int edullisia = kassa.edullisiaLounaitaMyyty();
        int maukkaita = kassa.maukkaitaLounaitaMyyty();
        kassa.syoEdullisesti(1);
        kassa.syoMaukkaasti(2);
        assertEquals(edullisia, kassa.edullisiaLounaitaMyyty());
        assertEquals(maukkaita, kassa.maukkaitaLounaitaMyyty());
    }
    
    //korttiosto toimii sekä edullisten että maukkaiden lounaiden osalta
    //jos kortilla on tarpeeksi rahaa, veloitetaan summa kortilta ja palautetaan true
    //jos kortilla on tarpeeksi rahaa, myytyjen lounaiden määrä kasvaa
    //jos kortilla ei ole tarpeeksi rahaa, kortin rahamäärä ei muutu, myytyjen lounaiden määrä muuttumaton ja palautetaan false
    @Test
    public void korttiHyvaksytaanOikeinEdullisenOsalta() {
        Maksukortti a = new Maksukortti(500);
        assertTrue(kassa.syoEdullisesti(a));
        Maksukortti b = new Maksukortti(0);
        assertFalse(kassa.syoEdullisesti(b));
    }
    
    @Test
    public void korttiHyvaksytaanOikeinMaukkaanOsalta() {
        Maksukortti a = new Maksukortti(500);
        Maksukortti b = new Maksukortti(0);
        assertTrue(kassa.syoMaukkaasti(a));
        assertFalse(kassa.syoMaukkaasti(b));
    }
    
    @Test
    public void lounaidenMaaraMuuttuuOikeinKorttiostoksissaEdullinen() {
        Maksukortti a = new Maksukortti(500);
        Maksukortti b = new Maksukortti(0);
        kassa.syoEdullisesti(a);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        kassa.syoEdullisesti(b);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
     @Test
    public void lounaidenMaaraMuuttuuOikeinKorttiostoksissaMaukas() {
        Maksukortti a = new Maksukortti(500);
        Maksukortti b = new Maksukortti(0);
        kassa.syoMaukkaasti(a);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        kassa.syoMaukkaasti(b);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    //kassassa oleva rahamäärä ei muutu kortilla ostettaessa
    @Test
    public void kassaEiMuutuKorttiostoissa() {
        double rahaa = kassa.kassassaRahaa();
        Maksukortti kortti = new Maksukortti(8000);
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(Double.toString(rahaa), Double.toString(kassa.kassassaRahaa()));
    }

    //kortille rahaa ladattaessa kortin saldo muuttuu ja kassassa oleva rahamäärä kasvaa ladatulla summalla
    @Test
    public void korttiaLadattaessaKassaKasvaaOikein() {
        double rahaa = kassa.kassassaRahaa();
        Maksukortti kortti = new Maksukortti(100);
        kassa.lataaRahaaKortille(kortti, -2);
        kassa.lataaRahaaKortille(kortti, 200);
        assertEquals(Double.toString(rahaa+200), Double.toString(kassa.kassassaRahaa()));
    }


}
