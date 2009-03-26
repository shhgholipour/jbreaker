/*
 * GameEvent.java
 *
 * Created on November 21, 2006, 9:23 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jx.swing.board.event;

import java.io.Serializable;
import java.util.EventObject;
import jx.swing.board.model.CellType;

/**
 *
 * @author Administrator
 */
public class GameEvent extends EventObject implements Serializable{
    
    /**
     * Creates a new instance of GameEvent
     */
    public GameEvent(Object source) {
        super(source);
    }
    
    /**
     * Holds value of property totalScore.
     */
    private int totalScore = 0;
    
    /**
     * Getter for property totalScore.
     * @return Value of property totalScore.
     */
    public int getTotalScore() {
        return this.totalScore;
    }
    
    /**
     * Setter for property totalScore.
     * @param totalScore New value of property totalScore.
     */
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
    
    /**
     * Holds value of property numberOfBalls.
     */
    private int [] numberOfBalls;
    
    /**
     * Getter for property numberOfBalls.
     * @return Value of property numberOfBalls.
     */
    public int [] getNumberOfBalls() {
        return this.numberOfBalls;
    }
    
    /**
     * Setter for property numberOfBalls.
     * @param numberOfBalls New value of property numberOfBalls.
     */
    public void setNumberOfBalls(int [] numberOfBalls) {
        this.numberOfBalls = numberOfBalls;
    }
    
    public int getNumberOfBall(CellType type) {
        switch(type) {
            case BLUE :{
                return numberOfBalls[0];
            }
            case GREEN:{
                return numberOfBalls[1];
            }
            case MAGENTA:{
                return numberOfBalls[2];
            }
            case RED:{
                return numberOfBalls[3];
            }
            case ORANGE:{
                return numberOfBalls[4];
            }
        }
        return 0;
    }
    
}
