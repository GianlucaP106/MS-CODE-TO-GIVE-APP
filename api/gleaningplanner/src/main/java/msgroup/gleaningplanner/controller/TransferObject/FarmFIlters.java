package msgroup.gleaningplanner.controller.TransferObject;

import java.util.List;

public class FarmFIlters {
    
    public List<FarmObjectDTO> farms;

    public static class FarmObjectDTO{
        public int id;
        public String farmName;
        public String address;
        public String postalCode;
        public String city;
        public double longitude;
        public double latitude;
        public double surfaceArea;

        public FarmObjectDTO(int id, String farmName, String address, String postalCode, String city, double longitude,
                double latitude, double surfaceArea) {
            this.id = id;
            this.farmName = farmName;
            this.address = address;
            this.postalCode = postalCode;
            this.city = city;
            this.longitude = longitude;
            this.latitude = latitude;
            this.surfaceArea = surfaceArea;
        }
    }

}