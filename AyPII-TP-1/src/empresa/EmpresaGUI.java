package empresa;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

import trabajador.Empleado;

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
	private Table table;
	private Text textoComision;

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
		shlEmpresa.setSize(826, 621);
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
						textoMontoPremio.setEnabled(true);
						labelMontoPremio.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
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
						textoMontoPremio.setEnabled(false);
						labelMontoPremio.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
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
						textoMontoPremio.setEnabled(false);
						labelMontoPremio.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
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
						textoMontoPremio.setEnabled(false);
						labelMontoPremio.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
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
		textoNombre.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		textoNombre.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		textoNombre.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlEmpresa, SWT.NONE);
		
		labelCuil = new Label(shlEmpresa, SWT.NONE);
		labelCuil.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelCuil.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		labelCuil.setText("CUIL");
		
		textoCuil = new Text(shlEmpresa, SWT.BORDER);
		textoCuil.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		textoCuil.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		textoCuil.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlEmpresa, SWT.NONE);
		
		labelSueldo = new Label(shlEmpresa, SWT.NONE);
		labelSueldo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelSueldo.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		labelSueldo.setText("Sueldo Fijo");
		
		textoSueldo = new Text(shlEmpresa, SWT.BORDER);
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
		labelMontoPremio.setText("Monto del premio");
		
		textoMontoPremio = new Text(shlEmpresa, SWT.BORDER);
		textoMontoPremio.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		textoMontoPremio.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		textoMontoPremio.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		checkAsignar = new Button(shlEmpresa, SWT.CHECK);
		checkAsignar.setText("Asignar");
		
		botonAgregar = new Button(shlEmpresa, SWT.NONE);
		botonAgregar.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		botonAgregar.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		botonAgregar.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		botonAgregar.setText("Agregar");
		botonAgregar.setEnabled(true);
		
		Button botonGenerarReporte = new Button(shlEmpresa, SWT.NONE);
		botonGenerarReporte.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		botonGenerarReporte.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		botonGenerarReporte.setText("Generar Reporte");
		new Label(shlEmpresa, SWT.NONE);
		
		botonQuitar = new Button(shlEmpresa, SWT.NONE);
		botonQuitar.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		botonQuitar.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		botonQuitar.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		botonQuitar.setText(" Quitar  ");
		botonQuitar.setEnabled(false);
		
		table = new Table(shlEmpresa, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn columnaDni = new TableColumn(table, SWT.NONE);
		columnaDni.setWidth(100);
		columnaDni.setText("DNI");
		
		TableColumn columnaNombre = new TableColumn(table, SWT.NONE);
		columnaNombre.setWidth(100);
		columnaNombre.setText("Nombre");
		
		TableColumn columnaCuil = new TableColumn(table, SWT.NONE);
		columnaCuil.setWidth(100);
		columnaCuil.setText("CUIL");
		
		TableColumn columnaSueldoFijo = new TableColumn(table, SWT.NONE);
		columnaSueldoFijo.setWidth(100);
		columnaSueldoFijo.setText("Sueldo Fijo");
		
		TableColumn columnaSalarioHora = new TableColumn(table, SWT.NONE);
		columnaSalarioHora.setWidth(100);
		columnaSalarioHora.setText("Salario / Hora");
		
		TableColumn columnaHorasTrabajadas = new TableColumn(table, SWT.NONE);
		columnaHorasTrabajadas.setWidth(100);
		columnaHorasTrabajadas.setText("Horas Trabajadas");
		
		TableColumn columnaPremio = new TableColumn(table, SWT.NONE);
		columnaPremio.setWidth(100);
		columnaPremio.setText("Monto del Premio");
		new Label(shlEmpresa, SWT.NONE);

	}

}
