/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jx.swing.board.app;

import javax.swing.JApplet;
import jx.swing.board.event.DefaultGameController;

/**
 *
 * @author yuezhong
 */
public class JawBreakerApplet extends JApplet {

    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    private DefaultGameController controller;
    // Variables declaration - do not modify
    private jx.swing.board.Board board1;
    private jx.swing.board.ControlPanel controlPanel1;
    private javax.swing.JLabel jLabel1;

    @Override
    public void init() {


        controlPanel1 = new jx.swing.board.ControlPanel();
        board1 = new jx.swing.board.Board();
        jLabel1 = new javax.swing.JLabel();

        controller = new DefaultGameController();
        controller.setBoard(board1);
        controlPanel1.setController(controller);

        getContentPane().add(controlPanel1, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout board1Layout = new javax.swing.GroupLayout(board1);
        board1.setLayout(board1Layout);
        board1Layout.setHorizontalGroup(
                board1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 322, Short.MAX_VALUE));
        board1Layout.setVerticalGroup(
                board1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 332, Short.MAX_VALUE));

        getContentPane().add(board1, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Developed by : Yuezhong Zhang");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_END);

    }

    // TODO overwrite start(), stop() and destroy() methods
}
