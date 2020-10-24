# Testausdokumentti

## Yksikkötestaus

Ohjelma on yksikkötestattu kattavasti hyvin moninaisilla testiskenaarioilla. Ohjelmaa on sen luonteesta johtuen helppoa testata, ja testikattavuus onkin korkea, 100% rivikattavuus ja 98% haarautumakattavuus:

![](https://raw.githubusercontent.com/tuomoart/regex-tulkki/master/Dokumentaatio/Misc/Testikattavuus_final.png)

Tehokkuustestaamiseen sekä käyttöliittymään liittyvä koodi on jätetty yksikkötestauksen ulkopuolelle.


## Tehokkuustestaus

Alla on taulukoituna sekä oman, että Javan valmiin toteutuksen suoritusaikoja eri mittaisille syötteille lausekkeilla 1: (a|b|c)\* ja 2: (a|b|c|d|e|f|g|h|i|j|k|l|m|n)\*

Ajat sekunteina

|Syötteen pituus |Aika omalla - 1 |aika omalla - 2 |Aika Javalla - 1 |Aika Javalla - 2 |
|:---------------|:---------------|:---------------|:----------------|:----------------|
|10              |0.0002          |0.00006        |0.0001             |0.0001 |
|50              |0.0024          |0.016           |0.00006           |0.00004 |
|100             |0.01            |0.11            |0.00006           |0.00005 |
|250             |0.099           |1.77            |0.00005           |0.00004 |
|500            |0.74             |14.8           |0.00006            |0.00007 |

Kuten nähdään, omalla toteutuksella ajankäyttö kasvaa selkeästi syötteen pituuden kasvaessa, kun taas Javan valmis toteutus kuluttaa likipitäen saman verran aikaa syötteen pituudesta riippumatta. Mitä luultavimmin Javan toteutus siis toimii enemmänkin kuin regex-kääntäjä kuin regex-tulkki. Oma toteutukseni on rekursiivinen ja sen laskentapuun syvyys riippuu pitkälti syötteen pituudesta, joten onkin odotettavissa, että ajankulutus kasvaa havaitulla tavalla.

Kun verrataan oman toteutukseni suoritusta käytettyjen lausekkeiden kesken, voidaan nähdä myös lausekkeen merkitys ajankäyttöön. Koska ohjelma kohdatessaan vaihtoehtoja kokeilee niitä kaikkia, kuluu aikaa sitä enemmän, mitä enemmän vaihtoehtoja on.

[Toteutusdokumentissa](https://github.com/tuomoart/regex-tulkki/blob/master/Dokumentaatio/Toteutusdokumentti.md) on saatu oman toteutuksen pahimman tapauksen aikavaativuudeksi O(mn²), missä m on lausekkeen suurin vaihtoehtojen määrä ja n on syötteen pituus. Kuten nähdään, aikavaativuus ei ole erityisen suuri, muttei erityisen pienikään. Pidemmille syötteille ohjelma on käytännössä melko hidas. Tulkkaamisen ongelmana on, että vaikka eri syötteitä testattaisiin samaa lauseketta vastaan, ei saada mitään hyötyä siitä, että käytetään samaa lauseketta.

Sen sijaan kääntämällä voidaan lausekkeen ensimmäisen käsittelyn jälkeen tarkastaa syötteitä ajassa O(n). Lausekkeen käsittely voi kuitenkin olla hidasta. Ensin lausekkeesta muodostetaan NFA, sen jälkeen NFA:sta DFA jonka jälkeen syötteitä voidaan ajaa saadun automaatin läpi. NFA->DFA -muunnos voi kuitenkin muodostaa 2^n tilaa, missä n oletettavasti riippuu melko suoraviivaisesti lausekkeen pituudesta ja monimutkaisuudesta. En ole kuitenkaan perehtynyt kääntämis-ratkaisutapaan kovinkaan syvällisesti, joten käsitykseni voi myös olla väärä.

Siis jos on tarve tarkastaa lyhyitä syötteitä suurta lausekemäärää vasten, voi olla viisasta hyödyntää tulkkausta. Taas jos tarkastettavana on pitkä syöte tai useita syötteitä samalle lausekkeelle, on kääntäminen todennäköisesti nopeampaa. Kääntämisen pahin aikavaativuus on käytännössä erittäin harvinainen tapaus.


## Lähteet

Regex-kääntäjään liittyvä tieto on Jyrki Kivisen Laskennan mallit -kurssin luennoilta ja luentokalvoista.
