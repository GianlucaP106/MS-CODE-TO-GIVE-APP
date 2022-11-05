package msgroup.gleaningplanner.service;

import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private String API_url = "http://api.positionstack.com/v1/forward?";

    public int[] transformToLatitudeLongitude(String address, String postalCode, String city){
        int[] location = new int[2];
        HttpURLConnection connection = null;

        String API_key_param = "";
        String queryParam = address + ", " + city + ", " + postalCode;


        try{
            URL url = new URL(API_url);


        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            if(connection != null){
                connection.disconnect();
            }
        }
        
        return location;
    }
    
}
