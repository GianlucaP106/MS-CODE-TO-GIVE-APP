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

    private String postalCodeRegex = "/^[ABCEGHJ-NPRSTVXY]\\d[ABCEGHJ-NPRSTV-Z][ -]?\\d[ABCEGHJ-NPRSTV-Z]\\d$/i";
    private String cityRegex = "/^([A-Za-z- ]+)$/i";

    private String API_url = "http://api.positionstack.com/v1/forward?country=CA&limit=1&";

    private final RestTemplate restTemplate;

    public LocationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean validatePostalCode(String postalCode) {
        return postalCode.matches(postalCodeRegex);
    }

    public boolean validateCity(String city) {
        return city.matches(cityRegex);
    }

    public ResponseEntity<LocationAPITO> transformToLatitudeLongitude(String address, String postalCode, String city) {
        // setting up URL information
        String API_key_param = "82a01115f0f83cc61734000a40d1c31e";

        // conditionally adding query params
        String queryParam = "";
        if (address != null)
            queryParam += address;
        if (city != null && city.matches(cityRegex))
            queryParam += " " + city;
        if (postalCode != null && validatePostalCode(postalCode))
            queryParam += " " + postalCode;

        String API_url_params = "access_key=" + API_key_param + "&query=" + queryParam;

        // creating request URL
        String queryURL = API_url + API_url_params;

        ResponseEntity<LocationAPITO> response = restTemplate.getForEntity(queryURL, LocationAPITO.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            LocationAPITO body = response.getBody();
            List<LocationData> data = new ArrayList<>();

            // filtering to only have locations from canada.
            body.data.forEach(element -> {
                if (element.country != null && element.country.toLowerCase().equals("canada")){
                    data.add(element);
                }
            });

            if (data.size() == 0) {
                return new ResponseEntity<LocationAPITO>(body, HttpStatus.NO_CONTENT);
            }

            body.data = data;
            return new ResponseEntity<LocationAPITO>(body, HttpStatus.OK);

        } else {

            if (response.getStatusCode().value() >= 500)
                return new ResponseEntity<LocationAPITO>(new LocationAPITO(), HttpStatus.INTERNAL_SERVER_ERROR);

            if (response.getStatusCode().value() >= 400)
                return new ResponseEntity<LocationAPITO>(new LocationAPITO(), HttpStatus.BAD_REQUEST);

            return null;
        }
    }

    public double distanceBetweenTwoPoints(double lat1, double lat2, double lon1, double lon2) {
        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
 
        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                 + Math.cos(lat1) * Math.cos(lat2)
                 * Math.pow(Math.sin(dlon / 2),2);
             
        double c = 2 * Math.asin(Math.sqrt(a));
 
        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;
 
        // calculate the result
        return(c * r);
    }
}
