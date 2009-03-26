/*
 * AbstractBoardModel.java
 *
 * Created on November 20, 2006, 8:29 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jx.swing.board.model;

import javax.swing.event.EventListenerList;
import jx.swing.board.event.BoardModelEvent;
import jx.swing.board.event.BoardModelListener;

/**
 *
 * @author Administrator
 */
public class AbstractBoardModel implements BoardModel{
    
    /** Creates a new instance of AbstractBoardModel */
    private EventListenerList listenerList = new EventListenerList();
    
    public AbstractBoardModel() {
    }
    
    public void addBoardModelListener(BoardModelListener listener) {
        listenerList.add(BoardModelListener.class,listener);
    }
    
    public void removeBoardModelListener(BoardModelListener listener) {
        listenerList.remove(BoardModelListener.class, listener);
    }
    public BoardModelListener [] getBoardModelListeners() {
        return listenerList.getListeners(BoardModelListener.class);
    }
    public int getColumnCount(){
        return 0;
    }
    
    public int getRowCount(){
        return 0;
    }
    
    public Object getValueAt(int rowIndex, int colIndex){
        return null;
    }
    
    public  void setValueAt(Object aValue, int rowIndex, int colIndex){
    }
    public void fireBoardDataChanged(){
        BoardModelEvent event = new BoardModelEvent(this);
        fireBoardChanged(event);
    }
    public void fireTableStructureChanged() {
        BoardModelEvent event = new BoardModelEvent(this);
        fireBoardChanged(event);
    }
    public void fireBoardChanged(BoardModelEvent e) {
        BoardModelListener listenrs [] = listenerList.getListeners(BoardModelListener.class);
        for(BoardModelListener listener : listenrs) {
            listener.boardChanged(e);
        }
    }
    public void setData(Object[][] obj) {
    }
    public Object [][] getData(){
        return null;
    }
}
