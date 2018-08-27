package ganapathi.raja.simpledagger.di.components;

import dagger.Component;
import ganapathi.raja.simpledagger.di.CustomScope;
import ganapathi.raja.simpledagger.di.NetworkScope;
import ganapathi.raja.simpledagger.di.module.NetworkModule;
import ganapathi.raja.simpledagger.view.NetworkActivity;

@NetworkScope
@Component(modules = NetworkModule.class)
public interface NetworkActivityComponent {

    void inject(NetworkActivity activity);

}
