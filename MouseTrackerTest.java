// Fig. 11.29: MouseTrackerFrame.java
// Testando MouseTrackerFrame.
import javax.swing.JFrame;

public class MouseTrackerTest 
{
   public static void main( String args[] )
   { 
	   MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame(); 
	      mouseTrackerFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	      mouseTrackerFrame.setSize( 300, 100 ); // configura o tamanho do frame 
	      mouseTrackerFrame.setVisible( true ); // exibe o frame
   } // fim de main
} // fim da classe MouseTracker