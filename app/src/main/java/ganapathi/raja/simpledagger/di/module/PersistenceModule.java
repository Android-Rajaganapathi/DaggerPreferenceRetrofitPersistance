package ganapathi.raja.simpledagger.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ganapathi.raja.simpledagger.di.PersistenceScope;
import ganapathi.raja.simpledagger.presistence.DemoDatabase;
import ganapathi.raja.simpledagger.presistence.dao.MovieTicketDao;

@Module
public class PersistenceModule {

    private DemoDatabase demoDatabase;

    public PersistenceModule(Application mApplication) {
        demoDatabase = Room
                .databaseBuilder(mApplication, DemoDatabase.class, "demo-db")
                .allowMainThreadQueries()
//                .fallbackToDestructiveMigration()
                .build();
    }

    @PersistenceScope
    @Provides
    DemoDatabase providesRoomDatabase() {
        return demoDatabase;
    }

    @PersistenceScope
    @Provides
    MovieTicketDao providesProductDao(DemoDatabase demoDatabase) {
        return demoDatabase.getMovieTicketDao();
    }
}


