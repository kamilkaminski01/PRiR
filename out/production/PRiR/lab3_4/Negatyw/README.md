# Zadanie 3

Napisz program w Javie, w którym w aplikacji wielowątkowej przekształcisz obraz barwny do jego negatywu.

## Struktura

- Klasa [`Main`](Main.java) jest główną klasą wyjściową
- Klasa [`Negatyw`](Negatyw.java) jest klasą generującą obrazek PNG z negatywym obrazku wejściowego `./samples/flower.png`
- Folder `./samples` znajdujący się w źródłowej ścieżce zawierający obrazki wejściowe
- Folder `./outputs` znajdujący się w źródłowej ścieżce do której generowana jest grafika. 

## Uruchamianie

Po uruchomieniu klasy [`Main`](Main.java) w konsoli otrzymujemy informację w jakim czasie negatyw został wygenerowany, a grafika zostaje zapisana w folderze `./outputs` o nazwie `flower_new.png`

### Troubleshooting

Jeśli występuje błąd `(No such file or directory)`, należy w ścieżce źródłowej utworzyć folder o nazwie `outputs` lub utworzyć folder o nazwie `samples` z plikiem `flower.png`
