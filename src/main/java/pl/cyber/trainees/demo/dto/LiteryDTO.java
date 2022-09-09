package pl.cyber.trainees.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder // do zbudowania obiektu w oparciu o konstruktor klasy
@AllArgsConstructor // dzieki temu w naszej klasie pojawi sie konstruktor ze wszystkimi dostenymi parametrami
public class LiteryDTO {

    private String litera;
    private Integer ilosc;
}
