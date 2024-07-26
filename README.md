# CodersLab_ZadaniaZaliczeniowe
Zadania zaliczeniowe z Java Selenium WebDriver + Cucumber

ZADANIE 1

Utwórz użytkownika manualnie na stronie https://mystore-testlab.coderslab.pl.

Możesz wykorzystać tymczasowego maila do utworzenia użytkownika: https://10minutemail.com/.


Napisz skrypt, który:

- będzie logować się na tego stworzonego użytkownika,
- wejdzie klikając w kafelek Addresses po zalogowaniu (adres, na którym powinniśmy się znaleźć to: https://mystore-testlab.coderslab.pl/index.php?controller=addresses ),
- kliknie w + Create new address,
- wypełni formularz New address - dane powinny być pobierane z tabeli Examples w Gherkinie (alias, address, city, zip/postal code, country, phone),
- sprawdzi czy dane w dodanym adresie są poprawne.

DLA CHĘTNYCH:

Dodatkowe kroki dla chętnych:

- usunie powyższy adres klikając w "delete",
- sprawdzi czy adres został usunięty.

---

ZADANIE 2

Napisz skrypt, który:

- zaloguje się na tego samego użytkownika z zadania 1,
- wybierze do zakupu Hummingbird Printed Sweater (opcja dodatkowa: sprawdzi czy rabat na niego wynosi 20%),
- wybierze rozmiar M (opcja dodatkowa: zrób tak żeby można było sparametryzować rozmiar i wybrać S,M,L,XL),
- wybierze 5 sztuk według parametru podanego w teście (opcja dodatkowa: zrób tak żeby można było sparametryzować liczbę sztuk),
- dodaj produkt do koszyka,
- przejdzie do opcji - checkout,
- potwierdzi address (możesz go dodać wcześniej ręcznie),
- wybierze metodę odbioru - PrestaShop "pick up in store",
- wybierze opcję płatności - Pay by Check,
- kliknie na "order with an obligation to pay",
- zrobi screenshot z potwierdzeniem zamówienia i kwotą.

DLA CHĘTNYCH:

Dodatkowe kroki dla chętnych:

- Wejdź w historię zamówień i detale (najpierw kliknij w użytkownika zalogowanego, później kafelek),
- sprawdź czy zamówienie znajduje się na liście ze statusem "Awaiting check payment" i kwotą taką samą jak na zamówieniu dwa kroki wcześniej.