package msgroup.gleaningplanner.controller.TransferObject;

public class UserTypeTO {
    
    public int ID;
    public String userType;

    

    public UserTypeTO(int iD, String userType) {
        ID = iD;
        this.userType = userType;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }

    

}
