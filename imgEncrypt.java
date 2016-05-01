import javafx.scene.*;
import java.util.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.util.*;
import java.io.*;
import javax.imageio.*;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon; 
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster; 
import java.nio.*; 
import javafx.embed.swing.SwingFXUtils; 
public class imgEncrypt extends Application {
public static String FILE = "fast.png";
public static HashMap<Object, Object> BUFFER = new HashMap<>();
public static ImageView before = new ImageView(FILE);
public static ImageView after = new ImageView(FILE);
public static void main(String[] args) throws Exception { launch(args); }
@Override public void start(final Stage stage) throws Exception {        
    HBox hb = new HBox(4);
    HBox hb1 = new HBox(4);
    VBox vb = new VBox(4);
    Button go = new Button("Go!");
    Button loader = new Button("reload image");
    ComboBox cb1 = new ComboBox();
    cb1.getItems().addAll("Diffie-Hellman", "RSA");
    
    ComboBox cb2 = new ComboBox();
    cb2.getItems().addAll("DES encrypt","DES decrypt","VEA encrypt",
            "VEA decrypt","polynomial encrypt", "polynomial decrypt");
    
    TextField filepath = new TextField(FILE);
    Slider roundslider = new Slider();
    
    roundslider.setMin(0);
    roundslider.setMax(16);
    roundslider.setMinorTickCount(2);
    roundslider.setMajorTickUnit(8);
    roundslider.setShowTickLabels(true);
    roundslider.setBlockIncrement(1);
    roundslider.setShowTickMarks(true);
    
    hb.getChildren().addAll(before,after);
    hb1.getChildren().addAll(cb1,cb2,filepath,roundslider,loader,go);
    
    vb.getChildren().addAll(hb,hb1);
    
    Scene scene1 = new Scene(vb, 700, 725, Color.ALICEBLUE);
    stage.setTitle("IMAGE ENCRYPTION SECURITY");
    stage.setScene(scene1);
    stage.show();
    
    go.setOnAction(e -> {
    byte[] unencrypted = imgTobyteArray(FILE);
    Image IMG = new Image(FILE);
    //setIV
    byte[] output = DES.encryptCBC(unencrypted,unencrypted);
    }
    );
    /*
    Scene scene1 = new Scene(vb, 700, 725, Color.ALICEBLUE);
    stage.setTitle("IMAGE ENCRYPTION SECURITY");
    stage.setScene(scene1);
    stage.show();
    */
}
public static void doEverything(String exchange, String encryption, String filename, String keyname){
    byte[] unencrypted = imgTobyteArray(filename);
    byte[] key = imgTobyteArray(keyname);
    if(exchange.equals("DH")){
    
    }
    else if(exchange.equals("RSA")){
    
    
    }
    if(encryption.equals("DES ENCRYPT")){
        byte[] encrypted = DES.encryptCBC(unencrypted,key);
    }
    else if(encryption.equals("DES DECRYPT")){
        byte[] encrypted = DES.decryptCBC(unencrypted,key);
    }
    else if(encryption.equals("VEA ENCRYPT")){
    
    
    }
    else if(encryption.equals("VEA DECRYPT")){
    
    
    }
    else if(encryption.equals("POLYNOMIAL ENCRYPT")){
    
    
    }
    else if(encryption.equals("POLYNOMIAL DECRYPT")){
    

    }


}

public static byte[] imgTobyteArray(String filename){
    try{
    FileInputStream fis = new FileInputStream(new File(filename));
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    byte[] buf = new byte[1024];
    try{
    for(int i; (i = fis.read(buf)) != -1;)
        bos.write(buf,0,i);   
    }
    catch(IOException e){e.printStackTrace();}
    return bos.toByteArray();
    }
    catch(FileNotFoundException ex){}
    return new byte[1024];
}

}
