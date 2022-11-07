package msgroup.gleaningplanner.controller.TransferObject;

import java.io.Serializable;
import java.util.List;

public class LocationAPITO implements Serializable{

    public List<LocationData> data;

    public static class LocationData implements Serializable{
        public double latitude;
        public double longitude;
        public String type;
        public String name;
        public String number;
        public String postal_code;
        public String street;
        public String confidence;
        public String region;
        public String region_code;
        public String county;
        public String locality;
        public String administrative_area;
        public String neighbourhood;
        public String country;
        public String country_code;
        public String continent;
        public String label;
        @Override
        public String toString() {
            return "LocationData [latitude=" + latitude + ", longitude=" + longitude + ", type=" + type + ", name="
                    + name + ", number=" + number + ", postal_code=" + postal_code + ", street=" + street
                    + ", confidence=" + confidence + ", region=" + region + ", region_code=" + region_code + ", county="
                    + county + ", locality=" + locality + ", administrative_area=" + administrative_area
                    + ", neighbourhood=" + neighbourhood + ", country=" + country + ", country_code=" + country_code
                    + ", continent=" + continent + ", label=" + label + "]";
        }

    }
}
