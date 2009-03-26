/*
 * ControlPanel.java
 *
 * Created on November 21, 2006, 9:05 AM
 */

package jx.swing.board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TooManyListenersException;
import javax.swing.SwingUtilities;
import jx.swing.board.event.GameController;
import jx.swing.board.event.GameEvent;
import jx.swing.board.event.GameListener;
import jx.swing.board.model.CellType;
import jx.swing.util.ResourceManager;

/**
 *
 * @author  Administrator
 */
public class ControlPanel extends javax.swing.JPanel implements GameListener {
    
    /** Creates new form ControlPanel */
    public ControlPanel() {
        initComponents();
        initTimer();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rowBox = new javax.swing.JComboBox();
        colBox = new javax.swing.JComboBox();
        newGameBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        redLabel = new javax.swing.JLabel();
        orangeLabel = new javax.swing.JLabel();
        greenLabel = new javax.swing.JLabel();
        blueLabel = new javax.swing.JLabel();
        magenatLabel = new javax.swing.JLabel();
        totalScoreLabel = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();

        rowBox.setEditable(true);
        rowBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "8", "10", "12", "14", "16", "18", "20" }));
        rowBox.setSelectedIndex(2);
        rowBox.setName("Row"); // NOI18N
        rowBox.setNextFocusableComponent(colBox);
        rowBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rowBoxActionPerformed(evt);
            }
        });

        colBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "8", "10", "12", "14", "16", "18", "20" }));
        colBox.setSelectedIndex(2);

        newGameBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reload_page.png"))); // NOI18N
        newGameBtn.setBorderPainted(false);
        newGameBtn.setOpaque(false);
        newGameBtn.setRolloverEnabled(false);
        newGameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameBtnActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/undo.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setOpaque(false);
        jButton1.setRolloverEnabled(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/redo.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setOpaque(false);
        jButton2.setRolloverEnabled(false);

        jPanel1.setLayout(new java.awt.GridLayout(7, 1));

        redLabel.setIcon(ResourceManager.getDefaultManager().getSmallIcon(CellType.RED));
        jPanel1.add(redLabel);

        orangeLabel.setIcon(ResourceManager.getDefaultManager().getSmallIcon(CellType.ORANGE));
        jPanel1.add(orangeLabel);

        greenLabel.setIcon(ResourceManager.getDefaultManager().getSmallIcon(CellType.GREEN));
        jPanel1.add(greenLabel);

        blueLabel.setIcon(ResourceManager.getDefaultManager().getSmallIcon(CellType.BLUE));
        jPanel1.add(blueLabel);

        magenatLabel.setIcon(ResourceManager.getDefaultManager().getSmallIcon(CellType.MAGENTA));
        jPanel1.add(magenatLabel);
        jPanel1.add(totalScoreLabel);
        jPanel1.add(timerLabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(colBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rowBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(newGameBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, Short.MAX_VALUE))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rowBox, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(newGameBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void newGameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameBtnActionPerformed
// TODO add your handling code here:
        int row = Integer.parseInt((String)rowBox.getSelectedItem());
        int col = Integer.parseInt((String)colBox.getSelectedItem());
        controller.newGame(row,col);
        SwingUtilities.windowForComponent(this.getParent()).pack();
    }//GEN-LAST:event_newGameBtnActionPerformed

    private void rowBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rowBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rowBoxActionPerformed
    
    private javax.swing.Timer timer;
    private int elapseSeconds = 0;
    private StringBuffer timeBuf = new StringBuffer();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blueLabel;
    private javax.swing.JComboBox colBox;
    private javax.swing.JLabel greenLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel magenatLabel;
    private javax.swing.JButton newGameBtn;
    private javax.swing.JLabel orangeLabel;
    private javax.swing.JLabel redLabel;
    private javax.swing.JComboBox rowBox;
    private javax.swing.JLabel timerLabel;
    private javax.swing.JLabel totalScoreLabel;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Holds value of property controller.
     */
    private GameController controller;
    
    /**
     * Getter for property controller.
     * @return Value of property controller.
     */
    public GameController getController() {
        return this.controller;
    }
    
    /**
     * Setter for property controller.
     * @param controller New value of property controller.
     */
    public void setController(GameController controller) {
        this.controller = controller;
        try {
            this.controller.addGameListener(this);
        } catch (TooManyListenersException ex) {
        }
    }
    private void initTimer() {
        timer = new javax.swing.Timer(1000,new ActionListener() {
            public void actionPerformed(ActionEvent e){
                elapseSeconds ++;
                int second = elapseSeconds % 60;
                int minute = (elapseSeconds / 60) % 60;
                int hours =  (elapseSeconds / 60) / 60;
                timeBuf.delete(0,timeBuf.length());
                timeBuf.append( (hours > 9)? hours :"0" + hours );
                timeBuf.append(":");
                timeBuf.append( (minute >9)? minute:"0" + minute);
                timeBuf.append(":");
                timeBuf.append((second >9) ? second :"0" + second);
                timerLabel.setText(timeBuf.toString()); 
            }
        });
    }
    
    public void started(GameEvent e) {
        timer.restart();
        elapseSeconds = 0;
    }
    public void changed(GameEvent e) {
        this.redLabel.setText(String.valueOf(e.getNumberOfBall(CellType.RED)));
        this.blueLabel.setText(String.valueOf(e.getNumberOfBall(CellType.BLUE)));
        this.greenLabel.setText(String.valueOf(e.getNumberOfBall(CellType.GREEN)));
        this.magenatLabel.setText(String.valueOf(e.getNumberOfBall(CellType.MAGENTA)));
        this.orangeLabel.setText(String.valueOf(e.getNumberOfBall(CellType.ORANGE)));
        this.totalScoreLabel.setText("Score: "+e.getTotalScore());
    }
    
    public void finished(GameEvent e) {
        timer.stop();
        elapseSeconds = 0;
    }
}