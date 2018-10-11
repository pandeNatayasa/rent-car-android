package id.uripyogantara.rentcar.utils;

public class Constant {
    public static final String BASE_URL="http://192.168.43.69:8000/";
    public static final class UserType{
        public static final int USER=1;
        public static final int STORE=2;
    }

    public static class URL{
        public static String carImage(String file){
            return BASE_URL+"images/car/"+file;
        }
        public static String api(){
            return BASE_URL+"api/";
        }
    }


}
