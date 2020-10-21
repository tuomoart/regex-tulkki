# Testausdokumentti

## Yksikkötestaus

Ohjelma on yksikkötestattu kattavasti hyvin moninaisilla testiskenaarioilla. Ohjelmaa on sen luonteesta johtuen helppoa testata, ja testikattavuus onkin korkea.


## Tehokkuustestaus

Alla on taulukoituna sekä oman, että Javan valmiin toteutuksen suoritusaikoja eri mittaisille syötteille lausekkeilla 1: (a|b|c)\* ja 2: (a|b|c|d|e|f|g|h|i|j|k|l|m|n)\*

Ajat sekunteina

|Syötteen pituus |Aika omalla - 1 |aika omalla - 2 |Aika Javalla - 1 |Aika Javalla - 2 |
|:---------------|:---------------|:---------------|:----------------|:----------------|
|5               |0.0002          |0.0004         |0.0001           |0.0001 |
|10              |0.0003          |0.004          |0.00008          |0.00006 |
|20              |0.0017          |0.02           |0.00005          |0.00004 |
|40              |0.0066          |0.32           |0.00005          |0.00004 |
|100             |0.18            |10.3           |0.00005          |0.00004 |

Kuten nähdään, omalla toteutuksella ajankäyttö kasvaa selkeästi syötteen pituuden kasvaessa, kun taas Javan valmis toteutus kuluttaa likipitäen saman verran aikaa syötteen pituudesta riippumatta. Mitä luultavimmin Javan toteutus siis toimii enemmänkin kuin regex-kääntäjä kuin regex-tulkki. Oma toteutukseni on rekursiivinen ja sen laskentapuun syvyys riippuu pitkälti syötteen pituudesta, joten onkin odotettavissa, että ajankulutus kasvaa havaitulla tavalla.

Kun verrataan oman toteutukseni suoritusta käytetyille lausekkeille, voidaan nähdä myös lausekkeen merkitys ajankäyttöön. Koska ohjelma kohdatessaan vaihtoehtoja kokeilee niitä kaikkia, kuluu aikaa sitä enemmän, mitä enemmän vaihtoehtoja on.
