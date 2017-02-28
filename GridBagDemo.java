// Fig. 22.22: GridBagDemo.java
// Demonstrando GridBagLayout.
import javax.swing.JFrame;

public class GridBagDemo
{ 
   public static void main( String args[] )
   { 
      GridBagFrame gridBagFrame = new GridBagFrame(); 
      gridBagFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      gridBagFrame.setSize( 300, 150 ); // configura tamanho
      gridBagFrame.setVisible( true ); // exibe o frame
   } // fim de main
} // fim da classe GridBagDemo
