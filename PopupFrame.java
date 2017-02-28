
// Fig. 22.7: PopupFrame.java
// Demonstrando JPopupMenus.
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.ButtonGroup;

public class PopupFrame extends JFrame {
	private JRadioButtonMenuItem items[]; // armazena itens para cores
	private final Color colorValues[] = { Color.BLUE, Color.YELLOW, Color.RED }; // cores
																					// a
																					// serem
																					// utilizadas
	private JPopupMenu popupMenu; // permite ao usuário selecionar cores

	// construtor sem argumentos configura a GUI
	public PopupFrame() {
		super("Using JPopupMenus");

		ItemHandler handler = new ItemHandler(); // handler para itens de menu
		String colors[] = { "Blue", "Yellow", "Red" }; // array de cores

		ButtonGroup colorGroup = new ButtonGroup(); // gerencia itens de cores
		popupMenu = new JPopupMenu(); // cria menu pop-up
		items = new JRadioButtonMenuItem[3]; // itens para selecionar cor

		// constrói item de menu, adiciona menu popup, ativa tratamento de
		// evento
		for (int count = 0; count < items.length; count++) {
			items[count] = new JRadioButtonMenuItem(colors[count]);
			popupMenu.add(items[count]); // adiciona item ao menum pop-up
			colorGroup.add(items[count]); // adiciona item ao grupo de botão
			items[count].addActionListener(handler); // adiciona handler
		} // fim do for

		setBackground(Color.WHITE); // configura fundo como branco

		// declara um MouseListener para a janela exibir menu pop-up
		addMouseListener(

				new MouseAdapter() // classe interna anõnima
				{
					// trata evento de pressionamento de mouse
					public void mousePressed(MouseEvent event) {
						checkForTriggerEvent(event); // verifica o acionamento
					} // fim do método mousePressed

					// trata eventos de liberação de botão do mouse
					public void mouseReleased(MouseEvent event) {
						checkForTriggerEvent(event); // verifica acionamento
					} // fim do método mouseReleased

					// determina se o evento deve acionar menu popup
					private void checkForTriggerEvent(MouseEvent event) {
						if (event.isPopupTrigger())
							popupMenu.show(event.getComponent(), event.getX(), event.getY());
					} // fim do método checkForTriggerEvent
				} // fim da classe interna anônima
		); // fim da chamada para addMouseListener
	} // fim do construtor PopupFrame
		// classe interna privada para tratar eventos de item de menu

	private class ItemHandler implements ActionListener {
		// processa seleções de item de menu
		public void actionPerformed(ActionEvent event) {
			// determina qual item de menu foi selecionado
			for (int i = 0; i < items.length; i++) {
				if (event.getSource() == items[i]) {
					getContentPane().setBackground(colorValues[i]);
					return;
				} // fim do if
			} // fim do for
		} // fim do método actionPerformed
	} // fim da classe interna privada ItemHandler
} // fim da classe PopupFrame
