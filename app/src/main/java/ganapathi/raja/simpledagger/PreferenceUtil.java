package ganapathi.raja.simpledagger;

import android.content.SharedPreferences;
import javax.inject.Inject;

public class PreferenceUtil {

    private SharedPreferences mSharedPreferences;

    @Inject
    PreferenceUtil(SharedPreferences mSharedPreferences) {
        this.mSharedPreferences = mSharedPreferences;
    }

    public void putData(String key, String data) {
        mSharedPreferences.edit().putString(key, data).apply();
    }

    public String getData(String key) {
        return mSharedPreferences.getString(key, "");
    }
}