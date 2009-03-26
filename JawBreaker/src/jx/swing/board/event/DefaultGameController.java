/*
 * DefaultGameController.java
 *
 * Created on November 21, 2006, 1:14 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jx.swing.board.event;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import jx.swing.board.Board;
import jx.swing.board.model.BoardModel;
import jx.swing.board.model.Cell;
import jx.swing.board.model.CellType;
import jx.swing.board.model.DefaultBoardModel;

/**
 *
 * @author Administrator
 */
public class DefaultGameController implements GameController, BoardSelectionListener {
    
    private boolean hasAdjacentCell = false;
    private GameEvent event;
    private Random random;
    /**
     * Creates a new instance of DefaultGameController
     */
    public DefaultGameController() {
        random = new Random();
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
        this.model = model;
        if(board != null)
            board.setModel(model);
    }
    
    /**
     * Holds value of property board.
     */
    private Board board;
    
    /**
     * Getter for property board.
     * @return Value of property board.
     */
    public Board getBoard() {
        return this.board;
    }
    /**
     * Setter for property board.
     * @param board New value of property board.
     */
    public void setBoard(Board board) {
        if(this.board !=null)
            this.board.removeBoardSelectionListener(this);
        if(board !=null){
            this.board = board;
            this.board.addBoardSelectionListener(this);
        }
        if(model !=null)
            board.setModel(model);
    }
    
    public void valueChanged(BoardSelectionEvent e) {
        Cell cell = (Cell)e.getSource();
        if(cell.getType() == CellType.EMPTY)
            return;
        if(cell.isSelected()){
            //remove selected
            int numberCellRemoved = 0;
            for(int i=0; i<model.getRowCount(); i++) {
                for(int j=0; j<model.getColumnCount(); j++){
                    Cell tmpCell = (Cell) model.getValueAt(i,j);
                    if(tmpCell.getType()!=CellType.EMPTY && tmpCell.isSelected()){
                        tmpCell.setType(CellType.EMPTY);
                        tmpCell.setSelected(false);
                        numberCellRemoved++;
                    }
                }
            }
            updateSocre(numberCellRemoved);
            reArrangeBoard();
            if(isGameOver()) {
                gameListener.finished(event);
                JOptionPane.showMessageDialog(null,"Game Over!");
            }
            event.setNumberOfBalls(getNumberOfBallsOnBoard());
            gameListener.changed(event);
        } else {
            //deselected selected items
            for(int i=0; i<model.getRowCount(); i++) {
                for(int j=0; j<model.getColumnCount(); j++){
                    Cell tmpCell = (Cell) model.getValueAt(i,j);
                    if(tmpCell.getType()!=CellType.EMPTY && tmpCell.isSelected())
                        tmpCell.setSelected(false);
                }
            }
            //detects adjacent cells, and update them
            hasAdjacentCell = false;
            cell.setSelected(true);
            selectedCell(cell);
            if(! hasAdjacentCell){
                cell.setSelected(false);
            }
            
        }
    }
    private void selectedCell(Cell cell) {
        List<Cell> adjacentCellList = getAdjacentCell(cell);
        if(adjacentCellList.isEmpty())
            return;
        for (Cell c : adjacentCellList) {
            hasAdjacentCell = true;
            c.setSelected(true);
            selectedCell(c);
        }
    }
    private List<Cell> getAdjacentCell(Cell cell) {
        LinkedList<Cell> list = new LinkedList<Cell>();
        int row = cell.getRow();
        int col = cell.getCol();
        //top cell
        addAdjacentCell(row-1, col, list, cell);
        //buttom cell
        addAdjacentCell(row +1, col,list, cell);
        //left cell
        addAdjacentCell(row, col-1, list, cell);
        //right cell
        addAdjacentCell(row, col+1, list, cell);
        return list;
    }
    private void addAdjacentCell(int row,int col,LinkedList<Cell> list, Cell cell) {
        if(isValidCell(row,col)) {
            Cell tmpCell = (Cell) model.getValueAt(row,col);
            if(tmpCell.getType() != CellType.EMPTY && tmpCell.getType() == cell.getType() && !tmpCell.isSelected()){
                list.addLast(tmpCell);
            }
        }
    }
    private boolean isValidCell(int row, int col) {
        if(row <0 || row > model.getRowCount()-1)
            return false;
        if(col <0 || col > model.getColumnCount()-1)
            return false;
        return true;
    }
    private void reArrangeBoard() {
        for(int col =model.getColumnCount() -1; col>-1; col--){
            //detects if any empty column
            boolean isEmptyColumn = true;
            if(col == 0)
                isEmptyColumn = false;
            else {
                isEmptyColumn = isEmptyColumn(col);
            }
            //it is emtpy column, there move the left cells to this column
            if(isEmptyColumn) {
                //move the left non empty column to this column
                for(int row = 0; row<model.getRowCount(); row++) {
                    Cell origCell =(Cell) model.getValueAt(row,col);
                    int nonEmptyColumnIndex = col-1;
                    for(int c= col-1; c>-1; c--) {
                        if(!isEmptyColumn(c)){
                            nonEmptyColumnIndex = c;
                            break;
                        }
                    }
                    Cell leftCell = (Cell) model.getValueAt(row,nonEmptyColumnIndex);
                    origCell.setType(leftCell.getType());
                    origCell.setSelected(leftCell.isSelected());
                    leftCell.setType(CellType.EMPTY);
                    leftCell.setSelected(false);
                }
            }
            //move row cells down
            for(int row =model.getRowCount()-1; row >-1; row--) {
                Cell cell = (Cell) model.getValueAt(row,col);
                if(cell.getType() == CellType.EMPTY) {
                    //get next non-empty cell, move it down
                    Cell nextNonEmptyCell = null;
                    for(int i = row-1; i>-1; i--) {
                        Cell tmp =(Cell) model.getValueAt(i,col);
                        if(tmp.getType() != CellType.EMPTY) {
                            nextNonEmptyCell = tmp;
                            break;
                        }
                    }
                    if(nextNonEmptyCell == null)
                        break;
                    else {
                        cell.setType(nextNonEmptyCell.getType());
                        cell.setSelected(nextNonEmptyCell.isSelected());
                        nextNonEmptyCell.setType(CellType.EMPTY);
                        nextNonEmptyCell.setSelected(false);
                    }
                }
            }
            
        }
    }
    
