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

<br>

ENG: CodersLab_FinalTasks
--

**Assignment Tasks with Java Selenium WebDriver + Cucumber**

**TASK 1**

Manually create a user on the website [https://mystore-testlab.coderslab.pl](https://mystore-testlab.coderslab.pl).

You can use a temporary email to create the user: [https://10minutemail.com/](https://10minutemail.com/).

Write a script that:

- Logs in as the created user,
- Clicks on the "Addresses" tile after logging in (the address you should land on is: [https://mystore-testlab.coderslab.pl/index.php?controller=addresses](https://mystore-testlab.coderslab.pl/index.php?controller=addresses)),
- Clicks on "+ Create new address",
- Fills out the "New address" form - data should be retrieved from the Examples table in Gherkin (alias, address, city, zip/postal code, country, phone),
- Verifies if the data in the added address is correct.

**FOR THOSE INTERESTED:**

Additional steps for those interested:

- Deletes the above address by clicking on "delete",
- Checks if the address has been deleted.

---

**TASK 2**

Write a script that:

- Logs in as the same user from Task 1,
- Selects "Hummingbird Printed Sweater" for purchase (additional option: verifies if the discount on it is 20%),
- Selects size M (additional option: make it possible to parameterize the size and choose S, M, L, XL),
- Selects 5 pieces according to the parameter given in the test (additional option: make it possible to parameterize the number of pieces),
- Adds the product to the cart,
- Proceeds to checkout,
- Confirms the address (you can add it manually beforehand),
- Chooses the pickup method - PrestaShop "pick up in store",
- Chooses the payment option - "Pay by Check",
- Clicks on "order with an obligation to pay",
- Takes a screenshot of the order confirmation and amount.

**FOR THOSE INTERESTED:**

Additional steps for those interested:

- Go to order history and details (first click on the logged-in user, then the tile),
- Check if the order is listed with the status "Awaiting check payment" and with the same amount as in the order two steps earlier.
