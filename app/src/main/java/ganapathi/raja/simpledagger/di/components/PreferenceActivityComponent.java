package ganapathi.raja.simpledagger.di.components;

import dagger.Component;
import ganapathi.raja.simpledagger.di.PreferenceScope;
import ganapathi.raja.simpledagger.di.module.PreferenceModule;
import ganapathi.raja.simpledagger.view.PreferenceActivity;

@PreferenceScope
@Component(modules = PreferenceModule.class)
public interface PreferenceActivityComponent {

    void inject(PreferenceActivity activity);

}
