/*
 * BoardModel.java
 *
 * Created on November 20, 2006, 8:19 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jx.swing.board.model;

import jx.swing.board.event.BoardModelListener;

/**
 *
 * @author Administrator
 */
public interface BoardModel {
    public void addBoardModelListener(BoardModelListener listener);
    public void removeBoardModelListener(BoardModelListener listener);
    public int getColumnCount();
    public int getRowCount();
    public Object getValueAt(int rowIndex, int colIndex);
    public void setValueAt(Object aValue, int rowIndex, int colIndex);
    public void setData(Object [][] obj);
    public Object[][] getData();
}
