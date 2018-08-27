package ganapathi.raja.simpledagger.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import ganapathi.raja.simpledagger.MyApplication;
import ganapathi.raja.simpledagger.R;
import ganapathi.raja.simpledagger.di.components.DaggerSimpleActivityComponent;
import ganapathi.raja.simpledagger.di.components.SimpleActivityComponent;
import ganapathi.raja.simpledagger.di.module.SimpleActivityModule;
import ganapathi.raja.simpledagger.model.ModelSimple;

public class SimpleActivity extends AppCompatActivity {

    @Inject
    ModelSimple modelSimple;

    private SimpleActivityComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mComponent = DaggerSimpleActivityComponent
                .builder()
                .applicationComponent(((MyApplication) getApplication()).getComponent())
                .simpleActivityModule(new SimpleActivityModule())
                .build();
        mComponent.inject(this);

        modelSimple.bindUserList();

        String s = null;

        for (int i = 0; i < modelSimple.getUserList().size(); i++) {
            System.out.println("modelSimple = " + modelSimple.getUserList().get(i).getName());
            s = String.format("%s %s \n", s, modelSimple.getUserList().get(i).getName());
        }

        TextView tv = findViewById(R.id.tv);
        tv.setText(s);

    }

    public void navigateScreen(View view) {
        if (view.getId() == R.id.btPref)
            startActivity(new Intent(this, PreferenceActivity.class));
        else if (view.getId() == R.id.btDb)
            startActivity(new Intent(this, PersistenceActivity.class));
        else if (view.getId() == R.id.btApi)
            startActivity(new Intent(this, NetworkActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mComponent = null;
    }
}
