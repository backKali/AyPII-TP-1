package empresa;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

import trabajador.Ejecutivo;

import org.eclipse.swt.widgets.TableItem;

public class EmpresaGUI {

	protected Shell shlEmpresa;
	private Button botonAgregar;
	private Button botonQuitar;
	private Button checkAsignar;
	private Label labelNombre;
	private Label labelCuil; 
	private Label labelSalarioHora;
	private Label labelHorasTrabajadas;
	private Label labelSueldo;
	private Label labelMontoPremio;
	private Label labelComision;
	private Combo comboTipoTrabajador;
	private Text textoNombre;
	private Text textoDni;
	private Text textoSalarioHora;
	private Text textoCuil;
	private Text textoHorasTrabajadas;
	private Text textoSueldo;
	private Text textoMontoPremio;
	private Table tablaTrabajadores;
	private Text textoComision;
	private Button botonContratar;
	private Button botonDespedir;
	private boolean checkAsignarSeleccionado;
	private TableColumn columnaMontoDelPremio;
	private TableColumn columnaTotalAPagar;

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlEmpresa.open();
		shlEmpresa.layout();
		while (!shlEmpresa.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlEmpresa = new Shell();
		shlEmpresa.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		shlEmpresa.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		shlEmpresa.setSize(1180, 621);
		shlEmpresa.setText("Empresa");
		shlEmpresa.setLayout(new GridLayout(3, false));
		
		Label labelAccion = new Label(shlEmpresa, SWT.NONE);
		labelAccion.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		labelAccion.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelAccion.setAlignment(SWT.RIGHT);
		labelAccion.setText("Accion");
		
		Button radioAgregar = new Button(shlEmpresa, SWT.RADIO);
		radioAgregar.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		radioAgregar.setText("Agregar");
		radioAgregar.setSelection(true);
		radioAgregar.addSelectionListener(
				new SelectionListener() {
			        public void widgetDefaultSelected(SelectionEvent evento) {
			        }
			        
			        public void widgetSelected(SelectionEvent evento) {
		                boolean isSelected = ((Button)evento.getSource()).getSelection();
		                if(isSelected){
		                	botonAgregar.setEnabled(true);
		                	botonQuitar.setEnabled(false);
		                }
			        }
			    }
		);
		new Label(shlEmpresa, SWT.NONE);
		new Label(shlEmpresa, SWT.NONE);
		
		Button radioQuitar = new Button(shlEmpresa, SWT.RADIO);
		radioQuitar.setText("Quitar");
		radioQuitar.addSelectionListener(
				new SelectionListener() {
					public void widgetDefaultSelected(SelectionEvent evento) {

			        }
					
					public void widgetSelected(SelectionEvent evento) {
						boolean isSelected = ((Button)evento.getSource()).getSelection();
						if(isSelected){
							botonAgregar.setEnabled(false);
							botonQuitar.setEnabled(true);
							comboTipoTrabajador.setEnabled(false);
							textoNombre.setEnabled(false);
							labelNombre.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
							textoCuil.setEnabled(false);
							labelCuil.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
							textoSalarioHora.setEnabled(false);
							labelSalarioHora.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
							textoHorasTrabajadas.setEnabled(false);
							labelHorasTrabajadas.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
							textoSueldo.setEnabled(false);
							labelSueldo.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
							textoComision.setEnabled(false);
							labelComision.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
							textoMontoPremio.setEnabled(false);
							labelMontoPremio.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
							checkAsignar.setEnabled(false);
						}
					}
				}
		);
		new Label(shlEmpresa, SWT.NONE);
		
		Label labelTipoTrabajador = new Label(shlEmpresa, SWT.NONE);
		labelTipoTrabajador.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelTipoTrabajador.setText("Tipo de Trabajador");
		
		comboTipoTrabajador = new Combo(shlEmpresa, SWT.READ_ONLY);
		comboTipoTrabajador.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		comboTipoTrabajador.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		comboTipoTrabajador.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comboTipoTrabajador.setItems(new String[] { "Ejecutivo", "Por horas", "Por horas a comisión", "Voluntario" });
		comboTipoTrabajador.addSelectionListener(new SelectionListener(){
			public void widgetDefaultSelected(SelectionEvent evento) {
			}

			public void widgetSelected(SelectionEvent evento) {
				switch (comboTipoTrabajador.getText()) {
					case "Ejecutivo":
						textoSalarioHora.setEnabled(false);
						labelSalarioHora.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
						textoHorasTrabajadas.setEnabled(false);
						labelHorasTrabajadas.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
						textoSueldo.setEnabled(true);
						labelSueldo.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
						textoComision.setEnabled(false);
						labelComision.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
						checkAsignar.setEnabled(true);
						break;
						
					case "Por horas":
						textoSalarioHora.setEnabled(true);
						labelSalarioHora.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
						textoHorasTrabajadas.setEnabled(true);
						labelHorasTrabajadas.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
						textoSueldo.setEnabled(false);
						labelSueldo.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
						textoComision.setEnabled(false);
						labelComision.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
						checkAsignar.setEnabled(false);
						break;
						
					case "Por horas a comisión":
						textoSalarioHora.setEnabled(true);
						labelSalarioHora.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
						textoHorasTrabajadas.setEnabled(true);
						labelHorasTrabajadas.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
						textoSueldo.setEnabled(false);
						labelSueldo.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
						textoComision.setEnabled(true);
						labelComision.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
						checkAsignar.setEnabled(false);
						break;
						
					case "Voluntario":
						textoSalarioHora.setEnabled(false);
						labelSalarioHora.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
						textoHorasTrabajadas.setEnabled(false);
						labelHorasTrabajadas.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
						textoSueldo.setEnabled(false);
						labelSueldo.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
						textoComision.setEnabled(false);
						labelComision.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
						checkAsignar.setEnabled(false);
						break;
						
				}
			}
		});
		new Label(shlEmpresa, SWT.NONE);
		
		Label labelDni = new Label(shlEmpresa, SWT.NONE);
		labelDni.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelDni.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		labelDni.setText("DNI");
		
		textoDni = new Text(shlEmpresa, SWT.BORDER);
		textoDni.setText("31070401");
		textoDni.setTextLimit(8);
		textoDni.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		textoDni.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		textoDni.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlEmpresa, SWT.NONE);
		
