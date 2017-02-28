
// Fig. 11.19: RadioButtonFrame.java
// Criando botões de opção utilizando ButtonGroup e JRadioButton.
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class RadioButtonFrame extends JFrame implements ItemListener {
	private static final long serialVersionUID = 1L;
	private JTextField textField; // usado para exibir alterações de fonte
	private Font plainFont; // fonte para texto simples
	private Font boldFont; // fonte para texto negrito
	private Font italicFont; // fonte para texto itálico
	private Font boldItalicFont; // fonte para texto negrito e itálico
	private JRadioButton plainJRadioButton; // seleciona texto simples
	private JRadioButton boldJRadioButton; // seleciona texto negrito
	private JRadioButton italicJRadioButton; // seleciona texto itálico
	private JRadioButton boldItalicJRadioButton; // negrito e itálico
	private ButtonGroup radioGroup; // buttongroup para armazenar botões de
									// opção

	// construtor RadioButtonFrame adiciona JRadioButtons ao JFrame
	public RadioButtonFrame() {
		super("RadioButton Test");
		setLayout(new FlowLayout()); // configura layout do frame

		textField = new JTextField("Watch the font style change", 25);
		add(textField); // adiciona textField ao JFrame

		// cria botões de opção
		plainJRadioButton = new JRadioButton("Plain", true);
		boldJRadioButton = new JRadioButton("Bold", false);
		italicJRadioButton = new JRadioButton("Italic", false);
		boldItalicJRadioButton = new JRadioButton("Bold/Italic", false);
		add(plainJRadioButton); // adiciona botão simples ao JFrame
		add(boldJRadioButton); // adiciona botão de negrito ao JFrame
		add(italicJRadioButton); // adiciona botão de itálico ao JFrame
		add(boldItalicJRadioButton); // adiciona botão de itálico e negrito

		// cria relacionamento lógico entre JRadioButtons
		radioGroup = new ButtonGroup(); // cria ButtonGroup
		radioGroup.add(plainJRadioButton); // adiciona simples ao grupo
		radioGroup.add(boldJRadioButton); // adiciona negrito ao grupo
		radioGroup.add(italicJRadioButton); // adiciona itálico ao grupo
		radioGroup.add(boldItalicJRadioButton); // adiciona negrito e itálico

		// cria objetos de fonte

		// registra eventos para JRadioButtons
		plainJRadioButton.addItemListener(this);
		boldJRadioButton.addItemListener(this);
		italicJRadioButton.addItemListener(this);
		boldItalicJRadioButton.addItemListener(this);
	} // fim do construtor RadioButtonFrame

	// classe interna private para tratar eventos de botão de opção
	/*
	 * private class RadioButtonHandler implements ItemListener { private Font
	 * font; // fonte associada com esse listener
	 * 
	 * public RadioButtonHandler( Font f ) { font = f; // configura a fonte
	 * desse listener } // fim do construtor RadioButtonHandler
	 * 
	 * // trata eventos de botão de opção public void itemStateChanged(
	 * ItemEvent event ) { textField.setFont( font ); // configura fonte de
	 * textField } // fim do método itemStateChanged } // fim da classe
	 * RadioButtonHandler interna private
	 */
	

	@Override
	public void itemStateChanged(ItemEvent event) {
		plainFont = new Font("Serif", Font.PLAIN, 14);
		boldFont = new Font("Serif", Font.BOLD, 14);
		italicFont = new Font("Serif", Font.ITALIC, 14);
		boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
		
		textField.setFont(plainFont); // configura fonte inicial à simples
		if (event.getSource() == plainJRadioButton) {
			textField.setFont(plainFont);
		} else if (event.getSource() == boldJRadioButton) {
			textField.setFont(boldFont);
		} else if ( event.getSource() == italicJRadioButton ){
			textField.setFont(italicFont);
		}else{
			textField.setFont(boldItalicFont);
		}
		// configura fonte de textField

	}

} // fim da classe RadioButtonFrame
