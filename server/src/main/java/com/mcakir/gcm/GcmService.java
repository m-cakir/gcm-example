package com.mcakir.gcm;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.httpclient.HttpStatus;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GcmService {

    private final String GCM_API_KEY = "APKI_KEY_IS_HERE";

    private final String GCM_SEND_ENDPOINT = "https://gcm-http.googleapis.com/gcm/send";

    public MulticastResult push(MessageContent content){

        MulticastResult multicastResult = null;

        try{

            URL url = new URL(GCM_SEND_ENDPOINT);

            StringBuffer response = new StringBuffer();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            // Set the headers
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "key=" + GCM_API_KEY);

            ObjectMapper mapper = new ObjectMapper();
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            mapper.writeValue(wr, content);
            wr.flush();
            wr.close();

            int responseCode = conn.getResponseCode(); // Get the response

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            if(responseCode == HttpStatus.SC_OK){

                multicastResult = mapper.readValue(response.toString(), MulticastResult.class);

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return multicastResult;
    }
}
