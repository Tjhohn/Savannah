package hohn_tanner.savannah;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

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
        updateTilesDay();
        subject.firePropertyChange("newDay", null, this.dayCnt);//GRADING: TRIGGER
    }

    public void changeSize(Integer newSize){
        size = newSize;
        dayCnt = 0;
        deadCnt = 0;
        fillCnt = 0;
        fillTileArray();
        subject.firePropertyChange("resize", null, this.size); //GRADING: TRIGGER
    }

    public void updateInfo(String info){
        subject.firePropertyChange("viewInfo", null, info);//GRADING: TRIGGER
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

    public void increaseFill(){
        fillCnt++;
        subject.firePropertyChange("updateCount", null, deadCnt);//GRADING: TRIGGER
    }

    public void decreaseFill(){
        fillCnt--;
        subject.firePropertyChange("updateCount", null, deadCnt);//GRADING: TRIGGER
    }

    private void updateTilesDay(){
        for( int i = 0; i < size; i++){
            for( int j = 0; j < size; j++){
                Animal prev_animal = tileArray[i][j].getAnimal();
                tileArray[i][j].newDay();
                if(tileArray[i][j].getAnimal() != prev_animal){
                    deadCnt++;
                    fillCnt--;
                    subject.firePropertyChange("updateCount", null, deadCnt);//GRADING: TRIGGER
                }
            }
        }
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
