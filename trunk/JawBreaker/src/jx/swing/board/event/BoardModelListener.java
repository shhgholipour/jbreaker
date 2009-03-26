/*
 * BoardModelListener.java
 *
 * Created on November 20, 2006, 8:22 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jx.swing.board.event;

import java.util.EventListener;

/**
 *
 * @author Administrator
 */
public interface BoardModelListener extends EventListener{
    public void boardChanged(BoardModelEvent event);
}
