/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class RunnableMatrizSingle implements Runnable {

    private Label[][] matriz;
    public static int quantidade = 0;
    public static int segundo = 1000;

    public RunnableMatrizSingle(Label[][] matriz) {
        this.matriz = matriz;
    }
  //matriz que vai representar a singlethread percorrendo apenas as linhas
    @Override
    public void run() {
        for (int linha = 0; linha <= 9; linha++) {
            for (int coluna = 0; coluna <= 9; coluna++) {
                try {
                    Label label = matriz[linha][coluna];
                    Platform.runLater(() -> label.setStyle("-fx-border-color:#C6ACC7; -fx-background-color:#A4DFFF"));
                    Platform.runLater(() -> RunnableMatrizSingle.quantidade++);
                    Thread.sleep(new Random().nextInt(segundo));
                } catch (InterruptedException ex) {
                    Logger.getLogger(RunnableMatrizSingle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
