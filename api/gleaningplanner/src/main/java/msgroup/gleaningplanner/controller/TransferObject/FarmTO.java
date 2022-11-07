package msgroup.gleaningplanner.controller.TransferObject;

public class FarmTO {

    public int producerID;
    public FarmObjectDTO farm;

    public static class FarmObjectDTO{
        public int ID;
        public String name;
        public String address;
        public String postalCode;
        public String city;
        public Double radius;
        public Double longitude;
        public Double latitude;
        public Double surfaceArea;

        public FarmObjectDTO(int id, String farmName, String address, String postalCode, String city, double longitude,
                double latitude, double surfaceArea) {
            this.ID = id;
            this.name = name;
            this.address = address;
            this.postalCode = postalCode;
            this.city = city;
            this.longitude = longitude;
            this.latitude = latitude;
            this.surfaceArea = surfaceArea;
        }
    }

    public FarmTO(int producerID, FarmObjectDTO farm) {
        this.producerID = producerID;
        this.farm = farm;
    }
}
