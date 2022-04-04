
package program;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class RunnableMatrizMulti implements Runnable {

    private Label[][] matrizMulti;
    public static int quantidade = 0;
    private int linhaInicial;
    private int segundo = 1000;

    public RunnableMatrizMulti(Label[][] matrizMulti, int linhaInicial) {
        this.matrizMulti = matrizMulti;
        this.linhaInicial = linhaInicial;
    }
    //matriz que vai representar a multithread percorrendo linhas e colunas
    @Override
    public void run() {
        for (int linha = this.linhaInicial; linha <= linhaInicial; linha++) {
            for (int coluna = 0; coluna <= 9; coluna++) {
                try {
                    Label label = matrizMulti[linha][coluna];
                    Platform.runLater(() -> label.setStyle("-fx-border-color:#C6ACC7; -fx-background-color:#A4DFFF"));
                    Platform.runLater(() -> RunnableMatrizMulti.quantidade++);
                    Thread.sleep(new Random().nextInt(segundo));
                } catch (InterruptedException ex) {
                    Logger.getLogger(RunnableMatrizMulti.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
