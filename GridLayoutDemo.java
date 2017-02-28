// Fig. 11.44: GridLayoutDemo.java
// Testando GridLayoutFrame.
import javax.swing.JFrame;

public class GridLayoutDemo 
{
   public static void main( String args[] )
   { 
      GridLayoutFrame gridLayoutFrame = new GridLayoutFrame(); 
	      gridLayoutFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	      gridLayoutFrame.setSize( 300, 200 ); // configura o tamanho do frame
	      gridLayoutFrame.setVisible( true ); // exibe o frame
	   } // fim de main
} // fim da classe GridLayoutDemo