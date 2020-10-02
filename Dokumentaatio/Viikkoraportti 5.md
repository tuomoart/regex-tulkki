Tällä viikolla on saatu aikaan jonkinlainen räpöstys suluista ja tai-operaatiosta. Ohjelma on nyt toiminnoiltaan siinä vaiheessa, että sillä on mahdollista suorittaa tehokkuustestausta, mutta käytännössä ohjelman rakennetta pitää vielä parantaa ennen lopullista palautusta merkittävästi. Edessä on todennäköisesti lähes kokonaan uudelleenkirjoitus, sillä tällä hetkellä koodi on todella sekavaa eikä ohleman toiminta rakennu mitenkään järkevästi. Tulkki on aika hankala toteuttaa järkevästi, sillä pelkkä rekursiivinen kokeilu on huonoissa tapauksissa hidasta, mutta tehokkaampien toimintatapojen hahmottelu on sen sijaan huomattavasti hankalampaa. Pikkuhiljaa ymmärrys asiasta kuitenkin karttuu.

Toiminnalliset puutteet:
 - Sisäkkäisiä sulkuja ei osatata lukea
 - Sulkujen sisäisten asioiden kanssa on monia pikkuongelmia. Käytännössä sulkulausekkeiden sisältö on aika rajattua tällä hetkellä.
 - Varmasti on paljon myös sellaisia vikoja joihin en ole vielä törmännyt.

Ohjelma ei siis missään nimessä ole oikeasti toimiva regex-tulkkina, edes rajoitetuin toiminnoin. Se on kuitenkin niin pitkällä, että sille voi suorittaa tehokkuustestausta, kunhan muistaa pystylle ohjelman toimivuuden rajoissa. Toiveena on saada ohjelma toimivaksi lopulliseen palautukseen, vaikkakin toki siinä tapauksessa pitää tehokkuustestaus tehdä uudestaan uudelle ohjelmalle. En kuitenkaan halua jättää sitä nyt tässä vaiheessa kokonaan tekemättä, jos käykin niin, ettei ohjelman parantaminen onnistu.

Aikaa kului 14 tuntia
