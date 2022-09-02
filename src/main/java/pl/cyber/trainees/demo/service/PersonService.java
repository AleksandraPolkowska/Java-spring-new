package pl.cyber.trainees.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cyber.trainees.demo.dto.Person;
import pl.cyber.trainees.demo.dto.PersonRequest;

import java.util.ArrayList;
import java.util.List;

@Service // dzieki temu spring wie ze moze uzywac te klase do defaultowego konstruktora "powolac go do zycia"
// bez tego musielibysmy tworzyc konstruktor tej klasy i potem odpowiednio go skonstruowac, spring robi to za nas
@RequiredArgsConstructor
public class PersonService {

    private List<Person> personList = new ArrayList<>();
    public void createPerson(final PersonRequest request){
        walidujOsobe(request);

        personList.add(Person.builder()
                .imie(request.getImie())
                .nazwisko(request.getNazwisko())
                .miasto(request.getMiasto())
                .dataUrodzenia(request.getDataUrodzenia())
                .plec(request.getPlec())
                .build());
    }
    private void walidujOsobe(final PersonRequest request) {
        boolean czyIstnieje = false;
        for (Person element : personList) {
            if(element.getImie().equals(request.getImie())
                    && element.getNazwisko().equals(request.getNazwisko())
                    && element.getDataUrodzenia().equals(request.getDataUrodzenia())
            ) {
                czyIstnieje = true;
            }
        }

        if(czyIstnieje) {
            throw new RuntimeException("Taka osoba już istnieje");
        }
    }

}
