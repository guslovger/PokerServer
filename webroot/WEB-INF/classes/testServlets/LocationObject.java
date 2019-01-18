package servlets;
    
public class LocationObject{
    private String id;
    private String location_name;
    
    public LocationObject(String id, String location_name) {
        this.id = id;
        this.location_name = location_name;
    }
    public String id(){return id;}
    public String location_name(){return location_name;}
    @Override
    public String toString(){
    return new StringBuilder(id)
      .append(" | ").append(location_name)
      .toString();
  }
}