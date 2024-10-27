package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setBackground(new Color(64, 0, 128));
		setFont(new Font("Cambria Math", Font.BOLD, 12));
		setType(Type.POPUP);
		setTitle("Sistema De Ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 521);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(20, 20, 20, 20));
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("Mantenimiento");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Clientes");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        VentanaPrincipal.this.setVisible(false); // O utiliza 'VentanaPrincipal.this' para mayor claridad
				MantenimientoClientesVERSION3 mancli = new MantenimientoClientesVERSION3();
                mancli.setVisible(true);
                
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Productos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal.this.setVisible(false); // O utiliza 'VentanaPrincipal.this' para mayor claridad
				MantenimientoProductos manprod = new MantenimientoProductos();
                manprod.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnVentas = new JMenu("Ventas");
		mnVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		menuBar.add(mnVentas);
		
		JMenuItem mnItemVentas = new JMenuItem("Abrir Ventas");
		mnItemVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal.this.setVisible(false); // O utiliza 'VentanaPrincipal.this' para mayor claridad
				VentasGUI ventas = new VentasGUI();
                ventas.setVisible(true);
			}
		});
		mnVentas.add(mnItemVentas);
		
		JMenu mnNewMenu_2 = new JMenu("Almac\u00E9n");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Abrir Almacen");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal.this.setVisible(false); // O utiliza 'VentanaPrincipal.this' para mayor claridad
				Almacen ventas = new Almacen();
                ventas.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("Reportes");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Abrir Reportes");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal.this.setVisible(false); // O utiliza 'VentanaPrincipal.this' para mayor claridad
				Reportes ventas = new Reportes();
                ventas.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(122, 160, 239));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
