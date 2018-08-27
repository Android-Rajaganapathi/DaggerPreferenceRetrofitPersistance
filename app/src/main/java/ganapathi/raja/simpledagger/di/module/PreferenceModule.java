package ganapathi.raja.simpledagger.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import ganapathi.raja.simpledagger.di.PreferenceScope;
import ganapathi.raja.simpledagger.model.UserInfo;

@Module
public class PreferenceModule {

    @Provides
    public UserInfo provideUserInfo() {
        return new UserInfo();
    }

    private Context context;

    public PreferenceModule(Context context) {
        this.context = context;
    }

    @Provides
    @PreferenceScope
    SharedPreferences provideSharedPreferences() {
        return context.getSharedPreferences("PrefName", Context.MODE_PRIVATE);
    }

}
