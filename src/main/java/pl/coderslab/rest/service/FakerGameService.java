package pl.coderslab.rest.service;

import com.github.javafaker.Faker;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service    //@Service jest rodzajem Componentu (beansa, ziarna, klasy zarzadzanej przez Springa). Komponenty mozemy wstrzykiwac np do maina (w aplikacjach konsolowych) lub do controllera (w aplikacjach webowych)
public class FakerGameService {

    private ArrayList<JSONObject> todayGames = new ArrayList<>();

    // konstruktor wywoluje metode generujaca dane z fakera
    FakerGameService() throws JSONException{
        this.regenerate();
    }

    // getter do pola todayGames (lista utworzona w konstruktorze przez metode regenerate)
    public ArrayList<JSONObject> getTodayGames() {
        return todayGames;
    }

    // ta metoda tworzy 10 obiektow json z fakera (sa to wyniki meczow - 2 druzyny, 2 pukty i sport)
    //Adnotacja Scheduled powoduje samoistne wywolanie metody co okresolny czas (w milisekundach)
//    @Scheduled(fixedRate = 5000)
    public void regenerate() throws JSONException {

        Faker faker = new Faker();
        todayGames.clear();
        for (int i = 0; i < 10; i++) {
            JSONObject oJsonInner = new JSONObject();
            oJsonInner.put("firstTeam", faker.team().name());
            oJsonInner.put("firstPoints", faker.number().randomDigitNotZero());
            oJsonInner.put("secondTeam", faker.team().name());
            oJsonInner.put("secondPoints", faker.number().randomDigitNotZero());
            oJsonInner.put("sport", faker.team().sport());

            todayGames.add(oJsonInner);
        }

    }
}
