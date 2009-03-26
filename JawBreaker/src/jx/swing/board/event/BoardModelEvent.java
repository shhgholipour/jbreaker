/*
 * BoardModelEvent.java
 *
 * Created on November 20, 2006, 8:24 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jx.swing.board.event;

import java.io.Serializable;
import java.util.EventObject;
import jx.swing.board.model.BoardModel;

/**
 *
 * @author Administrator
 */
public class BoardModelEvent extends EventObject implements Serializable  {
    
    private int row = -1;
    private int col = -1;
    public BoardModelEvent(BoardModel source) {
        super(source);
    }
    public BoardModelEvent(BoardModel source, int row, int col) {
        super(source);
        this.row = row;
        this.col = col;
    }
}
