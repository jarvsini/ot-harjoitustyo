# Testausdokumentti

Ohjelmaa on testattu yksikkötestein JUnitilla ja manuaalisesti tapahtunein järjestelmätason testein.

## Yksikkötestaus

Luokkien ja metodien toimintaa on testattu yksikkötesteillä.

Sovelluslogiikkaa eli pakkauksen calculator.domain luokkia testaavat testit ModelTest.java sekä jokaisen Operator-luokan 
oma testi AdditionTest.java, DivisionTest.java, MultiplicationTest.java, SubtractionTest.java ja UnknownTest.java.

Pakkauksen calculator.data luokkaa History testaa testi HistoryTest.java.

## Testauskattavuus

Käyttöliittymäkerrosta lukuunottamatta sovelluksen rivikattavuus on 92% ja haarautumakattavuus on 100%. 

![testikattavuus](https://github.com/jarvsini/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/testikattavuus.png)

## Järjestelmätestaus

Sovellusta on testattu Linux-ympäristöön hakemalle sovellus ja toimimalla käyttöohjeen kuvaamalla tavalla.

Järjestelmää on testattu kokonaisuutena ja on verrattu, että se toimii vaatimusdokumentissa sovitun määritelmän mukaisesti.
Testaus on suoritettu ohjelmiston käyttöliittymän kautta.

Kaikki määrittelydokumentin ja käyttöohjeen listaamat toiminnallisuudet on käyty läpi. Toiminnallisuuksien yhteydessä
on tehty virheellisiä toimintoja kuten yritetty syöttää lasku " 3+-/4 " tai luku " 00005 ".
