package hohn_tanner.savannah;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Savannah {

    private Integer dayCnt = 0;
    private Integer deadCnt = 0;
    private PropertyChangeSupport subject;

    public Savannah(){
        subject = new PropertyChangeSupport(this);
    }


    public void addObserver(PropertyChangeListener obv) {
        subject.addPropertyChangeListener(obv);
    }

    public void newDay(){
        dayCnt++;

    }

}
