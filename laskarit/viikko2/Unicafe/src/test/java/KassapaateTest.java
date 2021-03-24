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
        assertEquals(1000, kassa.kassassaRahaa());
    }
    
    @Test
    public void luodunKassanMyydytLounaatOikein() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty()+kassa.maukkaitaLounaitaMyyty());
    }
   
    //käteisosto toimii sekä edullisten että maukkaiden lounaiden osalta
    //jos maksu riittävä: kassassa oleva rahamäärä kasvaa lounaan hinnalla ja vaihtorahan suuruus on oikea
    @Test
    public void kassaKasvaaOikeinEdullisenOstosta() {
        int rahaa = kassa.kassassaRahaa();
        kassa.syoEdullisesti(500);
        assertEquals(rahaa+240, kassa.kassassaRahaa());
    }
    
    @Test
    public void vahtorahaOikeinEdullisesta() {
        assertEquals(500-240, kassa.syoEdullisesti(500));
    }
    
    @Test
    public void kassaKasvaaOikeinMaukkaanOstosta() {
        int rahaa = kassa.kassassaRahaa();
        kassa.syoMaukkaasti(500);
        assertEquals(rahaa+400, kassa.kassassaRahaa());
    }
    
    @Test
    public void vahtorahaOikeinMaukkaasta() {
        assertEquals(500-400, kassa.syoMaukkaasti(500));
    }
    
    //jos maksu on riittävä: myytyjen lounaiden määrä kasvaa
    @Test
    public void myydytEdullisetKasvaaOikein() {
        kassa.syoEdullisesti(500);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void myydytMaukkaatKasvaaOikein() {
        kassa.syoMaukkaasti(500);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    //jos maksu ei ole riittävä: kassassa oleva rahamäärä ei muutu, kaikki rahat palautetaan vaihtorahana ja myytyjen lounaiden määrässä ei muutosta
    @Test
    public void riittamatonMaksuEiMuutaKassaa() {
        int rahaa = kassa.kassassaRahaa();
        kassa.syoEdullisesti(1);
        kassa.syoMaukkaasti(2);
        assertEquals(rahaa, kassa.kassassaRahaa());
    }
    
    @Test
    public void riittamatonMaksuPalauttaaKaikkiVaihtorahat() {
        assertEquals(1, kassa.syoEdullisesti(1));
        assertEquals(2, kassa.syoMaukkaasti(2));
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
        int rahaa = kassa.kassassaRahaa();
        Maksukortti kortti = new Maksukortti(8000);
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(rahaa, kassa.kassassaRahaa());
    }

    //kortille rahaa ladattaessa kortin saldo muuttuu ja kassassa oleva rahamäärä kasvaa ladatulla summalla
    @Test
    public void korttiaLadattaessaKassaKasvaaOikein() {
        int rahaa = kassa.kassassaRahaa();
        Maksukortti kortti = new Maksukortti(100);
        kassa.lataaRahaaKortille(kortti, 200);
        assertEquals(rahaa+200, kassa.kassassaRahaa());
        
    }
    

}
