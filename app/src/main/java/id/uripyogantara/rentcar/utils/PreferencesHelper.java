package id.uripyogantara.rentcar.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper {
    private SharedPreferences sharedPreferences;
    private final String PREFERENCES_NAME="shared_preferences";
    private final String LOGIN="login";
    private final String TOKEN="token";
    private final String MEDICAL_CENTER="medical_center";

    public PreferencesHelper(Context context) {
        sharedPreferences=context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE);
    }

    public void setLogin(boolean login){
        sharedPreferences.edit().putBoolean(LOGIN,login).apply();
    }

    public boolean getLogin(){
        return sharedPreferences.getBoolean(LOGIN,false);
    }

    public void setToken(String token){
        sharedPreferences.edit().putString(TOKEN,token).apply();
    }

    public String getToken(){
        return sharedPreferences.getString(TOKEN,"");
    }

    public void setMedicalCenter(int medicalCenter){
        sharedPreferences.edit().putInt(MEDICAL_CENTER,medicalCenter).apply();
    }

    public int getMedicalCenter(){
        return sharedPreferences.getInt(MEDICAL_CENTER,0);
    }
}
