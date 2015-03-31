package carpooling.model.account;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Guillaume on 31/03/2015.
 */
@Entity
public class Note {
    private int id;

    @GeneratedValue
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int note;

    @Basic
    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
