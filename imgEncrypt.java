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
    cb2.getItems().addAll("DES encrypt","DES decrypt","VEA encrypt","VEA decrypt","isweartherewasonemore");
    
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
    for(int i = (int)(unencrypted.length/1.0 - 19); i < unencrypted.length;i++){
        unencrypted[i]*=-1;
        System.out.println("a");
    }
  //  after.setImage(byteArrayToImg(unencrypted,(int)IMG.getWidth(),(int)IMG.getHeight()));
    });
    /*
    Scene scene1 = new Scene(vb, 700, 725, Color.ALICEBLUE);
    stage.setTitle("IMAGE ENCRYPTION SECURITY");
    stage.setScene(scene1);
    stage.show();
    */
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
    return new byte[2014];
}
/*
public static Image byteArrayToImg(byte[] p, int width, int height){
    int[] pixels = new int[p.length];
    for(int i = 0; i < p.length; i++){
        Byte b = p[i];
        pixels[i] = b.intValue();
    }
    System.out.println("w:" + width + " h:" + height + " s:" + p.length);
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    WritableRaster raster = (WritableRaster) image.getData();
    raster.setPixels(0,0,40,40,pixels);
    //return image;
    WritableImage wr = null;
    wr = new WritableImage(image.getWidth(), image.getHeight());
    PixelWriter pw = wr.getPixelWriter();
    for(int x = 0; x < image.getWidth(); x++){
        for(int y = 0; y < image.getHeight(); y++){
            pw.setArgb(x, y, image.getRGB(x, y));
        }
    }
    return (Image)wr;
    //after = new ImageView(wr);
}*/
/*

public static void byteArrayToImg(byte[] bytes){
    try{
    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
    Iterator<?> readers = ImageIO.getImageReadersByFormatName("png");
    ImageReader reader = (ImageReader) readers.next();
    Object source = bis;
    ImageInputStream iis = ImageIO.createImageInputStream(source);
    reader.setInput(iis,true);
    ImageReadParam param = reader.getDefaultReadParam();
    BufferedImage image = reader.read(0,param);
    BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
    /*WritableImage wr = null;
    PixelWriter pw = wr.getPixelWriter();
    for(int x = 0; x < image.getWidth();x++){
        for(int y = 0; y < image.getHeight(); y++){
            pw.setArgb(x,y,bufferedImage.getRGB(x,y));
        }
    }
    
    after = new ImageView(SwingFXUtils.toFXImage(bufferedImage,null));
    //File outputfile = new File("FUCK_" + FILE);
    //ImageIO.write(bufferedImage, "png", outputfile);
    //return new Image(new File("FUCK_" + FILE));
    }catch(IOException e){e.printStackTrace();};
}
*/
}
