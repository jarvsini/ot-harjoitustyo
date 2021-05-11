# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovellus on laskin, jolla käyttäjä pystyy suorittamaan kaikki tavallisemmat laskut.

## Käyttäjät

Sovelluksen käyttöä ei ole rajattu. Sovellus ei vaadi tunnistautumista.
Kuka tahansa voi käyttää laskinta ohjelman käynnistämisen jälkeen.

## Käyttöliittymä

Sovellus koostuu yhdestä näkymästä, joka koostuu napeista ja labeleista. 
Ohjelman käynnistäminen avaa näkymän ja nappeja voi painaa.

## Suunnitellut toiminnallisuudet

### Perusversion tarjoama toiminnallisuus

- Käyttäjä voi painaa nappeja
	- numeronappi kirjoittaa :heavy_check_mark:
	- operaattorinappi antaa sovellukselle halutun laskutoiminnon :heavy_check_mark:
	- =-nappi suorittaa laskun ja näyttää käyttäjälle tuloksen :heavy_check_mark:
- Käyttäjä voi laskea kaikki tavalliset laskut
	- yhteen- ja vähennyslaskut :heavy_check_mark:
	- kerto- ja jakolaskut :heavy_check_mark:
- Käyttäjä voi pyyhkiä kirjoittamansa tekstin pois :heavy_check_mark:
- Sovellus tallentaa suoritetut laskutoimitukset muistiinsa :heavy_check_mark:

### Jatkokehitysideoita

Perusversion jälkeen sovelluksen toiminnallisuutta voidaan täydennetään.

- Erityisesti voidaan lisätä nappeja, jotka käsittelevät yhden luvun tavallisemmat laskutoimitukset, kuten
	- potenssilaskuja
	- juurilaskuja

- Lisäksi voidaan lisätä monimutkaisempia operaatioita
	- sini, kosini, tangetti
	- logaritmi

- Lisäksi voidaan kehittää uudenlaisia näkymiä, kuten
	- kehittynyt näkymä
	- finanssinäkymä

Jakolasku toimii tällä hetkellä puutteellisesti ja laskee kokonaisluvuilla.
Jakolaskun suorittavan luokan koodia parannetaan niin, että se pystyy käsittelemään myös jakojäännöksen.

Laskuoperaation suorittavien luokkien vastuulle voidaan siirtää käyttäjän kanssa kommunikointi, jolloin luokalle
ei tarvitse antaa parametreja suorittaakseen laskun. Nyt voidaan siirtää kontrollerilta vastuuta enemmän sovelluslogiikan
puolelle, kun sovelluslogiikka osaa käsitellä operaation ilman lukuja. Näin sovelluksen toiminnan laajentaminen 
yksinkertaistuu entisestään.

## Toimintaympäristö

Sovelluksen tulee toimia Linux-käyttöjärjestelmällä varustetuilla koneilla.


