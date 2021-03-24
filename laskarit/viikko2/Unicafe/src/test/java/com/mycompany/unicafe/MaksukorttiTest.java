package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoAlussaOikein() {
        assertEquals("saldo: 10.0", kortti.toString());
    }
    
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(7);
        assertEquals("saldo: 17.0", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeOikein() {
        kortti.otaRahaa(4);
        assertEquals("saldo: 6.0", kortti.toString());
    }
    
    @Test
    public void saldoEiMuutuJosRahatEiRiita() {
        kortti.otaRahaa(11);
        assertEquals("saldo: 10.0", kortti.toString());
    }
    
    @Test
    public void rahanOttoToimiiJosRahatRiittaa() {
        assertTrue(kortti.otaRahaa(5));
    }
    
    @Test
    public void rahanOttoToimiiJosRahatEiRiita() {
        assertFalse(kortti.otaRahaa(13));
    }
    
    @Test
    public void tulostaaSaldonOikein() {
        assertEquals("saldo: 10.0", kortti.toString());
    }

}
