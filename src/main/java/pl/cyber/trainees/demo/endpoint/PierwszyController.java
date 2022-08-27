package pl.cyber.trainees.demo.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cyber.trainees.demo.dto.ImieDTO;

@RestController // adnotacja mówi serwerowi springa że w tym miejscu funkcjonalnosci REST API
@RequestMapping("/v1/first")
public class PierwszyController {
    // HTTP metoda GET - metoda służy do pobierania informacji z serwera oraz wysłania ich do zewnetrznego systemu
   @GetMapping("/{imie}")
    public ImieDTO getImie(@PathVariable final String imie){
        return ImieDTO.builder()
                .imie(imie)
                .build();
    }
}
