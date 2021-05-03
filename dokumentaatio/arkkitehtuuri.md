# Arkkitehtuurikuvaus

## Rakenne

Pakkaus calculator.ui sisältää JavaFX:llä toteutetun käyttöliittymän, ja pakkaus calculator.domain sisältää sovelluslogiikan.

![Pakkausrakenne](https://github.com/jarvsini/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/pakkausjaluokka.jpg)

*CalculatorController* käsittelee sovelluksen syötteen ja muodostaa uuden tuloksen käyttöliittymää varten luokan *Model* avulla. *Model* on laskimen varsinainen malli eli se sisältää kaikki laskimen laskuoperaatiot *Operatorit*. Laskin suorittaa tällä hetkellä binäärioperaatioita. Varsinaiset laskutoimitukset tapahtuvat omissa luokissaan, jotka perivät luokan *Operator*. CalculatorControllerilla on vain yksi Model ja Modelilla useampi Operator.


## Sovelluslogiikka

![kuva](https://github.com/jarvsini/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/sekvenssi.jpg)
