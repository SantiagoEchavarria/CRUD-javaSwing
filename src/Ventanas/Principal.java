package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clases.Cola;
import Clases.Fecha;
import Clases.ManipulacionArchivos;
import Clases.Medicamento;
import Clases.Pila;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JTextField txtNombre;
	private JTextField txtComposicion;
	static String box= "Inventario";
	static Cola inventario = new Cola();
	static Pila historial = new Pila();
	static ManipulacionArchivos datos = new ManipulacionArchivos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					inventario=datos.actualizarCola("Inventario", inventario);
					historial=datos.actualizarPila("Historial");
					
					inventario.imprimirCola();
					historial.imprimirPila();
										
					Principal frame = new Principal();
					frame.setVisible(true);
					actualizarTabla();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(501, 11, 336, 401);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(135, 68, 191, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtComposicion = new JTextField();
		txtComposicion.setColumns(10);
		txtComposicion.setBounds(135, 151, 191, 20);
		panel.add(txtComposicion);
		
		
		
		
		
		JComboBox BoxPresentacion = new JComboBox();
		BoxPresentacion.setModel(new DefaultComboBoxModel(new String[] {"Comprimidos", "Grageas ", "C\u00E1psulas ", "Polvos  ", "P\u00EDldoras"}));
		BoxPresentacion.setBounds(137, 111, 189, 22);
		panel.add(BoxPresentacion);
		
		JComboBox BoxDiaCompra = new JComboBox();
		BoxDiaCompra.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		BoxDiaCompra.setBounds(135, 182, 47, 22);
		panel.add(BoxDiaCompra);
		
		JComboBox BoxMesCompra = new JComboBox();
		BoxMesCompra.setModel(new DefaultComboBoxModel(new String[] {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"}));
		BoxMesCompra.setBounds(192, 182, 75, 22);
		panel.add(BoxMesCompra);
		
		JComboBox BoxACompra = new JComboBox();
		BoxACompra.setModel(new DefaultComboBoxModel(new String[] {"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027"}));
		BoxACompra.setBounds(277, 182, 57, 22);
		panel.add(BoxACompra);
		
		JComboBox BoxDiaCompra_1 = new JComboBox();
		BoxDiaCompra_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		BoxDiaCompra_1.setBounds(135, 215, 47, 22);
		panel.add(BoxDiaCompra_1);
		
		JComboBox BoxMesCompra_1 = new JComboBox();
		BoxMesCompra_1.setModel(new DefaultComboBoxModel(new String[] {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"}));
		BoxMesCompra_1.setBounds(192, 215, 75, 22);
		panel.add(BoxMesCompra_1);
		
		JComboBox BoxACompra_1 = new JComboBox();
		BoxACompra_1.setModel(new DefaultComboBoxModel(new String[] {"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027"}));
		BoxACompra_1.setBounds(277, 215, 57, 22);
		panel.add(BoxACompra_1);
		
		JComboBox BoxCantidad = new JComboBox();
		BoxCantidad.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		BoxCantidad.setBounds(135, 252, 47, 22);
		panel.add(BoxCantidad);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(30, 71, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblPresentacion = new JLabel("Presentacion");
		lblPresentacion.setBounds(30, 115, 81, 14);
		panel.add(lblPresentacion);
		
		JLabel lblComposicion = new JLabel("Composicion");
		lblComposicion.setBounds(30, 154, 81, 14);
		panel.add(lblComposicion);
		
		JLabel lblFecha = new JLabel("Compra");
		lblFecha.setBounds(30, 186, 60, 14);
		panel.add(lblFecha);
		
		JLabel lblNewLabel_2 = new JLabel("Vencimiento");
		lblNewLabel_2.setBounds(30, 219, 71, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cantidad");
		lblNewLabel_2_1.setBounds(30, 256, 71, 14);
		panel.add(lblNewLabel_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 46, 481, 366);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					
					txtNombre.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
					BoxPresentacion.setSelectedItem(table.getValueAt(table.getSelectedRow(), 1).toString());
					txtComposicion.setText(table.getValueAt (table.getSelectedRow(), 2).toString());
					
					
					Fecha fechaCompra= new Fecha(table.getValueAt(table.getSelectedRow(), 3).toString());
				
					BoxDiaCompra.setSelectedItem(fechaCompra.obtenerDia());
					BoxMesCompra.setSelectedItem(fechaCompra.obtenerMes());
					BoxACompra.setSelectedItem(fechaCompra.obtenerAnio());
					
					Fecha fechaCompra2= new Fecha(table.getValueAt(table.getSelectedRow(), 4).toString());
					System.out.println("Ventaaaaaaaaa"+fechaCompra2.obtenerDia());
					
					BoxDiaCompra_1.setSelectedItem(fechaCompra2.obtenerDia());
					BoxMesCompra_1.setSelectedItem(fechaCompra2.obtenerMes());
					BoxACompra_1.setSelectedItem(fechaCompra2.obtenerAnio());
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Error");
				}
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Presentacion", "Composicion", "Compra", "Venta"
			}
		));
		
		scrollPane.setViewportView(table);
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String compra=BoxDiaCompra.getSelectedItem().toString()+"/"+BoxMesCompra.getSelectedItem().toString()+"/"+BoxACompra.getSelectedItem().toString();
				String venta=BoxDiaCompra_1.getSelectedItem().toString()+"/"+BoxMesCompra_1.getSelectedItem().toString()+"/"+BoxACompra_1.getSelectedItem().toString();
				
				inventario.encolar(txtNombre.getText(), BoxPresentacion.getSelectedItem().toString(), txtComposicion.getText(), 
								compra, venta, false);
				actualizarTabla();
				
			}
		});
		btnAgregar.setBounds(135, 315, 89, 23);
		panel.add(btnAgregar);
		
		JButton btnNewButton = new JButton("Vender");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String compra=BoxDiaCompra.getSelectedItem().toString()+"/"+BoxMesCompra.getSelectedItem().toString()+"/"+BoxACompra.getSelectedItem().toString();
				String venta=BoxDiaCompra_1.getSelectedItem().toString()+"/"+BoxMesCompra_1.getSelectedItem().toString()+"/"+BoxACompra_1.getSelectedItem().toString();
				
				inventario.desencolarElementoEspecifico(txtNombre.getText());
				datos.actualizarConNuevoDato("Inventario", inventario.imprimirCola());
				
				historial.apilar(txtNombre.getText(), BoxPresentacion.getSelectedItem().toString(), txtComposicion.getText(), 
								compra, venta, false);
				actualizarTabla();
				
				
			}
		});
		btnNewButton.setBounds(234, 315, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String compra=BoxDiaCompra.getSelectedItem().toString()+"/"+BoxMesCompra.getSelectedItem().toString()+"/"+BoxACompra.getSelectedItem().toString();
				String venta=BoxDiaCompra_1.getSelectedItem().toString()+"/"+BoxMesCompra_1.getSelectedItem().toString()+"/"+BoxACompra_1.getSelectedItem().toString();
				
				inventario.actualizarNodo(txtNombre.getText(), BoxPresentacion.getSelectedItem().toString(), txtComposicion.getText(), 
								compra, venta);
				datos.actualizarConNuevoDato("Inventario", inventario.imprimirCola());
				actualizarTabla();
			}
		});
		btnActualizar.setBounds(135, 349, 121, 23);
		panel.add(btnActualizar);
		
		JComboBox BoxTabla = new JComboBox();
		BoxTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				box=BoxTabla.getSelectedItem().toString();
				actualizarTabla();
			}
		});
		BoxTabla.setModel(new DefaultComboBoxModel(new String[] {"Inventario", "Historial"}));
		BoxTabla.setBounds(10, 13, 127, 22);
		contentPane.add(BoxTabla);
		
		
		
	}
	
	
	public static void actualizarTabla() {
		
		if(box.equals("Inventario")) {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			
			Cola cola = new Cola();
			Medicamento med;
			
			cola=inventario.clone();
			med=cola.desencolar();
			int fila=0;
			Object[] rowData = new Object[modelo.getColumnCount()];
			
			modelo.setRowCount(0);
			
			while(!med.nombre.equals("-1")) {
				
				modelo.addRow(rowData);
				modelo.setValueAt(med.nombre, fila, 0);
				modelo.setValueAt(med.presentacion, fila, 1);
				modelo.setValueAt(med.composicion, fila, 2);
				modelo.setValueAt(med.compraFecha, fila, 3);
				modelo.setValueAt(med.vencimientoFecha, fila, 4);
				med=cola.desencolar();
				fila=fila+1;
			}
			System.out.println("Fila: "+fila+med.nombre);
		
			modelo.fireTableDataChanged();
		}else {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			Pila pila = new Pila();
			
			//Cola cola = new Cola();
			Medicamento med;
			
			//cola=inventario.clone();
			pila=historial.clone();
			//med=cola.desencolar();
			med= pila.desapilar();
			int fila=0;
			Object[] rowData = new Object[modelo.getColumnCount()];
			
			modelo.setRowCount(0);
			
			while(!med.nombre.equals("-1")) {
				
				modelo.addRow(rowData);
				modelo.setValueAt(med.nombre, fila, 0);
				modelo.setValueAt(med.presentacion, fila, 1);
				modelo.setValueAt(med.composicion, fila, 2);
				modelo.setValueAt(med.compraFecha, fila, 3);
				modelo.setValueAt(med.vencimientoFecha, fila, 4);
				med=pila.desapilar();
				fila=fila+1;
			}
			System.out.println("Fila: "+fila+med.nombre);
		
			modelo.fireTableDataChanged();
		}
		
		


	}
}
