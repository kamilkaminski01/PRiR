# Zadanie 4

Napisz program w Javie, w którym na podstawie kodu do generowania fraktala Mandelbrota z wykładu stworzysz kod równoległego generowania fraktala Julii.

## Struktura

- Klasa [`Main`](Main.java) jest główną klasą wyjściową.
- Klasa [`FraktalJulii`](FraktalJulii.java) jest klasą generującą obrazek PNG z Fraktalem Julii.
- Folder `./outputs` znajdujący się w źródłowej ścieżce do której generowana jest grafika. 

## Uruchamianie

Po uruchomieniu klasy [`Main`](Main.java) w konsoli otrzymujemy informację w jakim czasie Fraktal został wygenerowany, a grafika zostaje zapisana w folderze `./outputs` o nazwie `julia.png`

### Troubleshooting

Jeśli występuje błąd `(No such file or directory)`, należy w ścieżce źródłowej utworzyć katalog o nazwie `outputs`.