    public boolean isEmptyColumn(int col) {
        //check every cell of this col from bottom to up
        for(int row = model.getRowCount()-1; row>-1; row--) {
            Cell cell = (Cell) model.getValueAt(row,col);
            if(cell.getType() != CellType.EMPTY)
                return false;
        }
        return true;
    }
    public void newGame(int row, int col) {
        DefaultBoardModel model = new DefaultBoardModel();
        model.setData(getRandomBoard(row,col));
        setModel(model);
        event = new GameEvent(this);
        event.setNumberOfBalls(getNumberOfBallsOnBoard());
        gameListener.started(event);
        gameListener.changed(event);
    }
    public void undo(){
        
    }
    public void redo(){
    }
    private int [] getNumberOfBallsOnBoard() {
        int[] numberOfBallsOnBoard = new int[5];
        for(int col = model.getColumnCount()-1; col>-1; col--) {
            if(isEmptyColumn(col))
                break;
            for(int row = model.getRowCount() -1; row>-1; row--){
                Cell cell =(Cell) model.getValueAt(row,col);
                CellType type = cell.getType();
                switch(type) {
                    case BLUE :{
                        numberOfBallsOnBoard[0]++; break;
                    }
                    case GREEN:{
                        numberOfBallsOnBoard[1]++; break;
                    }
                    case MAGENTA:{
                        numberOfBallsOnBoard[2]++; break;
                    }
                    case RED:{
                        numberOfBallsOnBoard[3]++; break;
                    }
                    case ORANGE:{
                        numberOfBallsOnBoard[4]++; break;
                    }
                }
            }
        }
        return numberOfBallsOnBoard;
    }
    private boolean isGameOver() {
        for(int row = model.getRowCount()-1; row>-1; row--) {
            for(int col = model.getColumnCount()-1; col>-1; col--) {
                Cell cell = (Cell)model.getValueAt(row,col);
                if(cell.getType()!=CellType.EMPTY) {
                    List<Cell> list =  getAdjacentCell(cell);
                    if(!list.isEmpty())
                        return false;
                }
            }
        }
        return true;
    }
    private Object [][] getRandomBoard(int row, int col) {
        Cell cells [][] = new Cell[row][col];
        for(int i=0; i<cells.length; i++) {
            for(int j=0; j<cells[0].length; j++) {
                cells[i][j] = new Cell(i, j, false, randomCellType() );
            }
        }
        return cells;
    }
    private CellType randomCellType() {
        int i = random.nextInt(5);
        switch(i) {
            case 0: return CellType.BLUE;
            case 1: return CellType.GREEN;
            case 2: return CellType.MAGENTA;
            case 3: return CellType.RED;
            case 4: return CellType.ORANGE;
        }
        return CellType.ORANGE;
    }
    public void updateSocre(int numberCellRemoved) {
        int presentScore = event.getTotalScore();
        event.setTotalScore(presentScore + (numberCellRemoved * (numberCellRemoved -1)));
        gameListener.changed(event);
    }
    
    /**
     * Utility field holding the GameListener.
     */
    private transient jx.swing.board.event.GameListener gameListener =  null;
    
    /**
     * Registers GameListener to receive events.
     * @param listener The listener to register.
     */
    public synchronized void addGameListener(jx.swing.board.event.GameListener listener) throws java.util.TooManyListenersException {
        if (gameListener != null) {
            throw new java.util.TooManyListenersException();
        }
        gameListener = listener;
    }
    
    /**
     * Removes GameListener from the list of listeners.
     * @param listener The listener to remove.
     */
    public synchronized void removeGameListener(jx.swing.board.event.GameListener listener) {
        gameListener = null;
    }
    
}
