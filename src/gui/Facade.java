/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import ServiceLayer.HttpServer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brasha
 */
public class Facade {
    public Facade()
    {
        Thread thr = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    new HttpServer().start();
                } catch (Throwable ex) {
                    Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        thr.start();


        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
}
