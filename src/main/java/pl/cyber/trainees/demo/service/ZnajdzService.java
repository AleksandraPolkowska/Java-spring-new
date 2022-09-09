package pl.cyber.trainees.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;
@Slf4j
@Service
public class ZnajdzService {
    private Integer losowaLiczba = 0;
    private Integer zgadnietaLiczba = 0;

    public ZnajdzService() {

        Random r = new Random();
        this.losowaLiczba = r.nextInt(10, 1000); // ?
        log.info("Wylosowana liczba to: " + this.losowaLiczba.toString());
    }

    public String znajdzLiczbe(final Integer liczba) {
        if (Objects.equals(liczba, losowaLiczba)) {
            return "Udało się!";
        } else if (liczba < losowaLiczba) {
            return "Liczba jest wieksza";
        } else {
            return "Liczba jest mniejsza";
        }
    }

}





   /* public boolean porownanieLiczb(final Integer losowaLiczba, final Integer zgadnietaLiczba{
        if (losowaLiczba.equals(zgadnietaLiczba)) {
            {
                return true;
            }
        else if (losowaLiczba > zgadnietaLiczba){
            return "Liczba jest za mała"
            }
        else if (losowaLiczba < zgadnietaLiczba){
                return "Liczba jest za duża"
            }








    return true;
    }
}
 */