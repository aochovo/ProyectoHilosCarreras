
import javafx.concurrent.Task;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex
 */
class MiTarea extends Task{

    @Override
    protected Object call() throws Exception {
        double t=Math.random()*16;
        int n=(int)t;
        
        for (int i = n; i <= 100; i++) {
         double t2=Math.random()*51;
         int dormilon=(int)t2;
          Thread.sleep(dormilon);
          updateProgress(i, 100);
        }
        return null;
    }
    
}

