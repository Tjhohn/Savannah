package hohn_tanner.savannah;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Savannah {

    private Integer dayCnt = 0;
    private Integer deadCnt = 0;
    private Integer fillCnt = 0;
    private Integer size = 3;
    private PropertyChangeSupport subject;
    private Tile[][] tileArray;

    public Savannah(){
        fillTileArray();
        subject = new PropertyChangeSupport(this);
    }


    public void addObserver(PropertyChangeListener obv) {
        subject.addPropertyChangeListener(obv); //GRADING: SUBJECT
    }

    public void newDay(){
        dayCnt++;
        subject.firePropertyChange("newDay", null, this.dayCnt);//GRADING: TRIGGER
    }

    public void changeSize(Integer newSize){
        size = newSize;
        fillTileArray();
        subject.firePropertyChange("resize", null, this.size); //GRADING: TRIGGER
    }

    public Integer getDayCnt(){
        return dayCnt;
    }

    public Integer getDeadCnt(){
        return deadCnt;
    }

    public Integer getFillCnt() { return fillCnt; }

    public Integer getSize(){
        return size;
    }

    public Tile getTile(int row, int col){
        return tileArray[row][col];
    }

    private void fillTileArray(){
        tileArray = new Tile[size][size];
        for( int i = 0; i < size; i++){
            for( int j = 0; j < size; j++){
                tileArray[i][j]= new Tile(i,j);
            }
        }
    }

}
