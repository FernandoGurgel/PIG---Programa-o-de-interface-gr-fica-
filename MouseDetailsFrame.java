
// Fig. 11.31: MouseDetailsFrame.java
// Demonstrando cliques de mouse e distinguindo entre botões do mouse.
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseDetailsFrame extends JFrame {
	private String details; // representação String
	private JLabel statusBar; // JLabel que aparece no botão de janela

	// construtor configura barra de título String e registra o listener de
	// mouse
	public MouseDetailsFrame() {
		super("Mouse clicks and buttons");

		statusBar = new JLabel("Click the mouse");
		add(statusBar, BorderLayout.SOUTH);
		addMouseListener(new MouseClickHandler()); // adiciona handler
	} // fim do construtor MouseDetailsFrame

	// classe interna para tratar eventos de mouse
	private class MouseClickHandler extends MouseAdapter {
		// trata evento de clique de mouse e determina qual botão foi
		// pressionado
		public void mouseClicked(MouseEvent event) {
			int xPos = event.getX(); // obtém posição x do mouse
			int yPos = event.getY(); // obtém posição y do mouse

			details = String.format("Clicked %d time(s)", event.getClickCount());

			if (event.isMetaDown()) // botão direito do mouse
				details += " with right mouse button";
			else if (event.isAltDown()) // botão do meio do mouse
				details += " with center mouse button";
			else // botão esquerdo do mouse
				details += " with left mouse button";

			statusBar.setText(details); // exibe mensagem na statusBar
		} // fim do método mouseClicked
	} // fim da classe interna private MouseClickHandler
} // fim da classe MouseDetailsFrame