package ganapathi.raja.simpledagger.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import ganapathi.raja.simpledagger.PreferenceUtil;
import ganapathi.raja.simpledagger.R;
import ganapathi.raja.simpledagger.di.components.DaggerPreferenceActivityComponent;
import ganapathi.raja.simpledagger.di.components.PreferenceActivityComponent;
import ganapathi.raja.simpledagger.di.module.PreferenceModule;
import ganapathi.raja.simpledagger.model.UserInfo;

public class PreferenceActivity extends AppCompatActivity {

    private EditText etName, etPhone;
    private TextView tvDate;

    @Inject
    PreferenceUtil preferenceUtil;

    @Inject
    UserInfo mUserInfo;

    private PreferenceActivityComponent mComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        mComponent = DaggerPreferenceActivityComponent
                .builder()
                .preferenceModule(new PreferenceModule(this))
                .build();

        mComponent.inject(this);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);

        tvDate = findViewById(R.id.tvDate);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mComponent = null;
    }

    public void getPref(View view) {
        tvDate.setText(preferenceUtil.getData("key"));
    }

    public void savePref(View view) {
        preferenceUtil.putData(
                "key",
                "Name: " + etName.getText().toString() + "\nPhone: " + etPhone.getText().toString()
        );
    }
}
