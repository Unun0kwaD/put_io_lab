# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia [produkt](#bo2) na [aukcję](#bo1-aukcja). ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za [produkt](#bo2) wyższą od aktualnie najwyższej oferty. ([BR1](#br1) [UC3](#uc3))
3. [Kupujący](#ac2) wygrywa [aukcję](#bo1-aukcja) ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu. ([UC5](#uc4))
5. [Sprzedający](#ac1) przekazuje [produkt](#bo2) Kupującemu. ([UC2](#uc2))

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas [aukcji](#bo1-aukcja) upłynął i [Kupujący](#ac2) przegrał [aukcję](#bo1-aukcja). ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na [aukcji](#bo1-aukcja).

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić [produkt](#bo2) na [aukcji](#bo1-aukcja).


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie [produktu](#bo2) na [aukcję](#bo1-aukcja)
* [UC2](#uc2): Przekazanie [produktu](#bo2) [Kupującemu](#ac2)

[Kupujący](#ac2)
* [BR1](#br1), [UC3](#uc3): Złożenie oferty wyższej niż aktualnie najwyższa za  [produkt](#bo2).
* [BR2](#br2): Wygranie [aukcji](#bo1-aukcja)
* [UC4](#uc4): Przekazanie należności [Sprzedającemu](#ac1).

---
<a id="uc1"></a>
### UC1: Wystawienie [produktu](#bo2) na [aukcję](#bo1-aukcja)

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia  [produktu](#bo2) na [aukcję](#bo1-aukcja).
2. System prosi o podanie danych  [produktu](#bo2) i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane  [produktu](#bo2) oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu  [produktu](#bo2) na [aukcję](#bo1-aukcja).

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Przekazanie [produktu](#bo2) [Kupującemu](#ac2)

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. System werfikuje czy [Sprzedający](#ac1) otrzymał należności za  [produkt](#bo2).
2. System prosi [Kupującego](#ac2) o wskazanie adresu oraz formy dostawy.
3. System weryfikuje poprawność danych.
4. System przekazuje  [produkt](#bo2) na wskazany adres.

**Scenariusze alternatywne:** 

1.A. Sprzedający nie otrzymał nalezności
* 1.A.1. System informuje [Kupującego](#ac2) o nieprzekazaniu wpłaty za produkt i prosi o przekaznie należności ([BR3](#br3)).

3.A. Podano niepoprawne lub niekompletne dane adresowe.
* 3.A.1. System informuje o błędnie podanych danych.
* 3.A.2. Przejdź do kroku 2.
---

<a id="uc3"></a>
### UC3: Złożenie oferty wyższej niż aktualnie najwyższa.

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. System prosi [Kupującego](#ac2) o podanie kwoty wyższej niż aktualna.
3. System weryfikuje poprawność kwoty.
4. System ustawia podaną kwotę jako obecnie najwyższą ofertę.

**Scenariusze alternatywne:** 

2.A. Podana kwota jest nie więkza niz obecnie najwyższa oferta.
* 2.A.1. System informuje [Kupującego](#ac2) o za niskiej kwocie.
* 2.A.2. Wróć do kroku 1.

---
## Obiekty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

<a id="bo1"></a>
### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą [produktu](#bo2), natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy [produkt](#bo2) nabywa ten Kupujący, który zaproponował najwyższą kwotę. 


<a id="bo2"></a>
### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach [aukcji](#bo1-aukcja).

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujących](#ac2), który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | [Aukcja](#bo1-aukcja) | [Produkt](#bo2) | ... |
| ------------------------------------------------- | ------ | ------- | --- |
| UC1: Wystawienia produktu na [aukcję](#bo1-aukcja)               |    C   |    C    | ... |
| ???                                               |  ...   |  ...    | ... |


