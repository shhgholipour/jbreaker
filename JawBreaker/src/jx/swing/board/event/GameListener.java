/*
 * GameListener.java
 *
 * Created on November 21, 2006, 9:18 AM
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
public interface GameListener extends EventListener{
    public void started(GameEvent e);
    public void changed(GameEvent e);
    public void finished(GameEvent e);
}
