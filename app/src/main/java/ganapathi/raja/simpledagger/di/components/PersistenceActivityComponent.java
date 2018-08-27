package ganapathi.raja.simpledagger.di.components;

import dagger.Component;
import ganapathi.raja.simpledagger.di.PersistenceScope;
import ganapathi.raja.simpledagger.di.module.PersistenceModule;
import ganapathi.raja.simpledagger.view.PersistenceActivity;

@PersistenceScope
@Component(modules = PersistenceModule.class)
public interface PersistenceActivityComponent {

    void inject(PersistenceActivity activity);

}
