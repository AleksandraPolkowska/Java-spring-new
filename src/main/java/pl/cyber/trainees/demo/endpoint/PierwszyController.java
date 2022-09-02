package pl.cyber.trainees.demo.endpoint;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.cyber.trainees.demo.dto.ImieDTO;
import pl.cyber.trainees.demo.dto.PersonRequest;
import pl.cyber.trainees.demo.service.PersonService;

@Slf4j // odpowiada za logi w ramach servera
@RestController // adnotacja mówi serwerowi springa że w tym miejscu funkcjonalnosci REST API
@RequiredArgsConstructor
@RequestMapping("/v1/first")
public class PierwszyController {
    private final PersonService service;
    // HTTP metoda GET - metoda służy do pobierania informacji z serwera oraz wysłania ich do zewnetrznego systemu
   @GetMapping("/{imie}")
    public ImieDTO getImie(@PathVariable final String imie){
        return ImieDTO.builder()
                .imie(imie)
                .build();
    }

    // Zadanie 1. Utworzyć 2 obiekty
    // a) PErsonDTO, ktory bedzie przekazyway dla uzytkownika
    // b) Person jako obiekt wewnętrzny aplikacji
    // GET (@GEtmapping) PUT(@Putmapping) POST (@Postmapping)
    // Utworzyć metody REST do Tworzenia użytkownika, zmiany jego danych oraz jego pobierania.
    // Imie, nazwisko, date urodzenia, miasto zamieszkania oraz płeć,
    // Metoda do pobierania i aktualizacji powinna miec (zeby byc poprawna) trzeci obiekt ktory nazwiemy PerosnRequest
    // z polami podanymi wyzej

    @PutMapping("/create")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createPerson(@RequestBody final PersonRequest request) {
       log.info("Tworzy osobę");
      service.createPerson(request);
    }

}
