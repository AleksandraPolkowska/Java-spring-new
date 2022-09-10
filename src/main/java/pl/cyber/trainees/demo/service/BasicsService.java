package pl.cyber.trainees.demo.service;

import org.springframework.stereotype.Service;
import pl.cyber.trainees.demo.dto.IntegerListRequest;
import pl.cyber.trainees.demo.dto.LiteryDTO;
import pl.cyber.trainees.demo.dto.OneStringRequest;
import pl.cyber.trainees.demo.dto.StringRequest;

import java.util.*;

@Service

public class BasicsService {

    public String getSklejenie(final StringRequest request) {
        return request.getStringPierwszy() + request.getStringDrugi();
    }

    public List<String> getWystapieniaLiterWZdaniu(final OneStringRequest request) {
        List<LiteryDTO> wystapienia = new ArrayList<>();
        Set<String> litery = new HashSet<>();
        List<String> wynik = new ArrayList<>();

        String zdanie = request.getValue();

        for (int i = 0; i < zdanie.length(); i++) {
            String litera = String.valueOf(zdanie.charAt(i));
            if (litera.matches("[a-zA-Z]+")) {
                if (wystapienia.size() == 0) {
                    litery.add(litera.toLowerCase());
                    wystapienia.add(LiteryDTO.builder()
                            .litera(litera.toLowerCase())
                            .ilosc(1)
                            .build());
                } else {
                    if (litery.contains(litera.toLowerCase())) {
                        for (LiteryDTO element :
                                wystapienia) {
                            if (element.getLitera().equals(litera.toLowerCase())) {
                                element.setIlosc(element.getIlosc() + 1);
                            }
                        }
                    } else {
                        litery.add(litera.toLowerCase());
                        wystapienia.add(LiteryDTO.builder()
                                .litera(litera.toLowerCase())
                                .ilosc(1)
                                .build());
                    }
                }
            }
        }
        for (LiteryDTO element : wystapienia) {
            wynik.add(element.getLitera() + " - " + element.getIlosc());
        }
        wynik.sort(String::compareTo); // wynik - zmienna okreslajaca liste stringow jako wynik ktory zostanie zwrocony
        // do uzytkownika
        // metoda sort odpowiada za sortowanie zgodne z kluczem wskazanej listy w tym wypadku wynik
        // string::compareTo to nasz klucz sortowania po ktorym nasza lista zostanie posortowana
        //lista zostanie posortowana alfabetycznie w sposob taki ze zostanie porownany element n z elementem n+1
        //a nastepnie zostanie zamieniony zgodnie z nastapieniem w afabecie
        return wynik;
    }
     /*zadanie na mapy
    private List<String> getWystapieniaLiterWZdaniuMap(final OneStringRequest request){
        Map<String, Integer> wystapienia = new HashMap<>();
        List<String> wynik = new ArrayList<>();

        String zdanie = request.getValue().toLowerCase();

        for (int i = 0; i < zdanie.length(); i++){
            String litera = String.valueOf(zdanie.charAt(i));

            if litera.matches("[a-zA-Z]+") {
                    if(wystapienia.containsKey(litera)) {
                        wystapienia.put(litera, wystapienia.get(litera) + 1);
                    }else{
                        wystapienia.put(litera, 1);
                    }
            }
        }
        for (String element:wystapienia.keySet()){
            wynik.add(element + " - " + wystapienia.get(element));
        }
        return wynik;

        }

      */

    public String sumaLiczbPomiedzy(final Integer a, final Integer b) {
        Integer wynik = 0;

        if (a > b) {
            throw new RuntimeException("A powinno być mniejsze niż b");
        }

        for (int i = a; i <= b; i++) {
            wynik += i;

        }
        return "Wynik dodawania liczb pomiedzy a: " + a + " oraz b: " + b + " to: " + wynik;
    }

    public String zadanie8(final IntegerListRequest request) {
        List<Integer> listaUjemnych = new ArrayList<>();
        Integer sumaDodatnich = 0;

        for (Integer element :
                request.getIntList()) {
            if (element < 0) {
                listaUjemnych.add(element);
            } else {
                sumaDodatnich += element;
            }
        }
        return listaUjemnych + " oraz suma liczb dodatnich wynosi: " + sumaDodatnich;
    }
}

