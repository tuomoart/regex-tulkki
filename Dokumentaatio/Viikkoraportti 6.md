Toimintalogiikka on uusittu (taas), mutta nyt se toimii siten, etten ole ainakaan vielä löytänyt mitään mikä ei toimisi! Ohjelmaan on siis toteutettuna vain konkatenaatio, toisto ja tai, mutta itse logiikan ei tarvitse muuta osatakkaan. Lyhennysmerkinnät voitaisiin lisätä tuetuksi siten, että lausekkeeseen avataan nämä lyhennysmerkinnät ennen sen analysointia. Eli että palautetaan lauseke aina käyttämään vain kolmea perusoperaatiota.

Sulkujen ja suluttomien merkkien tarkastuksen erilaisuus aiheutti pitkään päänvaivaa. Ratkaisin ongelman niin, että ennen analysointia lisätään ihan jokaiseen mahdolliseen paikkaan sulut. Aina siihen asti, että jokainen yksittäinen merkki on omissa suluissaan. Näin analysoinnista tuli loppujen lopuksi melko yksinkertaista. Operaatioiden sisäkkäisyys ei enää pitäisi olla ongelma. Nyt siis ohjelman ydin on oletettavasti valmis, ainoastaan joitain bugikorjauksia voi joutua tekemään.

Komentorivikäyttöliittymä lisätty. Käyttöliittymäkoodi käyttää valmiita tietorakenteita (String), onko sallittua jättää tämä näin? Ohjelmalogiikassa on myös merkkijono-tietorakenne itse toteutettuna.

Lista-tietorakenne pitää vielä toteuttaa itse, mutta siinä ei pitäisi olla mitään monimutkaista. Merkkijono-tietorakennetta pitää hieman hioa, siellä tehdään nyt monta asiaa aika tyhmästi.

Ennen lopullista palautusta teen vielä dokumentaation loppuun. Testausta aion suorittaa ainakin siten, että vertailen omaa toteutustani Javan valmiiseen regex-tarkastajaan.

Aikaa kului tällä viikolla 10 tuntia.
