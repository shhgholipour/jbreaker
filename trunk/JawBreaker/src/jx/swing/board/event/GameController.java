/*
 * GameController.java
 *
 * Created on November 21, 2006, 2:07 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jx.swing.board.event;

import jx.swing.board.Board;
import jx.swing.board.model.BoardModel;

/**
 *
 * @author Administrator
 */
public interface GameController {
    public void setBoard(Board board);
    public Board getBoard();
    public void setModel(BoardModel model);
    public BoardModel getModel();
    public void newGame(int row, int col);
    public void undo();
    public void redo();
    /**
     * Registers GameListener to receive events.
     * @param listener The listener to register.
     */
    public void addGameListener(jx.swing.board.event.GameListener listener) throws java.util.TooManyListenersException;
    
    /**
     * Removes GameListener from the list of listeners.
     * @param listener The listener to remove.
     */
    public void removeGameListener(jx.swing.board.event.GameListener listener);
}
