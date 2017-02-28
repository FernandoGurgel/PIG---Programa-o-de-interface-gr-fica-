
// Fig. 11.28: MouseTrackerFrame.java
// Demonstrando eventos de mouse.
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseTrackerFrame extends JFrame {
	private JPanel mousePanel; // painel em que eventos de mouse ocorrerão
	private JLabel statusBar; // rótulo que exibe informações sobre evento

	// construtor MouseTrackerFrame configura GUI e
	// registra handlers de evento de mouse
	public MouseTrackerFrame() {
		super("Demonstrating Mouse Events");

		mousePanel = new JPanel(); // cria painel
		mousePanel.setBackground(Color.WHITE); // configura cor de fundo
		add(mousePanel, BorderLayout.CENTER); // adiciona painel ao JFrame

		statusBar = new JLabel("Mouse outside JPanel");
		add(statusBar, BorderLayout.SOUTH); // adiciona rótulo ao JFrame

		// cria e registra listener para mouse e eventos de movimento de mouse
		MouseHandler handler = new MouseHandler();
		mousePanel.addMouseListener(handler);
		mousePanel.addMouseMotionListener(handler);
	} // fim do construtor MouseTrackerFrame

	private class MouseHandler implements MouseListener, MouseMotionListener {
		// handlers de evento MouseListener
		// trata evento quando o mouse é liberado logo depois de pressionado
		public void mouseClicked(MouseEvent event) {
			statusBar.setText(String.format("Clicked at [%d, %d]", event.getX(), event.getY()));
		} // fim do método mouseClicked

		// trata evento quando mouse é pressionado
		public void mousePressed(MouseEvent event) {
			statusBar.setText(String.format("Pressed at [%d, %d]", event.getX(), event.getY()));
		} // fim do método mousePressed

		// trata evento quando mouse é liberado depois da operação de arrastar
		public void mouseReleased(MouseEvent event) {
			statusBar.setText(String.format("Released at [%d, %d]", event.getX(), event.getY()));
		} // fim do método mouseReleased

		// trata evento quando mouse entra na área
		public void mouseEntered(MouseEvent event) {
			statusBar.setText(String.format("Mouse entered at [%d, %d]", event.getX(), event.getY()));
			mousePanel.setBackground(Color.GREEN);
		} // fim do método mouseEntered

		// trata evento quando mouse sai da área
		public void mouseExited(MouseEvent event) {
			statusBar.setText("Mouse outside JPanel");
			mousePanel.setBackground(Color.WHITE);
		} // fim do método mouseExited

		// MouseMotionListener event handlers
		// trata evento MouseMotionListener
		public void mouseDragged(MouseEvent event) {
			statusBar.setText(String.format("Dragged at [%d, %d]", event.getX(), event.getY()));
		} // fim do método mouseDragged

		// trata evento quanto usuário move o mouse
		public void mouseMoved(MouseEvent event) {
			statusBar.setText(String.format("Moved at [%d, %d]", event.getX(), event.getY()));
		} // fim do método mouseMoved
	} // fim da classe MouseHandler interna
} // fim da classe MouseTrackerFrame
