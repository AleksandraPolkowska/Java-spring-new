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

}
