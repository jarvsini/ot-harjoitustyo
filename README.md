# Calculator

Sovellus on laskin, jolla käyttäjä pystyy suorittamaan kaikki tavallisemmat laskut.
Sovellus ei vaadi tunnistautumista ja kuka tahansa voi ohjelman käynnistyttyä käyttää laskinta.

Sovellus on suunniteltu ja toteutettu niin, että sitä on helppo laajentaa edelleen.

## Dokumentaatio

[Käyttöohje](https://github.com/jarvsini/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/jarvsini/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/jarvsini/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/jarvsini/ot-harjoitustyo/blob/master/dokumentaatio/testaus.md)

[Työaikakirjanpito](https://github.com/jarvsini/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)


## Releaset

[Viikko 5](https://github.com/jarvsini/ot-harjoitustyo/releases/tag/viikko5)

[Viikko 6](https://github.com/jarvsini/ot-harjoitustyo/releases/tag/viikko6)

[Viikko 7](https://github.com/jarvsini/ot-harjoitustyo/releases/tag/viikko7)

## Komentorivitoiminnot

### Ohjelman käynnistys

Ohjelma käynnistyy komennolla

```javascript
mvn compile exec:java -Dexec.mainClass=calculator.Main
```

### Testaus

Testit suoritetaan komennolla

```javascript
mvn test
```

Testikattavuusraportti luodaan komennolla

```javascript
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto *target/site/jacoco/index.html*

### Suoritettavan jarin generointi

Komento

```javascript
mvn package
```

generoi hakemistoon target suoritettavan jar-tiedoston *Calculator-1.0-SNAPSHOT.jar* .
Ohjelman voi nyt suorittaa komennolla

```javascript
java -jar target/Calculator-1.0-SNAPSHOT.jar
```

### JavaDoc

JavaDoc generoidaan komennolla

```javascript
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto *target/site/apidocs/index.html* 

### Checkstyle

Tiedostoon checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla

```javascript
mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto *target/site/checkstyle.html*

Huomaa, että komennot tulee suorittaa samassa hakemistossa kuin missä projekti sijaitsee.
Navigoi itsesi siis hakemistoon */Calculator*.
