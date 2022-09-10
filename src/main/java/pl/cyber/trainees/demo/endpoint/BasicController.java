package pl.cyber.trainees.demo.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.cyber.trainees.demo.dto.ImieDTO;
import pl.cyber.trainees.demo.dto.IntegerListRequest;
import pl.cyber.trainees.demo.dto.OneStringRequest;
import pl.cyber.trainees.demo.dto.StringRequest;
import pl.cyber.trainees.demo.service.BasicsService;
import pl.cyber.trainees.demo.service.KalkulatorService;
import pl.cyber.trainees.demo.service.ZnajdzService;

import java.util.List;

@RestController
@RequestMapping("/v1/basics")
@RequiredArgsConstructor

public class BasicController {

    private final KalkulatorService kalkulatorService;
    private final BasicsService basicService;
    private final ZnajdzService znajdzService;

    // zadanie 1
    // napisz zapytania dla prostego kalkulatora, który będzie obslugiwac 5 operacji.
    // kazda z nich powinna byc oddzielnym zapytaniem restowym
    // operacje: dodawanie odejmowanie mnozenie dzielenie oraz obliczenie reszty z dzielenia liczb
    // Zwrócenie wyniku naszych operacji
    // @PathVariable
    // Np "/dodawanie/{a}"

    @GetMapping("/dodawanie/{a}/{b}")
    public Integer getDodawanie(
            @PathVariable("a") final Integer liczbaA,
            @PathVariable("b") final Integer liczbaB) {

        return kalkulatorService.getDodawanie(liczbaA, liczbaB);
    }
        @GetMapping("/dodawanieParams")
                public Integer getDodawanieParams(
                        @RequestParam("a") final Integer liczbaA,
        @RequestParam("a") final Integer liczbaB){
            return kalkulatorService.getDodawanie(liczbaA, liczbaB);
        }


    @GetMapping("/odejmowanie/{a}/{b}")
    public Integer getOdejmowanie(
            @PathVariable("a") final Integer liczbaA,
            @PathVariable("b") final Integer liczbaB) {
        return kalkulatorService.getOdejmowanie(liczbaA, liczbaB);
    }

    @GetMapping("/mnozenie/{a}/{b}")
    public Integer getMnozenie(
            @PathVariable("a") final Integer liczbaA,
            @PathVariable("b") final Integer liczbaB) {
        return kalkulatorService.getMnozenie(liczbaA, liczbaB);
    }

    @GetMapping("/dzielenie/{a}/{b}")
    public Integer getDzielenie(
            @PathVariable("a") final Integer liczbaA,
            @PathVariable("b") final Integer liczbaB) {
        return kalkulatorService.getDzielenie(liczbaA, liczbaB);
    }

    @GetMapping("/resztaZDzielenia/{a}/{b}")
    public Integer getresztaZDzielenia(
            @PathVariable("a") final Integer liczbaA,
            @PathVariable("b") final Integer liczbaB) {
        return kalkulatorService.getResztaZDzielenia(liczbaA, liczbaB);
    }

    // napisz zadanie restowe
    // ktorego zadaniem bedzie wykonanie sprawdzenia czy przekazana liczba jest liczbą pierwszą
    // w instrukcji warunkowe trzeba sprawdzic czy liczba jest rowna wieksza od 2
    // Petla która bedzie sprawdzala poszczegolne dzielniki i jeżeli którykolwiek modulo zwróci 0 to nie jest to liczba
    // pierwsza

    @GetMapping("/liczbaPierwsza/{liczba}/")
    public Boolean getLiczbaPierwsza(
            @PathVariable("liczba") final int liczba) {
        return kalkulatorService.getLiczbaPierwsza(liczba);
    }

    // napisz zapytanie restowe, ktrore sklei stringi przekazane jako RequestBody a nastepnie zwroci wynik
    // to nie jest juz Get tylko post lub Put. hdy korzystamy z request body nie ma nawiasów bo to jest klasa dto

    @PostMapping("/sklejenie-stringow")
    public String getSklejenie(
            @RequestBody final StringRequest request
    ){
        return basicService.getSklejenie(request);
    }

    // Zadanie4
/*Napisz zapytanie restowe, którego zadaniem będzie przyjęcie napisu  jako zdania
(przekazanych jako RequestBody)
 Program powinien policzyć ilość wystąpień poszczególnych liter zdania i zwrócić
 odpowiednio przygotowane dane.
Uwaga należy pominąć litery, których w zdaniu nie ma oraz wszystkie znaki puste.

Przykład.
Ala ma kota

a - 4
k - 1
l - 1
m - 1
o - 1
t - 1
*/

  //  @POSTMapping
  //  @RequestBody
  //  List<LiteryDTO>wystapienia
    // Set<String> litery (set nie daje powtorzonych wartosci
    // List<String> wynik

    // petla for ktorej zadaniem bedzie po kazdym znaku zdania
    // jesli znak jest literą (if) to należy wykonać dodawanie lub aktualizację listy
    // wynik kolwjna petla for jadaca po liscie wystapienia i bedzie ustawiala nasz wynik zgodnie z tym co jest wyzej
    //Object String popsiada metodę matches(//regexp//) mowi nam o tym czy tym stringiem ktorym sie poslugujemy zawiera
    // sie to co podajemy w ramach regexpa .matches("[a-zA-Z]+")
    // sortowanie liter automatycznie Obiekt listy posiada metodę ktora nazywa sie sort w ktorej trzeba podac
    // tzw komparator (//Comparator//) .sort(String::compareTo)
    // czyli wyrazenie po ktorym bedziemy wykonywali sortowanie

