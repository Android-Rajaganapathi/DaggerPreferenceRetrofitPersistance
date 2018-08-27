package ganapathi.raja.simpledagger.di.components;

import dagger.Component;
import ganapathi.raja.simpledagger.di.CustomScope;
import ganapathi.raja.simpledagger.di.module.SimpleActivityModule;
import ganapathi.raja.simpledagger.view.SimpleActivity;

@CustomScope
@Component(dependencies = ApplicationComponent.class, modules = SimpleActivityModule.class)
public interface SimpleActivityComponent {

    void inject(SimpleActivity activity);

}
