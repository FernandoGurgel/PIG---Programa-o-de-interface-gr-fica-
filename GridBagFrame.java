// Fig. 22.21: GridBagFrame.java
// Demonstrando GridBagLayout.
import java.awt.GridBagLayout;     
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class GridBagFrame extends JFrame 
{ 
   private GridBagLayout layout; // layout desse frame                
   private GridBagConstraints constraints; // restrições desse layout
    
   // configura a GUI
   public GridBagFrame()
   {
      super( "GridBagLayout" );
      layout = new GridBagLayout();                                     
      setLayout( layout ); // configura o layout de frame                         
      constraints = new GridBagConstraints(); // instancia restrições

      // cria componentes GUI
      JTextArea textArea1 = new JTextArea( "TextArea1", 5, 10 );
      JTextArea textArea2 = new JTextArea( "TextArea2", 2, 2 );

      String names[] = { "Iron", "Steel", "Brass" };
      JComboBox comboBox = new JComboBox( names );

      JTextField textField = new JTextField( "TextField" );
      JButton button1 = new JButton( "Button 1" );
      JButton button2 = new JButton( "Button 2" );
      JButton button3 = new JButton( "Button 3" );

      // weightx e weighty para textArea1 são 0: o padrão
      // anchor para todos os componentes CENTER: o padrão
      constraints.fill = GridBagConstraints.BOTH;
      addComponent( textArea1, 0, 0, 1, 3 );     
       
      // weightx e weighty para button1 são 0: o padrão
      constraints.fill = GridBagConstraints.HORIZONTAL;
      addComponent( button1, 0, 1, 2, 1 );             
      
      // weightx e weighty para comboBox são 0: o padrão
      // fill é HORIZONTAL
      addComponent( comboBox, 2, 1, 2, 1 );

      // button2
      constraints.weightx = 1000;  // pode crescer na largura
      constraints.weighty = 1;     // pode crescer na altura
      constraints.fill = GridBagConstraints.BOTH;    
      addComponent( button2, 1, 1, 1, 1 );           
       
      // preenchimento é BOTH para button3
      constraints.weightx = 0;            
      constraints.weighty = 0;            
      addComponent( button3, 1, 2, 1, 1 );
       
      // weightx e weighty para textField são 0, preenchimento é BOTH
      addComponent( textField, 3, 0, 2, 1 );

      // weightx e weighty para textArea2 são 0, preenchimento é BOTH
      addComponent( textArea2, 3, 2, 1, 1 );
   } // fim do construtor GridBagFrame

   // método no qual configurar as restrições 
   private void addComponent( Component component,
      int row, int column, int width, int height )
   {
      constraints.gridx = column; // configura gridx                           
      constraints.gridy = row; // configura gridy                              
      constraints.gridwidth = width; // configura gridwidth                    
      constraints.gridheight = height; // configura gridheight                 
      layout.setConstraints( component, constraints ); // configura constraints
      add( component ); // adiciona component                                 
   } // fim do método addComponent
} // fim da classe GridBagFrame
