package ganapathi.raja.simpledagger.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import ganapathi.raja.simpledagger.R;
import ganapathi.raja.simpledagger.di.components.DaggerPersistenceActivityComponent;
import ganapathi.raja.simpledagger.di.components.PersistenceActivityComponent;
import ganapathi.raja.simpledagger.di.module.PersistenceModule;
import ganapathi.raja.simpledagger.presistence.dao.MovieTicketDao;
import ganapathi.raja.simpledagger.presistence.entity.MovieTicketEntity;

public class PersistenceActivity extends AppCompatActivity {

    @Inject
    MovieTicketDao dao;

    PersistenceActivityComponent mComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistance);

        mComponent = DaggerPersistenceActivityComponent
                .builder()
                .persistenceModule(new PersistenceModule(getApplication()))
                .build();

        mComponent.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mComponent = null;
    }

    public void makeAction(View view) {
        if (view.getId() == R.id.button) {
            MovieTicketEntity entity = new MovieTicketEntity();
            entity.setImage("Image");
            entity.setPrice("Price");
            entity.setTitle("Title");
            dao.insert(entity);
        } else if (view.getId() == R.id.button2) {
            MovieTicketEntity entity = new MovieTicketEntity();
            entity.setImage("Image Update");
            entity.setPrice("Price Update");
            entity.setTitle("Title Update");
            dao.update(entity);
        } else if (view.getId() == R.id.button3) {
            MovieTicketEntity entity = new MovieTicketEntity();
            entity.setImage("Image Update");
            entity.setPrice("Price Update");
            entity.setTitle("Title Update");
            dao.delete(entity);
        } else if (view.getId() == R.id.button4) {
            List<MovieTicketEntity> tickets = dao.getAllTickets();
            for (MovieTicketEntity ticket : tickets)
                System.out.println("Ticket = " + ticket.getTitle() + " Price = " + ticket.getPrice());
        }
    }
}
