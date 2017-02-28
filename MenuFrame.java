// Fig. 22.5: MenuFrame.java
// Demonstrando menus.
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;   
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;    
import javax.swing.JMenuItem;
import javax.swing.JMenuBar; 

public class MenuFrame extends JFrame 
{
   private final Color colorValues[] = 
      { Color.BLACK, Color.BLUE, Color.RED, Color.GREEN };   
   private JRadioButtonMenuItem colorItems[]; // itens do menu Color  
   private JRadioButtonMenuItem fonts[]; // itens do menu Font        
   private JCheckBoxMenuItem styleItems[]; // itens do menu Font Style
   private JLabel displayJLabel; // exibe o texto de exemplo
   private ButtonGroup fontButtonGroup; // gerencia itens do menu Font
   private ButtonGroup colorButtonGroup; // gerencia itens do menu Color
   private int style; // utilizado para criar estilo para fonte

   // construtor sem argumentos configura a GUI
   public MenuFrame()
   {
      super( "Using JMenus" );     

      JMenu fileMenu = new JMenu( "File" ); // cria o menu File
      fileMenu.setMnemonic( 'F' ); // configura o mnemônico como F        

      // create About... menu item
      JMenuItem aboutItem = new JMenuItem( "About..." );       
      aboutItem.setMnemonic( 'A' ); // configura o mnemônico como A       
      fileMenu.add( aboutItem ); // adiciona o item about ao menu File
      aboutItem.addActionListener(

         new ActionListener() // classe interna anônima
         {  
            // exibe um diálogo de mensagem quando o usuário seleciona About...
            public void actionPerformed( ActionEvent event )
            {
               JOptionPane.showMessageDialog( MenuFrame.this,
                  "This is an example\nof using menus",
                  "About", JOptionPane.PLAIN_MESSAGE );
            } // fim do método actionPerformed
         } // fim da classe interna anônima
      ); // fim da chamada para addActionListener
 
      JMenuItem exitItem = new JMenuItem( "Exit" ); // cria o item exit
      exitItem.setMnemonic( 'x' ); // configura o mnemônico como x                
      fileMenu.add( exitItem ); // adiciona o item exit ao menu File          
      exitItem.addActionListener(

         new ActionListener() // classe interna anônima
         {  
            // termina o aplicativo quando o usuário clicar em exitItem
            public void actionPerformed( ActionEvent event )
            {
               System.exit( 0 ); // encerra o aplicativo
            } // fim do método actionPerformed
         } // fim da classe interna anônima
      ); // fim da chamada para addActionListener

      JMenuBar bar = new JMenuBar(); // cria a barra de menu 
      setJMenuBar( bar ); // adiciona a barra de menu ao aplicativo
      bar.add( fileMenu ); // adiciona o menu File à barra de menu 

      JMenu formatMenu = new JMenu( "Format" ); // cria o menu Format
      formatMenu.setMnemonic( 'r' ); // configura mnemônico como r            

      // array listando cores de string
      String colors[] = { "Black", "Blue", "Red", "Green" };

      JMenu colorMenu = new JMenu( "Color" ); // cria o menu Color
      colorMenu.setMnemonic( 'C' ); // configura mnemônico C          

      // cria itens do menu Color com botões de opção
      colorItems = new JRadioButtonMenuItem[ colors.length ];
      colorButtonGroup = new ButtonGroup(); // gerencia cores
      ItemHandler itemHandler = new ItemHandler(); // handler para cores

      // cria itens do menu Color com botões de opção
      for ( int count = 0; count < colors.length; count++ ) 
      {
         colorItems[ count ] =                                          
            new JRadioButtonMenuItem( colors[ count ] ); // cria o item 
         colorMenu.add( colorItems[ count ] ); // adiciona o item ao menu Color
         colorButtonGroup.add( colorItems[ count ] ); // adiciona ao grupo   
    colorItems[ count ].addActionListener( itemHandler );
      } // fim de for

      colorItems[ 0 ].setSelected( true ); // seleciona primeiro item Color

      formatMenu.add( colorMenu ); // adiciona o menu Color ao menu Format
      formatMenu.addSeparator(); // adiciona o separador no menu          

      // array listing font names
      String fontNames[] = { "Serif", "Monospaced", "SansSerif" };
      JMenu fontMenu = new JMenu( "Font" ); // cria o menu Font
      fontMenu.setMnemonic( 'n' ); // configura o mnemônico como n        

      // cria itens do menu radiobutton para nomes de fonte
      fonts = new JRadioButtonMenuItem[ fontNames.length ];     
      fontButtonGroup = new ButtonGroup(); // gerencia nomes de fonte

      // cria itens do menu Font com botões de opção
      for ( int count = 0; count < fonts.length; count++ ) 
      {
         fonts[ count ] = new JRadioButtonMenuItem( fontNames[ count ] );
         fontMenu.add( fonts[ count ] ); // adiciona fonte ao menu Font        
         fontButtonGroup.add( fonts[ count ] ); // adiciona ao grupo de botão   
         fonts[ count ].addActionListener( itemHandler ); // adiciona handler
      } // fim do for

      fonts[ 0 ].setSelected( true ); // seleciona primeiro item de menu Font
      fontMenu.addSeparator(); // adiciona barra separador ao menu Font    

      String styleNames[] = { "Bold", "Italic" }; // nomes de estilos
      styleItems = new JCheckBoxMenuItem[ styleNames.length ];
      StyleHandler styleHandler = new StyleHandler(); // handler de estilos

      // criar itens do menu Style com caixas de seleção
      for ( int count = 0; count < styleNames.length; count++ ) 
      {
         styleItems[ count ] =                                        
            new JCheckBoxMenuItem( styleNames[ count ] ); // para estilo
         fontMenu.add( styleItems[ count ] ); // adicina ao menu Font     
         styleItems[ count ].addItemListener( styleHandler ); // handler
      } // fim do for

      formatMenu.add( fontMenu ); // adiciona menu Font ao menu Format
      bar.add( formatMenu ); // adiciona menu Format à barra de menu      
     
      // set up label to display text
      displayJLabel = new JLabel( "Sample Text", SwingConstants.CENTER );
      displayJLabel.setForeground( colorValues[ 0 ] );
      displayJLabel.setFont( new Font( "Serif", Font.PLAIN, 72 ) );

      getContentPane().setBackground( Color.CYAN ); // configura o fundo
      add( displayJLabel, BorderLayout.CENTER ); // adiciona displayJLabel
   } // fim de construtor MenuFrame

