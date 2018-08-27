package ganapathi.raja.simpledagger.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import javax.inject.Inject;

import ganapathi.raja.simpledagger.MyApplication;
import ganapathi.raja.simpledagger.R;
import ganapathi.raja.simpledagger.di.components.DaggerNetworkActivityComponent;
import ganapathi.raja.simpledagger.di.components.NetworkActivityComponent;
import ganapathi.raja.simpledagger.di.module.NetworkModule;
import ganapathi.raja.simpledagger.model.ModelApi;

public class NetworkActivity extends AppCompatActivity {

    @Inject
    ModelApi modelApi;

    NetworkActivityComponent mComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        mComponent = DaggerNetworkActivityComponent
                .builder()
                .networkModule(new NetworkModule("https://api.androidhive.info/"))
                .build();

        mComponent.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mComponent = null;
    }

    public void callApi(View view) {
        modelApi.callApi();
    }

}
