package pl.cyber.trainees.demo.dto;

import lombok.Builder;
import lombok.Getter;

import java.beans.ConstructorProperties;

@Getter // dzieki niej nie musimy pisac metod typu getter dla parametrów klasy, to zalatwia to za nas
public class ImieDTO {
    private final String imie;

@Builder // pomaga utworzyc obiekt bez wywpelniania konstruktora
@ConstructorProperties({"imie"}) // pomaga w budowaniu struktury pliku wynikowego JSON
    public ImieDTO(final String imie) {
        this.imie = imie;
    }
}
