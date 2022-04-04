
package program;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.RunnableMatrizMulti;
import javafx.RunnableMatrizSingle;
import javafx.RunnableTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;


public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane anchorPaneSingleThread;
    @FXML
    private AnchorPane anchorPaneMultiThread;

    private Label[][] singleThread = new Label[10][10];

    private Label[][] multiThread = new Label[10][10];
    @FXML
    private Label labelTimerSingleThread;
    @FXML
    private Label labelTimerMultiThread;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        iniciarMatriz(anchorPaneSingleThread, singleThread);
        iniciarMatriz(anchorPaneMultiThread, multiThread);
        //-------------------- SINGLE THREAD ---------------------
        																	//MATRIZ
        RunnableMatrizSingle runnableMatrizSingle = new RunnableMatrizSingle(this.singleThread);
        //declara a thread recebendo o objeto da classe da singlethread
        Thread t1 = new Thread(runnableMatrizSingle);
        //--------------------	MULTI THREADS --------------------
        																// (MATRIZ , COLUNA)
        RunnableMatrizMulti runnableMatrizMulti1 = new RunnableMatrizMulti(this.multiThread, 0);
        //declara a thread recebendo o objeto da classe da multithread
        Thread t2 = new Thread(runnableMatrizMulti1);
        RunnableMatrizMulti runnableMatrizMulti2 = new RunnableMatrizMulti(this.multiThread, 1);
        Thread t3 = new Thread(runnableMatrizMulti2);
        RunnableMatrizMulti runnableMatrizMulti3 = new RunnableMatrizMulti(this.multiThread, 2);
        Thread t4 = new Thread(runnableMatrizMulti3);
        RunnableMatrizMulti runnableMatrizMulti4 = new RunnableMatrizMulti(this.multiThread, 3);
        Thread t5 = new Thread(runnableMatrizMulti4);
        RunnableMatrizMulti runnableMatrizMulti5 = new RunnableMatrizMulti(this.multiThread, 4);
        Thread t6 = new Thread(runnableMatrizMulti5);
        RunnableMatrizMulti runnableMatrizMulti6 = new RunnableMatrizMulti(this.multiThread, 5);
        Thread t7 = new Thread(runnableMatrizMulti6);
        RunnableMatrizMulti runnableMatrizMulti7 = new RunnableMatrizMulti(this.multiThread, 6);
        Thread t8 = new Thread(runnableMatrizMulti7);
        RunnableMatrizMulti runnableMatrizMulti8 = new RunnableMatrizMulti(this.multiThread, 7);
        Thread t9 = new Thread(runnableMatrizMulti8);
        RunnableMatrizMulti runnableMatrizMulti9 = new RunnableMatrizMulti(this.multiThread, 8);
        Thread t10 = new Thread(runnableMatrizMulti9);
        RunnableMatrizMulti runnableMatrizMulti10 = new RunnableMatrizMulti(this.multiThread, 9);
        Thread t11 = new Thread(runnableMatrizMulti10);
        //objeto da classe do contador 
        RunnableTimer runnableTimer = new RunnableTimer(this.labelTimerSingleThread, this.labelTimerMultiThread);
        //thread do contador 
        Thread threadTimer = new Thread(runnableTimer);
        // thread do contador
        threadTimer.start();
        //single thread
        t1.start();
        // multithread
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
    }
    // layout da matriz a ser exibida
    public void iniciarMatriz(AnchorPane anchorPane, Label[][] matriz) {
        int x = 25;
        int y = 50;
        for (int linha = 0; linha <= 9; linha++) {
            for (int coluna = 0; coluna <= 9; coluna++) {

                Label label = new Label();
                label.setPrefHeight(25);
                label.setPrefWidth(25);
                label.setLineSpacing(1);
                label.setLayoutX(x);
                label.setLayoutY(y);
                label.setStyle("-fx-border-color:#F19CA2;");
                anchorPane.getChildren().addAll(label);

                matriz[linha][coluna] = label;

                x = x + 25;
            }
            y = y + 25;
            x = 25;
        }
    }

}
