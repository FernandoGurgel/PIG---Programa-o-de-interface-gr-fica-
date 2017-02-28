// Fig. 11.7: LabelTest.java
// Testando LabelFrame.
import javax.swing.JFrame;

public class LabelTest
{
   public static void main( String args[] )
   { 
      LabelFrame labelFrame = new LabelFrame(); // cria LabelFrame
      labelFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      labelFrame.setSize( 275, 180 ); // configura tamanho do frame
     labelFrame.setVisible( true ); // exibe frame
   } // fim de main
} // fim da classe LabelTest