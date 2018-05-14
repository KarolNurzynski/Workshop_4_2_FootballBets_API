package pl.coderslab.rest.service;

import com.github.javafaker.Faker;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FakerLeagueService {

    private ArrayList<JSONObject> leagues = new ArrayList<>();

    FakerLeagueService() throws JSONException{
        this.regenerate();
    }

    public ArrayList<JSONObject> getLeagues() {
        return leagues;
    }

//    @Scheduled(fixedRate = 5000)
    public void regenerate() throws JSONException {

        Faker faker = new Faker();
        leagues.clear();
        for (int i = 1; i < 30; i++) {
            JSONObject oJsonInner = new JSONObject();
            oJsonInner.put("league_id", i);
            oJsonInner.put("league_name", "League"+i);
            oJsonInner.put("league_country_id", i);
            leagues.add(oJsonInner);
        }

    }
}
