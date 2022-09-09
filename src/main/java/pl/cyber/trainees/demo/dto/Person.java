package pl.cyber.trainees.demo.dto;

import lombok.*;


import java.beans.ConstructorProperties;
import java.time.LocalDate;

@Getter
@Builder
@RequiredArgsConstructor //buduje konstruktor klasy z parametrów oznaczonych modyfikatorem final
@AllArgsConstructor //buduje konstruktor klasy ze wszystkich dostępnych parametrów
public class Person {
    private final String imie;
    private final String nazwisko;
    private final LocalDate dataUrodzenia;
    @Setter
    private String miasto;
    private final String plec;

}
