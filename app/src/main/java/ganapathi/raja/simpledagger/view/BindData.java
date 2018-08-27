package ganapathi.raja.simpledagger.view;

import java.util.List;

import ganapathi.raja.simpledagger.presistence.entity.MovieTicketEntity;

public interface BindData {
    void onDataReceived(List<MovieTicketEntity> tickets);
}
