package ganapathi.raja.simpledagger.di.module;

import dagger.Module;
import dagger.Provides;
import ganapathi.raja.simpledagger.model.ModelSimple;

@Module
public class SimpleActivityModule {

    @Provides
    public ModelSimple provideModel() {
        return new ModelSimple();
    }

}
