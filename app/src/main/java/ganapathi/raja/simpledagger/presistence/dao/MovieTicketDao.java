package ganapathi.raja.simpledagger.presistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import java.util.List;

import ganapathi.raja.simpledagger.presistence.entity.MovieTicketEntity;

@Dao
public interface MovieTicketDao {

    @Insert
    void insert(MovieTicketEntity... ticket);

    @Insert
    void insert(MovieTicketEntity ticket);

    @Insert
    void insert(List<MovieTicketEntity> tickets);

    @Update
    void update(MovieTicketEntity... ticket);

    @Delete
    void delete(MovieTicketEntity... ticket);


    @Query("SELECT * FROM MovieTicketEntity")
    List<MovieTicketEntity> getAllTickets();

    @Query("SELECT * FROM MovieTicketEntity WHERE id=:id")
    MovieTicketEntity getTicket(int id);

    @Query("SELECT * FROM MovieTicketEntity")
    Cursor getTicketCursor();

    @Query("SELECT * FROM MovieTicketEntity WHERE title=:title")
    List<MovieTicketEntity> getTicketByTitle(String title);

    @Query("SELECT * FROM MovieTicketEntity WHERE title=:title LIMIT :max")
    List<MovieTicketEntity> getTicketByTitle(int max, String... title);
}