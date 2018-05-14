package pl.coderslab.rest.service;

import com.github.javafaker.Faker;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakerCountryService {

    private ArrayList<JSONObject> countries = new ArrayList<>();

    FakerCountryService() throws JSONException{
        this.regenerate();
    }

    public ArrayList<JSONObject> getCountries() {
        return countries;
    }

//    @Scheduled(fixedRate = 5000)
    public void regenerate() throws JSONException {

        Faker faker = new Faker();
        countries.clear();
        for (int i = 0; i < 30; i++) {
            JSONObject oJsonInner = new JSONObject();
            oJsonInner.put("country_id", i+1);
            oJsonInner.put("country_name", faker.address().country());
            countries.add(oJsonInner);
        }

    }
}
