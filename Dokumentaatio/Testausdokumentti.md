# Testausdokumentti

## Yksikkötestaus

Ohjelma on yksikkötestattu kattavasti hyvin moninaisilla testiskenaarioilla. Ohjelmaa on sen luonteesta johtuen helppoa testata, ja testikattavuus onkin korkea.


## Tehokkuustestaus

Alla on taulukoituna sekä oman, että Javan valmiin toteutuksen suoritusaikoja eri mittaisille syötteille lausekkeilla 1: (a|b|c|)\* ja 2: (a|b|c|d|e|f|g|h|i|j|k|l|m|n)\*


|Syötteen pituus |Aika omalla - 1 |aika omalla - 2 |Aika Javalla - 1 |Aika Javalla - 2 |
|:---------------|:---------------|:---------------|:----------------|:----------------|
|5               |0.0045          |0.0005          |0.0001           |0.00007 |
|10              |0.0037          |0.0047          |0.0003           |0.0002 |
|15              |0.030           |0.0097          |0.0002           |0.00005 |
|20              |0.38            |0.020           |0.00007          |0.00006 |
|25              |10.8            |0.053           |0.00005          |0.00003 |


Kuten nähdään, jostain syystä lyhyemmällä lausekkeella 1 aika pitenee todella nopeasti, kun taas pidemmällä lausekkeella aika kasvaa maltillisemmin. Huomattavaa on myös, ettei Javan toteutus käytä syötteen kasvaessa havaittavasti enempää aikaa, kun oma totteutukseni taas kasvattaa ajankulutustaan merkittävästi.
