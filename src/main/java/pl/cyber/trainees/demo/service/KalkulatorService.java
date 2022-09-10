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
        }else{
            if (delta == 0 ){
                x1 = Double.valueOf(-b/(2*a));
                return "Jeden pierwiastek. Wynik: " + x1;
            }else{
                x1 = (-b-Math.sqrt(delta))/(2*a);
                x2 = (-b+Math.sqrt(delta))/(2*a);
                return "Dwa pierwiastki. Wynik x1: " +x1+ " x2: " +x2;
            }
        }
    }
}
