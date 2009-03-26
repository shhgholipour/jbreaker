/*
 * DefaultBoardModel.java
 *
 * Created on November 20, 2006, 8:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jx.swing.board.model;

import jx.swing.board.event.BoardModelEvent;

/**
 *
 * @author Administrator
 */
public class DefaultBoardModel extends AbstractBoardModel {
    private int rowCount = 0;
    private int colCount = 0;
    private Object [][] data;
    /** Creates a new instance of DefaultBoardModel */
    public DefaultBoardModel() {
    }
    public DefaultBoardModel(Object [][] data){
        this.data = data;
        rowCount = data.length;
        colCount = data[0].length;
    }
    @Override
    public int getColumnCount() {
        return colCount;
    }
    @Override
    public int getRowCount() {
        return rowCount;
    }
    @Override
    public Object getValueAt(int rowIndex, int colIndex) throws ArrayIndexOutOfBoundsException {
        return data[rowIndex][colIndex];
    }
    @Override
    public void setValueAt(Object obj, int rowIndex, int colIndex) throws ArrayIndexOutOfBoundsException  {
        data[rowIndex][colIndex] = obj;
        BoardModelEvent event = new BoardModelEvent(this,rowIndex, colIndex);
        fireBoardChanged(event);
    }
    @Override
    public void setData(Object [][] obj) {
        rowCount = obj.length;
        colCount = obj[0].length;
        data = obj;
        BoardModelEvent event = new BoardModelEvent(this,0,rowCount);
        fireBoardChanged(event);
    }
    public Object [][] getData(){
        return data;
    }
}
