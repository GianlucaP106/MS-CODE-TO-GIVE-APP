package msgroup.gleaningplanner.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import msgroup.gleaningplanner.controller.TransferObject.LocationAPITO;
import msgroup.gleaningplanner.controller.TransferObject.LocationAPITO.LocationData;

@Service
public class LocationService {

    private String API_url = "http://api.positionstack.com/v1/forward?";

    private final RestTemplate restTemplate;

    public LocationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public LocationAPITO transformToLatitudeLongitude(String address, String postalCode, String city) {
        // TODO: implement verification methods for address, postalcode and city

        // setting up URL information
        String API_key_param = "82a01115f0f83cc61734000a40d1c31e";

        // conditionally adding query params
        String queryParam = "canada, ";
        if(address != null) queryParam += address;
        if(city != null) queryParam += ", " + city;
        if(postalCode != null) queryParam += ", " + postalCode;

        String API_url_params = "access_key=" + API_key_param + "&query=" + queryParam;

        // creating request URL
        String queryURL = API_url + API_url_params;

        ResponseEntity<LocationAPITO> response = restTemplate.getForEntity(queryURL, LocationAPITO.class);
        LocationAPITO body = response.getBody(); 

        System.out.println(queryURL);

        if (response.getStatusCode() == HttpStatus.OK && body != null){
            List<LocationData> data = new ArrayList<>();

            // filtering to only have locations from canada.
            body.data.forEach(element -> {
                if(element.country.toLowerCase().equals("canada")) data.add(element);
            });

            body.data = data;
            return body;
        } else {
            return null;
        }
    }
}
