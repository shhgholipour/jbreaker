/*
 * BoardSelectionListener.java
 *
 * Created on November 21, 2006, 12:42 AM
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
public interface BoardSelectionListener extends EventListener {
    
    public void valueChanged(BoardSelectionEvent e);
    
}
