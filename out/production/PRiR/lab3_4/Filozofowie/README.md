# Zadanie 5

Napisz program w Javie, który połączy wszystkie programy dotyczące problemu myślących i jedzących
Filozofów z wykładu 3 w jednym kodzie. Program powinien w trakcie uruchamiania posiadać następujące 
opcje: (wybór jednego z 3 wariantów do uruchomienia, sterowanie liczbą filozofów w symulacji od 2 do 100).

## Struktura

- Klasa [`Main`](Main.java) jest główną klasą wyjściową.
- Klasy [`Filozofowie1`](Filozofowie1.java), [`Filozofowie2`](Filozofowie2.java), [`Filozofowie3`](Filozofowie3.java) są trzema kolejnymi rozwiązaniami problemu:
  - [`Filozofowie1`](Filozofowie1.java), ograniczenie do czterech filozofów trzymających widelce jednocześnie
  - [`Filozofowie2`](Filozofowie2.java), rzut monetą
  - [`Filozofowie3`](Filozofowie3.java), niesymetryczne sięganie po widelce


## Uruchamianie

Po uruchomieniu klasy [`Main`](Main.java) należy wybrać liczbę filozofów (od 2 do 100), a następnie numer metody (1, 2 lub 3), czyli uruchomienie jednej z trzech klas Filozofowie.

Po wyborze odpowiednich parametrów, w konsoli wyświetlają się komunikaty o działaniu programu.

## Zakończenie

Program trwa w nieskończoność, więc należy zakończyć przyciskiem "Stop `Main`" w swoim IDE.
