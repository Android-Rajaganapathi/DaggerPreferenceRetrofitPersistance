package ganapathi.raja.simpledagger.presistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ganapathi.raja.simpledagger.presistence.dao.MovieTicketDao;
import ganapathi.raja.simpledagger.presistence.entity.MovieTicketEntity;

@Database(entities = {MovieTicketEntity.class}, version = DemoDatabase.VERSION, exportSchema = false)
public abstract class DemoDatabase extends RoomDatabase {

    static final int VERSION = 1;

    public abstract MovieTicketDao getMovieTicketDao();

}