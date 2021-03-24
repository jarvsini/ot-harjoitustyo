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
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(7);
        assertEquals(17, kortti.saldo());
    }
    
    @Test
    public void saldoVaheneeOikein() {
        kortti.otaRahaa(4);
        assertEquals(6, kortti.saldo());
    }
    
    @Test
    public void saldoEiMuutuJosRahatEiRiita() {
        kortti.otaRahaa(11);
        assertEquals(10, kortti.saldo());
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
        assertEquals("saldo: 10.00", kortti.toString());
    }

}