    @PostMapping ("/zliczanie")
    public List<String> getWystapieniaLiterWZdaniu(
      @RequestBody final OneStringRequest request
    ){
        return basicService.getWystapieniaLiterWZdaniu(request);
    }

    //region Zadanie5
/*
Napisz zapytanie restowe, którego zadaniem będzie przekazanie liczb a i b (całkowite),
następnie wykona sprawdzenie czy liczba a jest dzielnikiem liczby b i zwróci
informację true lub false
*/

    @GetMapping("/dzielnik/{a}/{b}")
    public Boolean getdzielnik(
            @PathVariable("a") final Integer liczbaA,
            @PathVariable("b") final Integer liczbaB) {
        return kalkulatorService.getDzielnik(liczbaA, liczbaB);
    }

    //region Zadanie6
/*
Napisz program, który wygeneruje liczbę Random z przedziału od 10 - 1000.
Naszym zadaniem będzie odnalezienie wygenerowanej liczby.
W tym celu należy utworzyć zapytanie restowe, które będzie przyjmowało liczbę
i porównywało ją z wygenerowaną przez system.
Jeśli wprowadzona liczba będzie tą wygenerowaną zostanie zwrócony napis "Udało się!!"
Jeśli wprowadzona liczba będzie mniejsza od wygenerowanej zostanie zwrócony napis
"Wygenerowana liczba jest większa"
Jeśli wprowadzona liczba będzie większa od wygenerowanej zostanie zwrócony napis
"Wygenerowana liczba jest mniejsza"

Uwaga aby generowana liczba powinna być parametrem klasy aby przy każdym zapytaniu
restowym nie doszło do jej modyfikacji.
*/

    @GetMapping("/znajdz/{a}")
    public String znajdzLiczbe(
            @PathVariable("a") final int liczba
    ) {
        return znajdzService.znajdzLiczbe(liczba);
    }

    ////region Zadanie7
    //  /*
    //  Napisz program, w którym zostaną przekazane liczby a i b (całkowite) następnie
    //  zostaną zsumowane wszystkie liczby pomiędzy od a do b
    //  (jako przedział zamknięty dwustronnie).
    //  Przykład podajemy: 1 do 10 czego wynikiem będzie 55
    //  */
    //
    //  //besicsService
    //
    //  //endregion
    //
    //  //region Zadanie8
    //  /*Napisz program, w krótym przekażemy listę elementów liczb całkowitych program
    //  powinien zwrócić listę elementów z wartościami ujemnymi oraz sumę liczb,
    //  które są dodatnie.
    //  Np. [1, 2, 3, 4, 5, -3, -2, -1]
    //  wynik:
    //  [-3, -2, -1] oraz suma liczb dodatnich wynosi: 15
    //  */
    //
    //  //besicsService
    //  //endregion
    //
    //  //region zadanie9
    //    /*
    //    Napisz zapytanie restowe, którego zadaniem będzie obliczał pierwiastek
    //    równania kwadratowego ax2 + bx + c = 0.
    //    (Do wykożystania instrukcja if). Pamiętać należy że zmienne a, b i c to
    //    liczby rzeczywiste.
    //    Zadanie powinno zwrócić Napis:
    //    a) To nie jest równanie kwadratowe
    //    b) Brak pierwiastków
    //    c) J
    //eden pierwiastek. Wynik: xxxx
    //    d) Dwa pierwiastki. Wynik -> x1: xxxx, x2: xxxx
    //     */
    //delta = b*b-4*a*c;
    //    Jeśli delta == 0
    //    x1 = -b/(2*a);
    //    Jeśli delta > 0
    //    x1 = (-b-Math.sqrt(delta))/(2*a);
    //    x2 = (-b+Math.sqrt(delta))/(2*a);
    //    Jeśli delta < 0
    //    Brak pierwiastków
    //     */
    //
    //  //KalkulatorService
    //  /*
    //  można użyć jednej z 3 opcji:
    //  //GET PathVarialbe
    //  //GET RequestParam
    //  //POST RequsetBody    (z własnym obiektem DTO)
    //   */

    // zad 7

    @GetMapping("/suma-liczb")
    public String sumaLiczbPomiedzy(
            @RequestParam("a") final Integer a,
            @RequestParam("b") final Integer b
    ){
        return basicService.sumaLiczbPomiedzy(a, b);
    }

    // zad8

    @PostMapping("/liczby")
    public String zadanie8(
            @RequestBody final IntegerListRequest request
    ){
        return basicService.zadanie8(request);
    }

    // Zadanie 9
    @GetMapping("/rownanie-kwadratowe/{a}/{b}/{c}")
    public String rownanieKwadratowe(
            @PathVariable("a") final Integer a,
            @PathVariable("b") final Integer b,
            @PathVariable("c") final Integer c
    ){
        return kalkulatorService.rownanieKwadratowe(a, b, c);
    }
}