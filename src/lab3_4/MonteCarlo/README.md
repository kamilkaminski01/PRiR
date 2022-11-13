# Zadanie 2

Napisz program w Javie, w którym w aplikacji wielowątkowej obliczysz pole okręgu na podstawie algorytmu Monte Carlo.

## Struktura

- Klasa [`Main`](Main.java) jest główną klasą wyjściową.
- Klasa [`MonteCarlo`](MonteCarlo.java) jest klasą wykonującą obliczenia pola okręgu.  

## Uruchamianie

Po uruchomieniu klasy [`Main`](Main.java) należy podać promień koła oraz liczbę prób.

Wątki wykonują obliczenia, a w konsoli wyświetlają się informacje: 
- `In`, czyli ile punktów znalazło się w okręgu,
- `All`, czyli ile punktów zostało wygenerowanych ogólnie,
- `PI`, czyli uśredniona liczba pi z czterech wątków,
- `Pole kola`, czyli uśrednione pole powierzchni koła z czterech wątków.

