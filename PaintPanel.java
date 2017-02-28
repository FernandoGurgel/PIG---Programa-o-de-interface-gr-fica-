// Fig. 11.34: PaintPanel.java
// Utilizando class MouseMotionAdapter.
import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

public class PaintPanel extends JPanel 
{
   private int pointCount = 0; // número de contagem de pontos

   // array de 10000 referências java.awt.Point
   private Point points[] = new Point[ 10000000 ];

   // configura a GUI e registra handler de evento de mouse
   public PaintPanel()
   {
      // trata evento de movimento de mouse do frame
      addMouseMotionListener(

         new MouseMotionAdapter() // classe interna anônima
         {  
            // armazena coordenadas de arrastar e repinta                       
            public void mouseDragged( MouseEvent event )                
            {                                                           
               if ( pointCount < points.length )                        
               {                                                        
                  points[ pointCount ] = event.getPoint(); // localiza ponto
                  pointCount++; // número de increment de pontos no array  
                  repaint(); // repinta JFrame                          
               } // fim de if                                              
            } // fim do método mouseDragged                                
         } // fim da classe interna anônima                                
      ); // fim da chamada para addMouseMotionListener
   } // fim do construtor PaintPanel

   // desenha oval em um quadro delimitador de 4x4 no local especificado na janela
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g ); // limpa a área de desenho 

      // desenha todos os pontos no array
      for ( int i = 0; i < pointCount; i++ )
         g.fillOval( points[ i ].x, points[ i ].y, 4, 4 );
   } // fim do método paintComponent
} // fim da classe PaintPanel