   // classe interna para tratar eventos de ação dos itens de menu
   private class ItemHandler implements ActionListener 
   {
      // processa seleções de cor e fonte
      public void actionPerformed( ActionEvent event )
      {
         // processa seleções de cor
         for ( int count = 0; count < colorItems.length; count++ )
         {
            if ( colorItems[ count ].isSelected() ) 
            {
               displayJLabel.setForeground( colorValues[ count ] );
               break;
            } // fim do if
         } // fim do for

         // processa seleção de fonte
         for ( int count = 0; count < fonts.length; count++ )
         {
            if ( event.getSource() == fonts[ count ] ) 
            {
               displayJLabel.setFont( 
                  new Font( fonts[ count ].getText(), style, 72 ) );
            } // fim do if
         } // fim do for

         repaint(); // desenha novamente o aplicativo
      } // fim do método actionPerformed
   } // fim da classe ItemHandler

   // classe interna para tratar eventos dos itens de menu com caixa de seleção
   private class StyleHandler implements ItemListener 
   {
      // processa seleções de estilo da fonte
      public void itemStateChanged( ItemEvent e )
      {
         style = 0; // inicializa estilo

         // verifica seleção de negrito
         if ( styleItems[ 0 ].isSelected() )
            style += Font.BOLD; // adiciona negrito ao estilo

         // verifica seleção de itálico
         if ( styleItems[ 1 ].isSelected() )
            style += Font.ITALIC; // adiciona itálico ao estilo

         displayJLabel.setFont( 
            new Font( displayJLabel.getFont().getName(), style, 72 ) );
         repaint(); // desenha novamente o aplicativo
      } // fim do método itemStateChanged
   } // fim da classe StyleHandler
} // fim da classe MenuFrame