		labelNombre = new Label(shlEmpresa, SWT.NONE);
		labelNombre.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelNombre.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		labelNombre.setText("Nombre");
		
		textoNombre = new Text(shlEmpresa, SWT.BORDER);
		textoNombre.setText("Javier Lazzarino");
		textoNombre.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		textoNombre.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		textoNombre.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlEmpresa, SWT.NONE);
		
		labelCuil = new Label(shlEmpresa, SWT.NONE);
		labelCuil.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelCuil.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		labelCuil.setText("CUIL");
		
		textoCuil = new Text(shlEmpresa, SWT.BORDER);
		textoCuil.setText("20-31070401-7");
		textoCuil.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		textoCuil.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		textoCuil.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlEmpresa, SWT.NONE);
		
		labelSueldo = new Label(shlEmpresa, SWT.NONE);
		labelSueldo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelSueldo.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		labelSueldo.setText("Sueldo Fijo");
		
		textoSueldo = new Text(shlEmpresa, SWT.BORDER);
		textoSueldo.setText("35000.0");
		textoSueldo.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		textoSueldo.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		textoSueldo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlEmpresa, SWT.NONE);
		
		labelSalarioHora = new Label(shlEmpresa, SWT.NONE);
		labelSalarioHora.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelSalarioHora.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		labelSalarioHora.setText("Salario / Hora");
		
		textoSalarioHora = new Text(shlEmpresa, SWT.BORDER);
		textoSalarioHora.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		textoSalarioHora.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		textoSalarioHora.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlEmpresa, SWT.NONE);
		
		labelComision = new Label(shlEmpresa, SWT.NONE);
		labelComision.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelComision.setText("Comisión");
		
		textoComision = new Text(shlEmpresa, SWT.BORDER);
		textoComision.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		textoComision.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		textoComision.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlEmpresa, SWT.NONE);
		
		labelHorasTrabajadas = new Label(shlEmpresa, SWT.NONE);
		labelHorasTrabajadas.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelHorasTrabajadas.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		labelHorasTrabajadas.setText("Horas Trabajadas");
		
		textoHorasTrabajadas = new Text(shlEmpresa, SWT.BORDER);
		textoHorasTrabajadas.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		textoHorasTrabajadas.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		textoHorasTrabajadas.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlEmpresa, SWT.NONE);
		
		labelMontoPremio = new Label(shlEmpresa, SWT.NONE);
		labelMontoPremio.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelMontoPremio.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		labelMontoPremio.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		labelMontoPremio.setText("Monto del premio");
		
		textoMontoPremio = new Text(shlEmpresa, SWT.BORDER);
		textoMontoPremio.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		textoMontoPremio.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		textoMontoPremio.setEnabled(false);
		textoMontoPremio.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		checkAsignar = new Button(shlEmpresa, SWT.CHECK);
		checkAsignar.setText("Asignar");
		checkAsignar.addSelectionListener(
				new SelectionListener() {
					public void widgetDefaultSelected(SelectionEvent evento) {

			        }
					
					public void widgetSelected(SelectionEvent evento) {
						checkAsignarSeleccionado = ((Button)evento.getSource()).getSelection();
						if(checkAsignarSeleccionado){
							labelMontoPremio.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
							textoMontoPremio.setEnabled(true);
						} else {
							labelMontoPremio.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
							textoMontoPremio.setEnabled(false);
						}
				}
		});
		
		botonAgregar = new Button(shlEmpresa, SWT.NONE);
		botonAgregar.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		botonAgregar.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		botonAgregar.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		botonAgregar.setText("Agregar");
		botonAgregar.setEnabled(true);
		botonAgregar.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event evento) {
				switch (evento.type) {
				case SWT.Selection:
					switch (comboTipoTrabajador.getText()) {
					case "Ejecutivo":
						try{
							Ejecutivo ejecutivo = new Ejecutivo(textoDni.getText(), textoNombre.getText(), textoCuil.getText(), Double.parseDouble(textoSueldo.getText()));
							TableItem itemTrabajador = new TableItem(tablaTrabajadores, SWT.NONE);
							itemTrabajador.setText(0, ejecutivo.getDni());
							itemTrabajador.setText(1, ejecutivo.getNombre());
							itemTrabajador.setText(2, ejecutivo.getCuil());
							if (isNumber(textoSueldo.getText())){
								itemTrabajador.setText(3, textoSueldo.getText());
							}
							if (textoMontoPremio.getText() != null && checkAsignarSeleccionado){
								ejecutivo.otorgarPremio(Double.parseDouble(textoMontoPremio.getText()));
								itemTrabajador.setText(6, textoMontoPremio.getText());
							}

						} catch (Exception mensaje){
							System.out.println(mensaje);
						}
						break;
						
					case "Por horas":
						break;
						
					case "Por horas a comisión":
						break;
						
					case "Voluntario":
						break;
					}
				}
			}
		});
		
		Button botonGenerarReporte = new Button(shlEmpresa, SWT.NONE);
		botonGenerarReporte.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		botonGenerarReporte.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		botonGenerarReporte.setText("Generar Reporte");
		
		botonContratar = new Button(shlEmpresa, SWT.NONE);
		botonContratar.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		botonContratar.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		botonContratar.setText("Contratar");
		
		botonQuitar = new Button(shlEmpresa, SWT.NONE);
		botonQuitar.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		botonQuitar.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		botonQuitar.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		botonQuitar.setText(" Quitar  ");
		botonQuitar.setEnabled(false);
		
		tablaTrabajadores = new Table(shlEmpresa, SWT.BORDER | SWT.FULL_SELECTION);
		tablaTrabajadores.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tablaTrabajadores.setHeaderVisible(true);
		tablaTrabajadores.setLinesVisible(true);
		tablaTrabajadores.addListener(SWT.MouseDown, new Listener(){
			public void handleEvent(Event evento){
				Point punto = new Point(evento.x, evento.y);
				TableItem item = tablaTrabajadores.getItem(punto);
				System.out.println(item);
				if(item != null) {
					for (int col = 0; col < tablaTrabajadores.getColumnCount(); col++) {
						Rectangle rectangulo = item.getBounds(col);
						if (rectangulo.contains(punto)) {
							System.out.println("item clicked.");
							System.out.println("column is " + col);
						}
					}
				}
			}
	    });
		
		TableColumn columnaDni = new TableColumn(tablaTrabajadores, SWT.NONE);
		columnaDni.setWidth(95);
		columnaDni.setText("DNI");
