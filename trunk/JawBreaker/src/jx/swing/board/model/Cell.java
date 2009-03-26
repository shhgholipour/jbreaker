/*
 * Cell.java
 *
 * Created on November 20, 2006, 8:59 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jx.swing.board.model;

import java.awt.Dimension;
import javax.swing.JLabel;
import jx.swing.util.ResourceManager;

/**
 *
 * @author Administrator
 */
public class Cell extends JLabel{
    /** Creates a new instance of Cell */
    public Cell() {
    }
    public Cell(int row, int col, boolean selected, CellType type) {
        this.row = row;
        this.col = col;
        this.selected = selected;
        this.type = type;
        setType(type);
    }
    /**
     * Holds value of property row.
     */
    private int row;
    
    /**
     * Getter for property row.
     * @return Value of property row.
     */
    public int getRow() {
        return this.row;
    }
    
    /**
     * Setter for property row.
     * @param row New value of property row.
     */
    public void setRow(int row) {
        this.row = row;
    }
    
    /**
     * Holds value of property col.
     */
    private int col;
    
    /**
     * Getter for property col.
     * @return Value of property col.
     */
    public int getCol() {
        return this.col;
    }
    
    /**
     * Setter for property col.
     * @param col New value of property col.
     */
    public void setCol(int col) {
        this.col = col;
    }
    
    /**
     * Holds value of property selected.
     */
    private boolean selected;
    
    /**
     * Getter for property selected.
     * @return Value of property selected.
     */
    public boolean isSelected() {
        return this.selected;
    }
    
    /**
     * Setter for property selected.
     * @param selected New value of property selected.
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
        setIcon(ResourceManager.getDefaultManager().getIcon(type,selected));
    }
    
    /**
     * Holds value of property type.
     */
    private CellType type;
    
    /**
     * Getter for property type.
     * @return Value of property type.
     */
    public CellType getType() {
        return this.type;
    }
    /**
     * Setter for property type.
     * @param type New value of property type.
     */
    public void setType(CellType type) {
        this.type = type;
        setIcon(ResourceManager.getDefaultManager().getIcon(type,selected));
    }
    
}
