package pl.cyber.trainees.demo.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.beans.ConstructorProperties;
import java.time.LocalDate;

@Getter
public class PersonDTO {
    private final String imie;
    private final String nazwisko;
    private final LocalDate dataUrodzenia;
    private final String miasto;
    private final String plec;


    @Builder
    @ConstructorProperties({"imie", "nazwisko", "dataUrodzenia", "miasto", "plec"})

    public PersonDTO(final String imie, final String nazwisko, final LocalDate dataUrodzenia,
                     final String miasto, final String plec) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.miasto = miasto;
        this.plec = plec;
    }


}
