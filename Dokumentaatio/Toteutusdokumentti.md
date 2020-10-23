# Toteutusdokumentti


Alla ohjelman luokka- ja pakkauskaavio. Kaavion ulkopuolelle on jätetty testaamiseen liittyvä pakkaus "testaus", sillä sitä käytetään ainoastaan tehokkuustestaamiseen.

![](https://raw.githubusercontent.com/tuomoart/regex-tulkki/master/Dokumentaatio/Misc/Luokka-%20ja%20pakkauskaavio.png)

Ohjelmassa on siis erittäin kevyt tekstikäyttöliittymä, joka käyttää luokkaa Translator tekstisyötteiden ja säännöllisten lausekkeiden vertaamiseen. Translator tarjoaa julkisen metodin "matches" joka saa syötteenä tekstisyötteen ja lausekkeen ja palauttaa tiedon siitä, kuuluuko tekstisyöte annetun säännöllisen lausekkeen kuvaamaan kieleen.

Luokka Translator käyttää kahta tietorakennetta, Lista ja Merkkijono. Näiden nimet kertonevat tarpeeksi niiden tarkoituksista. Lista on toteutukseltaan suppea, ja se sisältää vain välttämättömät toiminnot. Se pohjautuu taulukkoon, jonka koko kaksinkertaistetaan aina kun se tulee täyteen. Sen sijaan Merkkijono tarjoaa kaikenlaista, myös ylimääräisiä metodeja jäänteinä aiemmasta Translator-luokan toteutuksesta. Sen toteutus on huono, sillä siinä tietoja säilyttävä taulukko kopioidaan uudestaan aina, kun merkkijonoon lisätään yksi merkki. Tämä pitäisi ehdottomasti muuttaa vastaavaan toimintatapaan kuin Lista, eli että taulukon koko tuplataan aina tarvittaessa. Tätä on kerran jo yritetty, mutta yritys epäonnistui Merkkijono-luokan huonolaatuisen koodin takia.


## Aikavaativuus

Kuten [testausdokumentista](https://github.com/tuomoart/regex-tulkki/blob/master/Dokumentaatio/Testausdokumentti.md) käy ilmi
