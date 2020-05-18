import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class RestClient {

    public static void main(String[] args) throws IOException {
        //pobieranie poprzez stworzenie specjalnego modelu
        URL urlCatFact = new URL("https://cat-fact.herokuapp.com/facts/random");
        InputStreamReader readerCatFact = new InputStreamReader(urlCatFact.openStream());
        CatFact catFact = new Gson().fromJson(readerCatFact, CatFact.class);
        System.out.println(catFact.getText());

        //zapisywanie obiekty do tymczasowego obiektu z bibl. Gson
        URL urlCatImage = new URL("https://aws.random.cat/meow");
        InputStreamReader readerCatImage = new InputStreamReader(urlCatImage.openStream());
        JsonObject jsonObject = new JsonParser().parse(readerCatImage).getAsJsonObject();
        System.out.println(jsonObject.get("file").getAsString());


    }
}
