package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan
        String studentNr = "0144207622";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        String kurssiBody = Request.Get("https://ohtustats2017.herokuapp.com/courses/1.json").execute().returnContent().asString();
        Gson kurssiMapper = new Gson();
        Course c = kurssiMapper.fromJson(kurssiBody, Course.class);

        System.out.println("  Kurssi: " + c.getName() + ", " + c.getTerm());
        
        int tunnit = 0;
        int tehtavat = 0;
        System.out.println("opiskelijanumero: " + subs[0].getStudent_number() + "\n");
        for (Submission submission : subs) {
            System.out.println("  " + submission);
            tunnit += submission.getHours();
            tehtavat += submission.getCount();
        }

        System.out.println("\nyhteensä: " + tehtavat + " tehtävää " + tunnit + " tuntia");

    }
}
