package empresa;

import trabajador.Trabajador;
import trabajador.Voluntario;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

import exceptions.CuilDistintoDelDni;
import exceptions.CuilInvalido;
import exceptions.DniInvalido;
import exceptions.NumeroNegativo;
import exceptions.SalarioInvalido;
import exceptions.SeleccionarTrabajador;
import exceptions.TrabajadorExistente;
import trabajador.Ejecutivo;
import trabajador.Empleado;
import trabajador.EmpleadoPorHoras;
import trabajador.EmpleadoPorHorasAComision;
import empresa.Empresa;

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
	private ArrayList<Trabajador> trabajadoresExistentes;
	private HashSet<String> listadoDeDnisExistentes;
	private TableItem itemTrabajador;
	private Ejecutivo ejecutivo;
	private Trabajador trabajador;
	private Empleado empleado;
	private EmpleadoPorHoras empleadoPorHoras;
	private EmpleadoPorHorasAComision empleadoPorHorasAComision;
	private Voluntario voluntario;
	private Button botonContratar;
	private Button botonDespedir;
	private boolean checkAsignarSeleccionado;
	private TableColumn columnaMontoDelPremio;
	private TableColumn columnaTotalAPagar;
	private TableColumn columnaComision;

	/**
	 * Open the window.
	 * @throws TrabajadorExistente 
	 * @wbp.parser.entryPoint
	 */
	public void open() throws TrabajadorExistente {
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
	protected void createContents() throws TrabajadorExistente{
		shlEmpresa = new Shell();
		shlEmpresa.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		shlEmpresa.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		shlEmpresa.setSize(1180, 621);
		shlEmpresa.setText("Empresa");
		shlEmpresa.setLayout(new GridLayout(3, false));
		
		Empresa empresa = new Empresa();
		
		trabajadoresExistentes = new ArrayList<Trabajador>();
		listadoDeDnisExistentes = new HashSet<String>();
		
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
		comboTipoTrabajador.setItems(new String[] { "Ejecutivo", "Por horas", "Por horas a comisión", "Voluntario", "Empleado" });
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
						
					case "Empleado":
						textoSalarioHora.setEnabled(false);
						labelSalarioHora.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
						textoHorasTrabajadas.setEnabled(false);
						labelHorasTrabajadas.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
						textoSueldo.setEnabled(true);
						labelSueldo.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
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
		textoDni.setText("");
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
		textoNombre.setText("");
		textoNombre.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		textoNombre.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		textoNombre.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlEmpresa, SWT.NONE);
		
		labelCuil = new Label(shlEmpresa, SWT.NONE);
		labelCuil.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelCuil.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		labelCuil.setText("CUIL");
		
		textoCuil = new Text(shlEmpresa, SWT.BORDER);
		textoCuil.setText("");
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
		textoSueldo.setEnabled(false);
		new Label(shlEmpresa, SWT.NONE);
		
		labelSalarioHora = new Label(shlEmpresa, SWT.NONE);
		labelSalarioHora.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelSalarioHora.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		labelSalarioHora.setText("Salario / Hora");
		
		textoSalarioHora = new Text(shlEmpresa, SWT.BORDER);
		textoSalarioHora.setText("");
		textoSalarioHora.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		textoSalarioHora.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		textoSalarioHora.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textoSalarioHora.setEnabled(false);
		new Label(shlEmpresa, SWT.NONE);
		
		labelComision = new Label(shlEmpresa, SWT.NONE);
		labelComision.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelComision.setText("Comisión");
		
		textoComision = new Text(shlEmpresa, SWT.BORDER);
		textoComision.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		textoComision.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		textoComision.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textoComision.setEnabled(false);
		new Label(shlEmpresa, SWT.NONE);
		
		labelHorasTrabajadas = new Label(shlEmpresa, SWT.NONE);
		labelHorasTrabajadas.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelHorasTrabajadas.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		labelHorasTrabajadas.setText("Horas Trabajadas");
		
		textoHorasTrabajadas = new Text(shlEmpresa, SWT.BORDER);
		textoHorasTrabajadas.setText("");
		textoHorasTrabajadas.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		textoHorasTrabajadas.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		textoHorasTrabajadas.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textoHorasTrabajadas.setEnabled(false);
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
				boolean huboErrores = false;
				switch (evento.type) {
				case SWT.Selection:
					switch (comboTipoTrabajador.getText()) {
					case "Ejecutivo":
						try{
							//Me fijo si el Trabajador que intento crear ya existe
							if (listadoDeDnisExistentes.contains(textoDni.getText())){
								huboErrores = !huboErrores;
								throw new TrabajadorExistente("El trabajador ingresado ya existe. Por favor, verifique su ingreso.");
							}
							//Intento crear el Objeto Ejecutivo
							try{
								ejecutivo = new Ejecutivo(textoDni.getText(), textoNombre.getText(), textoCuil.getText(), Double.parseDouble(textoSueldo.getText()));
							} catch (NumeroNegativo mensaje){
								huboErrores = !huboErrores;
								mensajeDeError(mensaje.getMessage());
							} catch (DniInvalido mensaje){
								huboErrores = !huboErrores;
								mensajeDeError(mensaje.getMessage());
							} catch (CuilInvalido mensaje){
								huboErrores = !huboErrores;
								mensajeDeError(mensaje.getMessage());
							} catch (CuilDistintoDelDni mensaje){
								huboErrores = !huboErrores;
								mensajeDeError(mensaje.getMessage());
							} catch (IllegalArgumentException mensaje){
							}
							
							//Si ejecutivo es un objeto que ya tenia en el HashSet o esta vacio, el de recien no se pudo crear
							if ((trabajadoresExistentes.contains(ejecutivo) || ejecutivo == null) && !huboErrores){
								huboErrores = !huboErrores;
								throw new TrabajadorExistente("El usuario no se pudo generar. Verifique su ingreso");
							}
							
							//Me fijo si el Sueldo fijo ingresado es un numero
							if (!isNumber(textoSueldo.getText()) && !huboErrores){
								huboErrores = !huboErrores;
								throw new SalarioInvalido("El Sueldo fijo ingresado no es un número. Verifíquelo");
							}
							
							//En caso que se quiera pagar el premio, me fijo si se ingreso un numero							//
							if (textoMontoPremio.getText() != null && checkAsignarSeleccionado){
								if (!isNumber(textoMontoPremio.getText()) && !huboErrores){
									huboErrores = !huboErrores;
									throw new SalarioInvalido("El monto ingresado para el Premio es incorrecto. Verifiquelo por favor");
								}
							}
						} catch (SalarioInvalido mensaje){
							mensajeDeError(mensaje.getMessage());
						} catch (TrabajadorExistente mensaje) {
							mensajeDeError(mensaje.getMessage());
						}
						
						/*
						 * Acabamos de validar todos los campos para este tipo de usuario, a esta altura
						 * todos los campos deberían esta bien
						 */
						if (!huboErrores){
							//Agrego el usuario creado en un ArrayList para no perderlo en la proxima iteracion
							trabajadoresExistentes.add(tablaTrabajadores.getItemCount(), ejecutivo);
							
							//Agrego el DNI al listado de DNIs para no volver a crearlo
							listadoDeDnisExistentes.add(textoDni.getText());
							
							//Creo el TableItem
							itemTrabajador = new TableItem(tablaTrabajadores, SWT.NONE);
							itemTrabajador.setText(0, ejecutivo.getDni());
							itemTrabajador.setText(1, ejecutivo.getNombre());
							itemTrabajador.setText(2, ejecutivo.getCuil());
							itemTrabajador.setText(3, String.valueOf(ejecutivo.getSueldoFijo()));
							if (checkAsignarSeleccionado){
								ejecutivo.otorgarPremio(Double.parseDouble(textoMontoPremio.getText()));
							}
							itemTrabajador.setText(6, String.valueOf(ejecutivo.getPremioMonto()));
							itemTrabajador.setText(8, String.valueOf(ejecutivo.getSueldoTotal()));
						}
				break;
						
					case "Por horas":
						try{
							//Me fijo si el Trabajador que intento crear ya existe
							if (listadoDeDnisExistentes.contains(textoDni.getText())){
								huboErrores = !huboErrores;
								throw new TrabajadorExistente("El trabajador ingresado ya existe. Por favor, verifique su ingreso.");
							}
							
							//Intento crear el Objeto Ejecutivo
							try{
								empleadoPorHoras = new EmpleadoPorHoras(textoDni.getText(), textoNombre.getText(), textoCuil.getText(), Double.parseDouble(textoSalarioHora.getText()));
							} catch (NumeroNegativo mensaje){
								mensajeDeError(mensaje.getMessage());
							} catch (DniInvalido mensaje){
								mensajeDeError(mensaje.getMessage());
							} catch (CuilInvalido mensaje){
								mensajeDeError(mensaje.getMessage());
							} catch (CuilDistintoDelDni mensaje){
								mensajeDeError(mensaje.getMessage());
							} catch (IllegalArgumentException mensaje){
							}
							
							//Si ejecutivo es un objeto que ya tenia en el HashSet, el de recien no se pudo crear
							if ((trabajadoresExistentes.contains(empleadoPorHoras) || empleadoPorHoras == null) && !huboErrores){
								huboErrores = !huboErrores;
								throw new TrabajadorExistente("El usuario no se pudo generar. Verifique su ingreso");
							}
							
							//Me fijo si el Sueldo fijo ingresado es un numero
							if (!isNumber(textoSalarioHora.getText()) && !huboErrores){
								huboErrores = !huboErrores;
								throw new SalarioInvalido("El Salario / Hora ingresado no es un número. Verifíquelo");
							}
							
							if (!isNumber(textoHorasTrabajadas.getText()) && !huboErrores){
								huboErrores = !huboErrores;
								throw new SalarioInvalido("Las Horas Trabajadas ingresadas no son un número. Verifíquelo");
							}
						} catch (SalarioInvalido mensaje){
							mensajeDeError(mensaje.getMessage());
						} catch (TrabajadorExistente mensaje) {
							mensajeDeError(mensaje.getMessage());
						}
						
						/*
						 * Acabamos de validar todos los campos para este tipo de usuario, a esta altura
						 * todos los campos deberían esta bien
						 */
						if (!huboErrores){
							//Agrego el usuario creado en un ArrayList para no perderlo en la proxima iteracion
							trabajadoresExistentes.add(tablaTrabajadores.getItemCount(), empleadoPorHoras);
							
							//Agrego el DNI al listado de DNIs para no volver a crearlo
							listadoDeDnisExistentes.add(textoDni.getText());
							
							//Creo el TableItem
							itemTrabajador = new TableItem(tablaTrabajadores, SWT.NONE);
							itemTrabajador.setText(0, empleadoPorHoras.getDni());
							itemTrabajador.setText(1, empleadoPorHoras.getNombre());
							itemTrabajador.setText(2, empleadoPorHoras.getCuil());
							itemTrabajador.setText(4, String.valueOf(empleadoPorHoras.getMontoPorHora()));
							empleadoPorHoras.setHorasTrabajadas(Double.parseDouble(textoHorasTrabajadas.getText()));
							itemTrabajador.setText(5, String.valueOf(empleadoPorHoras.getHorasTrabajadas()));
							empleadoPorHoras.setSueldoFijo();
							itemTrabajador.setText(8, String.valueOf(empleadoPorHoras.getSueldoTotal()));
						}
				break;
				
					case "Por horas a comisión":
						try{
							//Me fijo si el Trabajador que intento crear ya existe
							if (listadoDeDnisExistentes.contains(textoDni.getText())){
								huboErrores = !huboErrores;
								throw new TrabajadorExistente("El trabajador ingresado ya existe. Por favor, verifique su ingreso.");
							}
							
							//Intento crear el Objeto Ejecutivo
							try{
								empleadoPorHorasAComision = new EmpleadoPorHorasAComision(textoDni.getText(), textoNombre.getText(), textoCuil.getText(), Double.parseDouble(textoComision.getText()), Double.parseDouble(textoSalarioHora.getText()));
							} catch (NumeroNegativo mensaje){
								mensajeDeError(mensaje.getMessage());
							} catch (DniInvalido mensaje){
								mensajeDeError(mensaje.getMessage());
							} catch (CuilInvalido mensaje){
								mensajeDeError(mensaje.getMessage());
							} catch (CuilDistintoDelDni mensaje){
								mensajeDeError(mensaje.getMessage());
							} catch (IllegalArgumentException mensaje){
							}

							
							//Si ejecutivo es un objeto que ya tenia en el HashSet, el de recien no se pudo crear
							if ((trabajadoresExistentes.contains(empleadoPorHorasAComision) || empleadoPorHorasAComision == null) && !huboErrores){
								huboErrores = !huboErrores;
								throw new TrabajadorExistente("El usuario no se pudo generar. Verifique su ingreso");
							}
							
							//Me fijo si el Sueldo fijo ingresado es un numero
							if (!isNumber(textoSalarioHora.getText()) && !huboErrores){
								huboErrores = !huboErrores;
								throw new SalarioInvalido("El Salario / Hora ingresado no es un número. Verifíquelo");
							}
							
							if (!isNumber(textoHorasTrabajadas.getText()) && !huboErrores){
								huboErrores = !huboErrores;
								throw new SalarioInvalido("Las Horas Trabajadas ingresadas no son un número. Verifíquelo");
							}
							
							if (!isNumber(textoComision.getText()) && !huboErrores){
								huboErrores = !huboErrores;
								throw new SalarioInvalido("La Comisión ingresada no es un número. Verifíquelo");
							}
							
						} catch (SalarioInvalido mensaje){
							mensajeDeError(mensaje.getMessage());
						} catch (TrabajadorExistente mensaje) {
							mensajeDeError(mensaje.getMessage());
						}
						
						/*
						 * Acabamos de validar todos los campos para este tipo de usuario, a esta altura
						 * todos los campos deberían esta bien
						 */
						if (!huboErrores){
							//Agrego el usuario creado en un ArrayList para no perderlo en la proxima iteracion
							trabajadoresExistentes.add(tablaTrabajadores.getItemCount(), empleadoPorHorasAComision);
							
							//Agrego el DNI al listado de DNIs para no volver a crearlo
							listadoDeDnisExistentes.add(textoDni.getText());
							
							//Creo el TableItem
							itemTrabajador = new TableItem(tablaTrabajadores, SWT.NONE);
							itemTrabajador.setText(0, empleadoPorHorasAComision.getDni());
							itemTrabajador.setText(1, empleadoPorHorasAComision.getNombre());
							itemTrabajador.setText(2, empleadoPorHorasAComision.getCuil());
							itemTrabajador.setText(4, String.valueOf(empleadoPorHorasAComision.getMontoPorHora()));
							empleadoPorHorasAComision.setHorasTrabajadas(Double.parseDouble(textoHorasTrabajadas.getText()));
							itemTrabajador.setText(5, String.valueOf(empleadoPorHorasAComision.getHorasTrabajadas()));
							itemTrabajador.setText(6, String.valueOf(empleadoPorHorasAComision.getPorcentajeDeComision()));
							empleadoPorHorasAComision.setSueldoFijo();
							itemTrabajador.setText(8, String.valueOf(empleadoPorHorasAComision.getSueldoTotal()));
						}
				break;
				
					case "Voluntario":
						try{
							//Me fijo si el Trabajador que intento crear ya existe
							if (listadoDeDnisExistentes.contains(textoDni.getText())){
								huboErrores = !huboErrores;
								throw new TrabajadorExistente("El trabajador ingresado ya existe. Por favor, verifique su ingreso.");
							}
							//Intento crear el Objeto Ejecutivo
							try{
								voluntario = new Voluntario(textoDni.getText(), textoNombre.getText(), textoCuil.getText());
							} catch (DniInvalido mensaje){
								mensajeDeError(mensaje.getMessage());
							} catch (CuilInvalido mensaje){
								mensajeDeError(mensaje.getMessage());
							} catch (CuilDistintoDelDni mensaje){
								mensajeDeError(mensaje.getMessage());
							} catch (IllegalArgumentException mensaje){
							}
							
							//Si ejecutivo es un objeto que ya tenia en el HashSet, el de recien no se pudo crear
							if ((trabajadoresExistentes.contains(voluntario) || voluntario == null) && !huboErrores){
								huboErrores = !huboErrores;
								throw new TrabajadorExistente("El usuario no se pudo generar. Verifique su ingreso");
							}
						} catch (TrabajadorExistente mensaje) {
							mensajeDeError(mensaje.getMessage());
						}
						
						/*
						 * Acabamos de validar todos los campos para este tipo de usuario, a esta altura
						 * todos los campos deberían esta bien
						 */
						if (!huboErrores){
							//Agrego el usuario creado en un ArrayList para no perderlo en la proxima iteracion
							trabajadoresExistentes.add(tablaTrabajadores.getItemCount(), voluntario);
							
							//Agrego el DNI al listado de DNIs para no volver a crearlo
							listadoDeDnisExistentes.add(textoDni.getText());
							
							//Creo el TableItem
							itemTrabajador = new TableItem(tablaTrabajadores, SWT.NONE);
							itemTrabajador.setText(0, voluntario.getDni());
							itemTrabajador.setText(1, voluntario.getNombre());
							itemTrabajador.setText(2, voluntario.getCuil());
						}
				break;
				
					case "Empleado":
						try{
							//Me fijo si el Trabajador que intento crear ya existe
							if (listadoDeDnisExistentes.contains(textoDni.getText())){
								huboErrores = !huboErrores;
								throw new TrabajadorExistente("El trabajador ingresado ya existe. Por favor, verifique su ingreso.");
							}
							
							try{
								empleado = new Empleado(textoDni.getText(), textoNombre.getText(), textoCuil.getText(), Double.parseDouble(textoSueldo.getText()));
							} catch (NumeroNegativo mensaje){
								mensajeDeError(mensaje.getMessage());
							} catch (DniInvalido mensaje){
								mensajeDeError(mensaje.getMessage());
							} catch (CuilInvalido mensaje){
								mensajeDeError(mensaje.getMessage());
							} catch (CuilDistintoDelDni mensaje){
								mensajeDeError(mensaje.getMessage());
							} catch (IllegalArgumentException mensaje){
							}
							
							//Si ejecutivo es un objeto que ya tenia en el HashSet, el de recien no se pudo crear
							if ((trabajadoresExistentes.contains(empleado) || empleado == null) && !huboErrores){
								huboErrores = !huboErrores;
								throw new TrabajadorExistente("El usuario no se pudo generar. Verifique su ingreso");
							}
							
							//Me fijo si el Sueldo fijo ingresado es un numero
							if (!isNumber(textoSueldo.getText()) && !huboErrores){
								huboErrores = !huboErrores;
								throw new SalarioInvalido("El Sueldo fijo ingresado no es un número. Verifíquelo");
							}
							
							//En caso que se quiera pagar el premio, me fijo si se ingreso un numero							//
							if (textoMontoPremio.getText() != null && checkAsignarSeleccionado){
								if (!isNumber(textoMontoPremio.getText()) && !huboErrores){
									huboErrores = !huboErrores;
									throw new SalarioInvalido("El monto ingresado para el Premio es incorrecto. Verifiquelo por favor");
								}
							}
						} catch (SalarioInvalido mensaje){
							mensajeDeError(mensaje.getMessage());
						} catch (TrabajadorExistente mensaje) {
							mensajeDeError(mensaje.getMessage());
						}
						
						/*
						 * Acabamos de validar todos los campos para este tipo de usuario, a esta altura
						 * todos los campos deberían esta bien
						 */
						if (!huboErrores){
							//Agrego el usuario creado en un ArrayList para no perderlo en la proxima iteracion
							trabajadoresExistentes.add(tablaTrabajadores.getItemCount(), empleado);
							
							//Agrego el DNI al listado de DNIs para no volver a crearlo
							listadoDeDnisExistentes.add(textoDni.getText());
							
							//Creo el TableItem
							itemTrabajador = new TableItem(tablaTrabajadores, SWT.NONE);
							itemTrabajador.setText(0, empleado.getDni());
							itemTrabajador.setText(1, empleado.getNombre());
							itemTrabajador.setText(2, empleado.getCuil());
							itemTrabajador.setText(8, String.valueOf(empleado.getSueldoTotal()));
						}
				break;
					}
				}
			}
		});
		
		Button botonGenerarReporte = new Button(shlEmpresa, SWT.NONE);
		botonGenerarReporte.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		botonGenerarReporte.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		botonGenerarReporte.setText("Generar Reporte");
		botonGenerarReporte.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event evento) {
				switch (evento.type) {
				case SWT.Selection:
					try{
						empresa.fileWriter("./Reporte.txt");
						MessageBox ventanaConfirmacion = new MessageBox(shlEmpresa, SWT.ICON_INFORMATION);
						ventanaConfirmacion.setMessage("El Reporte se genero en " + System.getProperty("user.dir"));
						ventanaConfirmacion.open();
					} catch (IOException mensaje){
						mensajeDeError(mensaje.getMessage());
					}
				}
			}
		});
		
		botonContratar = new Button(shlEmpresa, SWT.NONE);
		botonContratar.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		botonContratar.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		botonContratar.setText("Contratar");
		botonContratar.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event evento) {
				switch (evento.type) {
				case SWT.Selection:
					try{
						if (tablaTrabajadores.getSelectionIndex() == -1){
							throw new SeleccionarTrabajador("Seleccione un trabajador para ser contratado.");
						} else if (itemTrabajador.getText(9) == "Si"){
							throw new SeleccionarTrabajador("El trabajador ya está contratado");
						} else {
							trabajador = trabajadoresExistentes.get(tablaTrabajadores.getSelectionIndex());
							empresa.contratarEmpleado(trabajador);
							itemTrabajador.setText(9, "Si");
						}
					} catch (SeleccionarTrabajador mensaje){
						mensajeDeError(mensaje.getMessage());
					} catch (IndexOutOfBoundsException mensaje){
					}
				}
			}
		});
		
		
		botonQuitar = new Button(shlEmpresa, SWT.NONE);
		botonQuitar.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		botonQuitar.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		botonQuitar.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		botonQuitar.setText(" Quitar  ");
		botonQuitar.setEnabled(false);
		botonQuitar.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event evento) {
				try{
					botonEliminar();
				} catch (SeleccionarTrabajador mensaje){
					mensajeDeError(mensaje.getMessage());
				}
				
			}

			private void botonEliminar() throws SeleccionarTrabajador{
				if(tablaTrabajadores.getSelectionIndex() == -1){
					throw new SeleccionarTrabajador("No hay ningún Trabajador seleccionado");
				} else {
					tablaTrabajadores.remove(tablaTrabajadores.getSelectionIndex());
				}
			}
		});
		
		
		tablaTrabajadores = new Table(shlEmpresa, SWT.BORDER | SWT.FULL_SELECTION);
		tablaTrabajadores.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tablaTrabajadores.setHeaderVisible(true);
		tablaTrabajadores.setLinesVisible(true);
		
		TableColumn columnaDni = new TableColumn(tablaTrabajadores, SWT.NONE);
		columnaDni.setWidth(95);
		columnaDni.setText("DNI");
		
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
		
		columnaComision = new TableColumn(tablaTrabajadores, SWT.NONE);
		columnaComision.setWidth(100);
		columnaComision.setText("Comisión");
		
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
		botonDespedir.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event evento) {
				switch (evento.type) {
				case SWT.Selection:
					try{
						if (tablaTrabajadores.getSelectionIndex() == -1){
							throw new SeleccionarTrabajador("Seleccione un trabajador para ser contratado.");
						} else if (itemTrabajador.getText(9) == "No"){
							throw new SeleccionarTrabajador("El trabajador no está contratado");
						} else {
							trabajador = trabajadoresExistentes.get(tablaTrabajadores.getSelectionIndex());
							empresa.despedirEmpleado(trabajador);
							itemTrabajador.setText(9, "No");
						}
					} catch (SeleccionarTrabajador mensaje){
						mensajeDeError(mensaje.getMessage());
					} catch (IndexOutOfBoundsException mensaje){
					}

				}
			}
		});


	}
	
	public static boolean isNumber(String textoIngresado) {
		
		boolean esNumero = true;
		
		if (textoIngresado == null || textoIngresado.isEmpty()) {

			esNumero = !esNumero;
		}
		int i = 0;
		if (textoIngresado.charAt(0) == '-') {

			if (textoIngresado.length() > 1) {
				i++;
			} else {
				esNumero = !esNumero;
			}
		}
		for (; i < textoIngresado.length(); i++) {

			if (!Character.isDigit(textoIngresado.charAt(i)) && textoIngresado.charAt(i) != '.') {

				esNumero = !esNumero;
			}
		}

		return esNumero;
	}
	
	public void mensajeDeError(String mensaje){
		MessageBox ventanaWarning = new MessageBox(shlEmpresa, SWT.ICON_WARNING);
		ventanaWarning.setMessage(mensaje);
		ventanaWarning.open();
	}
}
