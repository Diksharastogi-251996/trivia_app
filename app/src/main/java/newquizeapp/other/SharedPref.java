package newquizeapp.other;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import newquizeapp.data.User;

public class SharedPref {

    private static SharedPref instance = null;

    private static final String sharedPreferencesName = "kevinSharedPref";

    private SharedPref() {
    }

    public static SharedPref getInstance() {
        if (instance == null) {
            instance = new SharedPref();
        }
        return instance;
    }

    public void setUser(Context context, newquizeapp.data.User user){
        SharedPreferences pref = context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(newquizeapp.other.Constants.USER,new Gson().toJson(user));
        editor.apply();
    }

    public newquizeapp.data.User getUser(Context context){
        SharedPreferences pref = context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
        return new Gson().fromJson(pref.getString(Constants.USER,""), User.class);
    }

    public void clearSharedPref(@NonNull Context context) {
        SharedPreferences pref = context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }

}
