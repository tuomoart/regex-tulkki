# Käyttöohje

Ohjelma on helpointa suorittaa jar-paketista, joka on ladattavissa [githubissa.] TODO Linkki

Ohjelmassa on yksinkertainen komentorivikäyttöliittymä. Käynnistyksen jälkeen ohjelma kysyy testattavaa syötettä. Jos syötteeksi antaa "." -merkin, ohjelma sammuu. Jos syöte on "testaa", niin ohjelma suorittaa tehokkuusvertailun. Tehokkuusvertailu ei välttämättä toimi jar-pakettia ajaessa, ainakaan ilman, että testisyötteet on luotu.

Syötteen saatuaan ohjelma kysyy lausekkeen, jota vastaa syötettä testataan. Tämän jälkeen ohjelma antaa vastauksen ja aloittaa alusta.


## Ominaisuudet ja rajoitteet

Ohjelma osaa kaikki tavalliset kirjaimet sekä isoina, että pieninä. Erikoismerkkejä se saattaa tuntea vaihtelevasti, mutta ainakaan \*, |, ( ja ) -merkkejä ei voi käyttää muutoin, kuin lausekkeessa niiden erikoismerkityksissään:

  - \*: toisto
  - |: tai
  - ( ja ): sulkeet

Muita merkintöjä, kuten lyhennysmerkintöjä, ohjelma ei tunne.
