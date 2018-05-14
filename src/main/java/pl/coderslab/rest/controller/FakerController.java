package pl.coderslab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.rest.service.FakerCountryService;
import pl.coderslab.rest.service.FakerGameService;
import pl.coderslab.rest.service.FakerLeagueService;

// Ten Controller to kontroler do naszego API - tu mamy tzw. punkty dostepowe
// Controller obsluguje protokol HTTP (jest jak zbior serwletow), ale patrz nizej...
// Controller to tez chyba komponent Springa
// Do controllera wstrzykujemy zaleznosci (dawniej to byly beansy, potem klasy z adnotacja @Component, teraz uzywamy @Service). Wczesniejs pobieralismy klasy zalezne przez metode getBeans w mainie.
// Controller grupuje akcje (dawniej kazdy servlet jako oddzielna klasa javy mil jedna akcje; tu controller obsluguje wiele servleow/akcji)


@RestController //returnem bedzie tekst - daje efekt taki jak uzycie dodatkowej adnotacji @ResponsBody
@RequestMapping("/api")
public class FakerController {

    @Autowired  //wstrzykujemy serwis fakerService do kontrolera
    private FakerGameService fakerGameService;

    @Autowired
    private FakerCountryService fakerCountryService;

    @Autowired
    private FakerLeagueService fakerLeagueService;

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/fake-today-games")
    public String games() {
        return fakerGameService.getTodayGames().toString();     //getTodayGames zwraca pole todayGames serwisu FS. To pole trzyma liste obiektow JSON utworzana przez metode konstruktora.
    }

    @GetMapping("/countries")
    public String countries() {
        return fakerCountryService.getCountries().toString();
    }

    @GetMapping("/leagues")
    public String leagues() {
        return fakerLeagueService.getLeagues().toString();
    }

}
