// Fig. 22.24: GridBagDemo2.java
// Demonstrando constantes do GridBagLayout.
import javax.swing.JFrame;

public class GridBagDemo2
{ 
   public static void main( String args[] )
   { 
      GridBagFrame2 gridBagFrame = new GridBagFrame2();  
      gridBagFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      gridBagFrame.setSize( 300, 200 ); // configura o tamanho do frame
      gridBagFrame.setVisible( true ); // exibe o frame
   } // fim do main
} // fim da classe GridBagDemo2
