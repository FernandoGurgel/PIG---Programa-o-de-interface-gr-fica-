// Fig. 22.9: LookAndFeelFrame.java
// Alterando a aparência e comportamento.
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class LookAndFeelFrame extends JFrame 
{
   // nomes de string das aparências e comportamentos
   private final String strings[] = { "Metal", "Motif", "Windows" };
   private UIManager.LookAndFeelInfo looks[]; // aparência e comportamentos
   private JRadioButton radio[]; // botões de opção para selecionar a aparência e comportamento
   private ButtonGroup group; // grupo para botões de opção
   private JButton button; // exibe a aparência do botão
   private JLabel label; // exibe a aparência do rótulo
   private JComboBox comboBox; // exibe a aparência da caixa de combinação

   // configura a GUI
   public LookAndFeelFrame()
   {
      super( "Look and Feel Demo" );

      JPanel northPanel = new JPanel(); // cria o painel North
      northPanel.setLayout( new GridLayout( 3, 1, 0, 5 ) );

      label = new JLabel( "This is a Metal look-and-feel",
         SwingConstants.CENTER ); // cria o rótulo
      northPanel.add( label ); // adiciona o rótulo ao painel

      button = new JButton( "JButton" ); // cria o botão
      northPanel.add( button ); // adiciona o botão ao painel

      comboBox = new JComboBox( strings ); // cria a caixa de combinação
      northPanel.add( comboBox ); // adiciona a caixa de combinação ao painel
     
      // cria um array para botões de opção
      radio = new JRadioButton[ strings.length ];

      JPanel southPanel = new JPanel(); // cria o painel South
      southPanel.setLayout( new GridLayout( 1, radio.length ) );

      group = new ButtonGroup(); // grupo de botões para a aparência e comportamento
      ItemHandler handler = new ItemHandler(); // handler da aparência e comportamento

      for ( int count = 0; count < radio.length; count++ ) 
      {
         radio[ count ] = new JRadioButton( strings[ count ] );
         radio[ count ].addItemListener( handler ); // adiciona handler
         group.add( radio[ count ] ); // adiciona botões de opção ao grupo
         southPanel.add( radio[ count ] ); // adiciona botões de opção ao painel
      } // fim do for

      add( northPanel, BorderLayout.NORTH ); // adiciona o painel North
      add( southPanel, BorderLayout.SOUTH ); // adiciona o painel South

      // obtém as informações sobre a aparência e comportamento instaladas
      looks = UIManager.getInstalledLookAndFeels();
      radio[ 0 ].setSelected( true ); // configura a seleção padrão
   } // fim do construtor LookAndFeelFrame

   // utiliza UIManager para alterar a aparência e comportamento da GUI
   private void changeTheLookAndFeel( int value )
   {
      try // muda a aparência e comportamento
      {
         // configura a aparência e comportamento para esse aplicativo
         UIManager.setLookAndFeel( looks[ value ].getClassName() );

         // atualiza os componentes nesse aplicativo     
         SwingUtilities.updateComponentTreeUI( this );
      } // fim do try
      catch ( Exception exception ) 
      {
         exception.printStackTrace();
      } // fim do catch
   } // fim do método changeTheLookAndFeel

   // classe interna private para tratar eventos de botão de opção 
   private class ItemHandler implements ItemListener 
   {
      // processa a seleção de aparência e comportamento feita pelo usuário
      public void itemStateChanged( ItemEvent event )
      {
         for ( int count = 0; count < radio.length; count++ )
         {
            if ( radio[ count ].isSelected() ) 
            {
               label.setText( String.format( "This is a %s look-and-feel", 
                  strings[ count ] ) );
               comboBox.setSelectedIndex( count ); // configura o índice da caixa de combinação
               changeTheLookAndFeel( count ); // muda a aparência e comportamento
            } // fim do if
         } // fim do for
      } // fim do método itemStateChanged
   } // fim da classe interna private ItemHandler
} // fim da classe LookAndFeelFrame