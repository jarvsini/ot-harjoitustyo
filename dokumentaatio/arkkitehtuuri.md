# Arkkitehtuurikuvaus

## Rakenne

Ohjelman pakkausrakenne noudattaa kolmitasoista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraava:

![Pakkausrakenne](https://github.com/jarvsini/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/pakkauskaavio.png)

Pakkaus calculator.gui sisältää JavaFX:llä toteutetun käyttöliittymän, pakkaus calculator.domain sisältää sovelluslogiikan
 ja pakkaus calculator.data sisältää datan tallennuksesta vastaavan koodin.

## Käyttöliittymä

Käyttöliittymä on rakennettu luokassa BasicView. Luokka sisältää laskimen numero- ja operaationäppäimet Buttonit sekä kaksi 
Labelia: tuloksen Result ja sen hetkisen kirjoituksen tilan Outputin. BasicViewissa rakennettujen komponenttien muutoksista 
ja tapahtumien käsittelystä vastaa luokka BasicViewController. BasicViewControllerilla on aina yksi BasicView. Luokka 
reagoi käyttäjän tekemiin napinpainalluksiin ja kutsuu tarvittaessa sovelluslogiikan sisältävää luokkaa parametrein sekä 
pyytää BasicViewiä päivittämään itsensä. 

Itse sovellus eli CalculatorFX vain luo tarvittavat oliot start-metodissaan. Se asettaa näkymän näkyväksi. Sovellusta 
voidaan jatkossa kehittää luomalla perusnäkymän lisäksi uusia näkymiä ja niiden kontrollereita. Kun näkymä luodaan 
omassa luokassaan niin tällainen jatkokehitys on sujuvaa.

![Käyttöliittymä](https://github.com/jarvsini/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/gui.png)

## Sovelluslogiikka

Koodin suunnittelussa on hyödynnetty MVC- eli  Model View Controller -mallia, jonka avulla sovelluslogiikka on eristetty 
käyttöliittymästä. Sovelluslogiikasta vastaava luokka Model ei tunne käyttöliittymää lainkaan. Kontrolleri eli 
gui-pakkauksen BasicViewController tuntee sekä näkymän BasicView että sovelluslogiikasta vastaavan luokan Model.

Model ei tiedä, mikä luokka sitä kutsuu. Se saa käyttöliittymästä vain parametrina kaksi lukua ja operaation, ja käsittelee 
ne metodissaan calculateTwoNumbers() sekä lopulta palauttaa tuloksen. Model tuntee kaikki laskimen laskuoperaatiot 
Operatorit. Model sisältää listan tunnetuista laskuoperaatioista. Laskentametodi etsii listalta halutun operaation ja kutsuu 
edelleen tätä toista, laskun suorittavaa, luokkaa.

Operator on abstrakti luokka, joka sisältää ainoastaan metodin run(). Laskutoimituksista vastaavat luokat perivät 
Operator-luokan ja toteuttavat run-metodin omalla tavallaan. Modelilla on useita Operatoreita.

Ohjelma soveltaa tässä strategia-suunnittelumallia toteuttamalla erilliset laskuoperaatiot omina olioinaan. Näin
jatkossa voidaan lisätä uusia operaatioita sujuvasti.

Seuraava kaavio kuvaa luokkien suhteita toisiinsa. Luokkakaaviokuvassa sovelluslogiikasta vastaavat luokat on sijoitettu 
keskelle. Ylhäällä on käyttöliittymästä vastaavat luokat ja alin luokka on data-pakkaukseen sisältyvä tiedon tallennuksesta 
vastaava luokka.

![Luokkakaavio](https://github.com/jarvsini/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/luokkakaavio.png)

## Tietojen tallennus

Pakkauksen calculator.data luokka History vastaa laskimella laskettujen laskutoimitusten tallennuksesta. Luokka
toimii laskimen muistina. Model tuntee Historyn, ja kun Model on suorittanut laskennan, se kutsuu luokan History metodia 
writeHistory() ja antaa parametrina laskulausekkeen tuloksineen. Metodi writeHistory() tallentaa lausekkeen tekstitiedostoon 
"history.txt". Laskutoimitukset on eroteltu toisistaan puolipisteellä. Historylla on myös metodi readHistory(), joka lukee 
tekstitiedoston ja tulostaa sen.

Käyttäjä voi tulostaa aiemmin suorittamansa laskut ja niiden tulokset klikkaamalla M-nappia. Klikkaus herättää 
BasicViewControllerin, joka kutsuu Modelia, joka edelleen kutsuu Historya, joka lopulta tulostaa tiedoston.

Tällä hetkellä laskentahistoria tulostuu graafisen käyttöliittymän ulkopuolelle, esimerkiksi ohjelmaa terminaalista 
käytettäessä terminaaliin. Jatkoa ajatellen historiaa voisi hyödyntää muutoinkin. Edellisiä laskutoimituksia voitaisiin 
esimerkiksi tulostaa laskimen Labeliin ja/tai aiemmin tehtyjä laskuja voitaisiin muokata tai jatkaa.

## Toiminnallisuudet

###### Laskeminen kahdella luvulla

Käyttäjä voi suorittaa yhteen- ja vähennys- sekä kerto- ja jakolaskuja. Käyttäjä antaa luvut ja halutun operaation 
klikkaamalla näppäimiä. Laskun suoritus etenee seuraavasti:

- Käyttäjä klikkaa numeronappeja (0-9), kunnes näytöllä on haluttu luku. Luku voi koostua useammasta numerosta. Jokaisen klikkauksen seurauksena kontrolleri pyytää näkymää päivittämään itsensä.
- Käyttäjä klikkaa halutun laskuoperaation (+,-,/,x). Kontrolleri tallentaa operaation, päivittää näkymän, ja estää operaationappejen uudelleen painamisen.
- Käyttäjä klikkaa jälleen numeronappeja, kunnes näytöllä on haluttu laskutoimitus.
- Käyttäjä klikkaa =-nappia. Kontrolleri pilkkoo lausekkeen luvuiksi ja kutsuu Modelia ja antaa tälle kaksi lukua ja operaation.
- Model kutsuu haluttua Operator-oliota, joka suorittaa laskun ja palauttaa tuloksen.
- Model kutsuu History-luokkkaa, joka tallentaa laskun tiedostoon muistiin
- Model palauttaa tuloksen Kontrollerille, joka kutsuu näkymää päivittämään itsensä
- Käyttäjä näkee tuloksen

###### Tuloksen jatkohyödyntäminen

Kun lasku on suoritettu käyttäjä voi käyttää tulosta seuraavassa laskussaan klikkaamalla seuraavaksi operaatiota. 
Kokonaan uuden laskun käyttäjä voi aina aloittaa syöttämällä numeroita.

###### Laskimen nollaus

Klikkaamalla C-nappia käyttäjä voi nollata laskimen. Kontrolleri päivittää tulokseksi "0" ja outputiksi " ".

###### Laskuhistorian tulostus

Klikkaamalla M-nappia käyttäjä näkee laskimen historian.


Kuvataan seuraavaksi perustoiminnallisuutta sekvenssikaaviolla. Kaavio kuvaa tapahtuman, jossa käyttäjä laskee laskun 5x4. Sovelluslogiikan puolelle siirrytään vasta, 
kun käyttäjältä on saatu kaksi lukua.

![Sekvenssikaavio](https://github.com/jarvsini/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/sekvenssikaavio.png)


