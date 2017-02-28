// Fig. 11.35: Painter.java
// Testando PaintPanel.
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Painter
{
   public static void main( String args[] )
   { 
      // cria JFrame
      JFrame application = new JFrame( "A simple paint program" );

      PaintPanel paintPanel = new PaintPanel(); // cria o painel de pintura
      application.add( paintPanel, BorderLayout.CENTER ); // no centro

      // cria um rótulo e o coloca em SOUTH de BorderLayout
      application.add( new JLabel( "Drag the mouse to draw" ), 
         BorderLayout.SOUTH );

      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      application.setSize( 400, 200 ); // configura o tamanho do frame
      application.setVisible( true ); // exibe o frame
   } // fim de main
} // fim da classe Painter
