package pl.cyber.trainees.demo.service;

import org.springframework.stereotype.Service;

@Service
public class KalkulatorService {
    // metoda dodawania
    // metoda odejmowania itd.

    public Integer getDodawanie(final Integer a, final Integer b) {
        return a + b;
    }

    public Integer getOdejmowanie(final Integer a, final Integer b) {
        return a - b;
    }

    public Integer getMnozenie(final Integer a, final Integer b) {
        return a * b;
    }

    public Integer getDzielenie(final Integer a, final Integer b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new RuntimeException("Nie dziel przez 0!");
        }
    }

    public Integer getResztaZDzielenia(final Integer a, final Integer b) {
        return a % b;
    }

    public Boolean getLiczbaPierwsza(int liczba) {
        if (liczba < 2) {
            return false;
        }
        for (int i = 2; i < liczba / 2; i++) {
            if (liczba % i == 0) {
                return false;
            }
        }
        return true;
    }

    public Boolean getDzielnik(final Integer liczbaA, final Integer liczbaB) {
        if (liczbaA % liczbaB == 0) {
            return true;
        }
        return false;
    }

    //Zadanie 9
    public String rownanieKwadratowe(final Integer a, final Integer b, final Integer c) {
        Double delta = 0.0;
        Double x1 = 0.0;
        Double x2 = 0.0;

        if (a == 0) {
            return "To nie jest równanie kwadratowe";
        }
        delta = Double.valueOf(b * b - 4 * a * c);

        if (delta < 0) {
            return "Brak pierwiastków";
        } else {
            if (delta == 0) {
                x1 = Double.valueOf(-b / (2 * a));
                return "Jeden pierwiastek. Wynik: " + x1;
            } else {
                x1 = (-b - Math.sqrt(delta)) / (2 * a);
                x2 = (-b + Math.sqrt(delta)) / (2 * a);
                return "Dwa pierwiastki. Wynik x1: " + x1 + " x2: " + x2;
            }
        }
    }

    public String zadanie10a() {
        Integer y = 0;
        StringBuilder result = new StringBuilder("\"Program oblicza wartosc funkcji y=3x dla x zmieniajacego sie od 0 do 10.\n");

        for (int x = 0; x <= 10; x++) {
            y = 3 * x;
            result.append("x = ").append(x).append("\t").append("y = ").append(y).append("\n");
        }
        return result.toString();
    }

    public String zadanie10b() {
        Integer y = 0;
        Integer x = 0;

        String result = "Program oblicza wartość funkcji y = 3x, dla x zmieniajacego sie od 0 do 10." +
                "za pomocą petli do while\n";
        do {
            y = 3 * x;
            result += "x = " + x + "\t " + "y = " + y + "\n";
            x++;
        } while (x <= 10);
        return result;
    }

    public String zadanie10c() {
        Integer y = 0;
        Integer x = 0;
        String result = "Program oblicza wartość funkcji y = 3x, dla x zmieniajacego sie od 0 do 10.\n" +
                "za pomocą petli do while\n";
        while (x <= 10) {
            y = 3 * x;
            result += "x = " + x + "\t " + "y = " + y + "\n";
            x++;
        }
        return result;
    }

    public String zadanie11a() {
       /* Integer y = 1;
        Integer x = 1;
        String result = y + " * " + x + " = " + y * x;

        for (y = 1; y <= 10; y++) {
            for (x = 1; x <= 10; x++) {
                return result;
            }
        }
    return result;
    }

        */
        Integer n = 10;
        String result = "program wyswietlajacy tabliczke mnozenia " +
                "dla liczb od 1 do 100.\n\n";


        for(int wiersz = 1; wiersz <=n; wiersz++){
            for( int kolumna = 1; kolumna<=n; kolumna++){
                result += wiersz*kolumna;
                result += "\t";
            }
            result += "\n";
        }
 return result;
    }
}

