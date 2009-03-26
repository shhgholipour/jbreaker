/*
 * Board.java
 *
 * Created on November 20, 2006, 11:08 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jx.swing.board;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;
import jx.swing.board.event.BoardModelEvent;
import jx.swing.board.event.BoardModelListener;
import jx.swing.board.event.BoardSelectionEvent;
import jx.swing.board.event.BoardSelectionListener;
import jx.swing.board.model.BoardModel;

/**
 *
 * @author Administrator
 */
public class Board extends JPanel implements BoardModelListener {
    /**
     * Creates a new instance of Board
     */
    ClickHandler clickHandler = new ClickHandler();
    public Board() {
        super();
    }
    
    /**
     * Holds value of property model.
     */
    private BoardModel model;
    
    /**
     * Getter for property model.
     * @return Value of property model.
     */
    public BoardModel getModel() {
        return this.model;
    }
    /**
     * Setter for property model.
     * @param model New value of property model.
     */
    public void setModel(BoardModel model) {
        if(this.model != null)
            this.model.removeBoardModelListener(this);
        this.model = model;
        if(this.model == null)
            return;
        this.model.addBoardModelListener(this);
        layoutBoard();
    }
    private void layoutBoard() {
        Component comps [] = this.getComponents();
        for(Component comp : comps)
            comp.removeMouseListener(clickHandler);
        this.removeAll();
        this.setLayout(new GridLayout(model.getRowCount(),model.getColumnCount(),1,1));
        for(int i= 0; i<model.getRowCount(); i++) {
            for(int j=0; j<model.getColumnCount(); j++){
                Component comp = (Component) model.getValueAt(i,j);
                comp.addMouseListener(clickHandler);
                this.add(comp);
            }
        }
        this.revalidate();
    }
    public void boardChanged(BoardModelEvent event) {
        repaint();
    }
    /**
     * Utility field used by event firing mechanism.
     */
    private EventListenerList listenerList =  null;
    
    /**
     * Registers BoardSelectionListener to receive events.
     * @param listener The listener to register.
     */
    public synchronized void addBoardSelectionListener(BoardSelectionListener listener) {
        if (listenerList == null ) {
            listenerList = new EventListenerList();
        }
        listenerList.add(BoardSelectionListener.class, listener);
    }
    
    /**
     * Removes BoardSelectionListener from the list of listeners.
     * @param listener The listener to remove.
     */
    public synchronized void removeBoardSelectionListener(BoardSelectionListener listener) {
        listenerList.remove(BoardSelectionListener.class, listener);
    }
    
    /**
     * Notifies all registered listeners about the event.
     *
     * @param event The event to be fired
     */
    private void fireBoardSelectionListenerValueChanged(BoardSelectionEvent event) {
        if (listenerList == null) return;
        Object[] listeners = listenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i]==BoardSelectionListener.class) {
                ((BoardSelectionListener)listeners[i+1]).valueChanged(event);
            }
        }
    }
    class ClickHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            fireBoardSelectionListenerValueChanged(new BoardSelectionEvent(e.getSource()));
        }
    }
    
}
