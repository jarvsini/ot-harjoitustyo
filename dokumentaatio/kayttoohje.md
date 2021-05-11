# Käyttöohje

Lataa tiedosto [Calculator-1.0-SNAPSHOT.jar](https://github.com/jarvsini/ot-harjoitustyo/releases/tag/viikko6)

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla

```javascript
java -jar Calculator-1.0-SNAPSHOT.jar
```
## Laskun suorittaminen

Sovellus käynnistyy laskimen näkymään:

![gui](https://github.com/jarvsini/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/gui.png)

Laskeminen käyttö tapahtuu klikkailemalla nappeja.

Aloita klikkaamalla numeronappeja (0-9), kunnes laskimeen on tulostunut haluamasi luku. 
Luku voi koostua useammasta numerosta. Et voi aloittaa klikkaamalla komentonappia.

Klikkaa seuraavaksi haluamasi laskutoimituksen nappia (+, -, x, /). Voit laskea yhteen-, vähennys-, kerto- ja jakolaskuja.

Klikkaa jälleen numeroita, kunnes laskusi on valmis.

Suorita lasku klikkaamalla "="-nappia.

![ohje](https://github.com/jarvsini/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/ohje.png)

Laskin antaa sinulle tuloksen. Voit aloittaa kokonaan uuden laskun klikkaamalla seuraavaksi jälleen numeroita.
Tai voit jatkaa laskemista saadulla tuloksella klikkaamalla seuraavaksi jotakin napeista +, -, x, / .

## Laskimen nollaaminen

Mikäli kirjoittaessa sattuu virhe, voi laskimen nollata klikkaamalla nappia "C". Nyt voit aloittaa alusta.

## Aiempien laskujen tarkastelu

Sovellus tallentaa suoritetut laskut. Voit nähdä tallennetut, laskimella aiemmin suoritetut laskut klikkaamalla
punaista nappia "M". Sovellus tulostaa laskut tekstikäyttöliittymään muodossa

```
;5+3=8;3x6=18;40+602=642;50/25=2;2+51=53
```

Laskutoimitukset on eroteltu toisistaan puolipisteellä.

## Sovelluksen sulkeminen

Klikkaa ikkunan oikeassa yläkulmassa olevaa painiketta "x" ja sovellus sulkeutuu sekä ohjelma päättyy.
