## Ohjelmistotekniikka, harjoitustyö
# Calculator

Sovellus on laskin, jolla käyttäjä pystyy suorittamaan kaikki tavallisemmat laskut.

## Dokumentaatio

[Työaikakirjanpito](https://github.com/jarvsini/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Vaativuusmäärittely](https://github.com/jarvsini/ot-harjoitustyo/blob/master/dokumentaatio/vaativuusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/jarvsini/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Käyttöohje](https://github.com/jarvsini/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

## Releaset

[Viikko 5](https://github.com/jarvsini/ot-harjoitustyo/releases/tag/viikko5)

[Viikko 6](https://github.com/jarvsini/ot-harjoitustyo/releases/tag/viikko6)

## Komentorivitoiminnot

Ohjelma käynnistyy komennolla

```javascript
mvn compile exec:java -Dexec.mainClass=calculator.Main
```

### Testaus

Testit suoritetaan komennolla

```javascript
mvn test
```

Testikattavuus luodaan komennolla

```javascript
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto *target/site/jacoco/index.html*

### Suoritettavan jarin generointi

Komento

```javascript
mvn package
```

generoi hakemistoon target suoritettavan *jar-tiedoston Calculator-1.0-SNAPSHOT.jar* .
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
