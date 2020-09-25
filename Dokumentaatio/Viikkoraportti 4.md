Tällä viikolla oli tarkoituksena saattaa valmiiksi ohjelman varsinainen toiminnallisuus. Kävi kuitenkin ilmi, että ohjelmaan tarvittiin aika suuria muutoksia jotta sen saa lukemaan sulkuja. Yrityksiä siitä, miten tämä voisi onnistua kertyi aika monia ja tässä kului aikaa niin, että nyt ohjelman rakenne on uusittu lähes kokonaan mutta toiminnallisuuksia ei vielä ole aiempaa enempää. Teoriassa nyt pitäisi kuitenkin olla mahdollista myös loppujen toimintojen (sulut, tai) toteutus.

Nyt kun kertailen mielessäni Hannun suuntaviivoja rekursiiviseen toteutukseen, niin huomaan, että olen ottanut hieman erilaisen lähestymistavan. Tai-operaatio pitää toteuttaa siten, että jokaisella vaihtoehdolla kokeillaan korvata tai-osio ja katsotaan, että täsmääkö se syötteeseen. Toistoa en ole toteuttanut siten, että lausekkeessa toistomerkintä korvattaisiin kasvavalla määrällä toistettavaa merkkiä tai merkkijoukkoa ja sitten aina kokeiltaisiin, että joko toistoa tuli sopiva määrä. Tätä kirjoittaessani rupesin pohtimaan, olisiko Hannun kuvailema tapa kuitenkin parempi, ja voi olla että vaihdan vielä käyttämään tätä tyyliä. Se on loppujen lopuksi paljon yksinkertaisempi.

Ohjelmani ei käytä monimutkaisia tietorakenteita, mutta merkkijonoa varten olen nyt luonut oman rakenteen, lähinnä jotta voin täysin itse määrittää sen toiminnan ja tarpeelliset metodit. Myös tämä luokka on testattu perin pohjin ja testikattavuus näyttää seuraavalta:



Testikattavuus on siis hyvällä tasolla.

Toteutus- ja testausdokumenttien tiedostot on luotu, mutta itse dokumentteja ei ole vielä oikeasti aloitettu.

Tällä viikolla aikaa kului 15 tuntia.