//		columnaDni.addListener(SWT.Selection, new Listener() {
//			public void handleEvent(Event event) {
//				columnaDni.pack();
//			}
//		});
		
		TableColumn columnaNombre = new TableColumn(tablaTrabajadores, SWT.NONE);
		columnaNombre.setWidth(255);
		columnaNombre.setText("Nombre");
		
		TableColumn columnaCuil = new TableColumn(tablaTrabajadores, SWT.NONE);
		columnaCuil.setWidth(105);
		columnaCuil.setText("CUIL");
		
		TableColumn columnaSueldoFijo = new TableColumn(tablaTrabajadores, SWT.NONE);
		columnaSueldoFijo.setWidth(70);
		columnaSueldoFijo.setText("Sueldo Fijo");
		
		TableColumn columnaSalarioHora = new TableColumn(tablaTrabajadores, SWT.NONE);
		columnaSalarioHora.setWidth(50);
		columnaSalarioHora.setText("Salario / Hora");
		
		TableColumn columnaHorasTrabajadas = new TableColumn(tablaTrabajadores, SWT.NONE);
		columnaHorasTrabajadas.setWidth(30);
		columnaHorasTrabajadas.setText("Horas Trabajadas");
		
		columnaMontoDelPremio = new TableColumn(tablaTrabajadores, SWT.NONE);
		columnaMontoDelPremio.setWidth(100);
		columnaMontoDelPremio.setText("Monto del Premio");
		
		columnaTotalAPagar = new TableColumn(tablaTrabajadores, SWT.NONE);
		columnaTotalAPagar.setWidth(100);
		columnaTotalAPagar.setText("Total a Pagar");
		
		TableColumn columnaContratado = new TableColumn(tablaTrabajadores, SWT.NONE);
		columnaContratado.setWidth(100);
		columnaContratado.setText("Contratado");
		
		botonDespedir = new Button(shlEmpresa, SWT.NONE);
		botonDespedir.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		botonDespedir.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		botonDespedir.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		botonDespedir.setText("Despedir ");

	}
	
	public static boolean isNumber(String string) {

		if (string == null || string.isEmpty()) {

			return false;
		}
		int i = 0;
		if (string.charAt(0) == '-') {

			if (string.length() > 1) {
				i++;
			} else {
				return false;
			}
		}
		for (; i < string.length(); i++) {

			if (!Character.isDigit(string.charAt(i)) && string.charAt(i) != '.') {

				return false;

			}
		}

		return true;
	}
}
