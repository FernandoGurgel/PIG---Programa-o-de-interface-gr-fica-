// Fig. 11.10: TextFieldTest.java
// Testando TextFieldFrame.
import javax.swing.JFrame;

public class TextFieldTest
{
   public static void main( String args[] )
   { 
      TextFieldFrame textFieldFrame = new TextFieldFrame();
      textFieldFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      textFieldFrame.setSize( 325, 100 ); // configura tamanho do frame
      textFieldFrame.setVisible( true ); // exibe o frame
   } // fim de main
} // fim da classe TextFieldTest
