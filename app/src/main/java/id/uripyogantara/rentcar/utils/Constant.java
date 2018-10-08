package id.uripyogantara.rentcar.utils;

public class Constant {
    public static final String BASE_URL="http://10.10.9.55:8000/";
    public static final class UserType{
        public static final int USER=1;
        public static final int STORE=2;
    }

    public static class URL{
        public static String carImage(String file){
            return BASE_URL+"images/car/"+file;
        }
    }
}
