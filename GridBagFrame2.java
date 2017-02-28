// Fig. 22.23: GridBagFrame2.java
// Demonstrando as constantes GridBagLayout.
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;

public class GridBagFrame2 extends JFrame 
{ 
   private GridBagLayout layout; // layout desse frame
   private GridBagConstraints constraints; // restrições desse layout
    
   // configura a GUI
   public GridBagFrame2()
   {
      super( "GridBagLayout" );
      layout = new GridBagLayout();           
      setLayout( layout ); // configura layout do frame
      constraints = new GridBagConstraints(); // instancia restrições

      // cria componentes da GUI
      String metals[] = { "Copper", "Aluminum", "Silver" };
      JComboBox comboBox = new JComboBox( metals );

      JTextField textField = new JTextField( "TextField" );

      String fonts[] = { "Serif", "Monospaced" };
      JList list = new JList( fonts );

      String names[] = { "zero", "one", "two", "three", "four" };
      JButton buttons[] = new JButton[ names.length ];

      for ( int count = 0; count < buttons.length; count++ )
         buttons[ count ] = new JButton( names[ count ] );

      // define define restrições dos componentes GUI para textField
      constraints.weightx = 1;                             
      constraints.weighty = 1;                             
      constraints.fill = GridBagConstraints.BOTH;          
      constraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( textField );                           

      // buttons[0] -- weightx e weighty são 1: fill é BOTH
      constraints.gridwidth = 1;   
      addComponent( buttons[ 0 ] );

      // buttons[1] -- weightx e weighty são 1: fill é BOTH
      constraints.gridwidth = GridBagConstraints.RELATIVE;
      addComponent( buttons[ 1 ] );                       

      // buttons[2] -- weightx e weighty são 1: fill é BOTH
      constraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( buttons[ 2 ] );                        

      // comboBox -- weightx é 1: fill é BOTH
      constraints.weighty = 0;                             
      constraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( comboBox );                            
      
      // buttons[3] -- weightx é 1: fill é BOTH
      constraints.weighty = 1;                             
      constraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( buttons[ 3 ] );                        

      // buttons[4] -- weightx e weighty são 1: fill é BOTH
      constraints.gridwidth = GridBagConstraints.RELATIVE;
      addComponent( buttons[ 4 ] );                       

      // list -- weightx e weighty são 1: fill é BOTH
      constraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( list );                                
   } // fim do construtor GridBagFrame2

   // adiciona um componente ao contêiner
   private void addComponent( Component component ) 
   {
      layout.setConstraints( component, constraints );
      add( component ); // adiciona componente              
   } // fim do método addComponent
} // fim da classe GridBagFrame2
