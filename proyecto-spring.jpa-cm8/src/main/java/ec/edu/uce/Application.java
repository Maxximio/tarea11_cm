package ec.edu.uce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.Receta;
import ec.edu.uce.modelo.jpa.Abogado;
import ec.edu.uce.modelo.jpa.Arquitecto;
import ec.edu.uce.modelo.jpa.Chofer;
import ec.edu.uce.modelo.jpa.Doctor;
import ec.edu.uce.modelo.jpa.Guardia;
import ec.edu.uce.modelo.jpa.Mesero;
import ec.edu.uce.service.IAbogadoService;
import ec.edu.uce.service.IArquitectoSerivce;
import ec.edu.uce.service.IChoferService;
import ec.edu.uce.service.IDoctorService;
import ec.edu.uce.service.IGestorCitaService;
import ec.edu.uce.service.IGuardiaService;
import ec.edu.uce.service.IMeseroService;
import ec.edu.uce.service.IPacienteService;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private IGestorCitaService gestorServ;
	
	@Autowired
	private IGuardiaService guardService;
	
	@Autowired
	private IDoctorService docService;
	
	@Autowired
	private IAbogadoService aboService;
	
	@Autowired
	private IArquitectoSerivce arqService;
	
	@Autowired
	private IChoferService choService;
	
	@Autowired
	private IMeseroService mesService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		//Paciente paciente1=new Paciente();
		//paciente1.setId(33236);
		//paciente1.setNombre("Patricio");
		//paciente1.setApellido("Salazar");
		//paciente1.setEdad(22);
		
		//Receta rec1=new Receta();
		//rec1.setId(88323);
		//rec1.setIndicaciones("Reposo durante 4 dias");
		//rec1.setMedicamentos("Ibuprofeno");
		
		//this.gestorServ.registratNuevaConsulta(paciente1, rec1);
		
		//pacienteServ.InsertarPacienteServicio(paciente1);
		//pacienteServ.borrarPacienteServicio(3336);
		//pacienteServ.actualizarPacienteServicio(paciente1);
		//System.out.println("El paciente a buscar fue: "+pacienteServ.buscarPacienteServicio(12345));
	
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		Guardia guard =new Guardia();
		guard.setNombre("Carlos");
		guard.setApellido("Alvarado");
		guard.setEdificio("Licuadora");
		
		Guardia guard2 =new Guardia();
		guard2.setId(3);
		guard2.setNombre("Ricardo");
		guard2.setApellido("Montalvo");
		guard2.setEdificio("Plaza Toros");
		
		//this.guardService.InsertarGuardiaService(guard);
		Guardia gApellido =this.guardService.buscarGuardiaApellidoService("Alvarado");
		System.out.println(gApellido);
		//System.out.println(this.guardService.buscarGuardiaApellidoService("Montalvo"));
		//this.guardService.buscarGuardiaService(3);
		//System.out.println(this.guardService.buscarGuardiaService(3));
		//this.guardService.borrarGuardiaService(3);
		//this.guardService.ActualizarGuardiaService(guard2);
		
		Doctor doc=new Doctor();
		Arquitecto arq =new Arquitecto();
		Abogado abo=new Abogado();
		Chofer cho=new Chofer();
		Mesero mes=new Mesero();
		
		doc.setApellido("Fernandez");
		doc.setEspecialidad("pediatra");
		//docService.InsertarDoctorService(doc);
		//docService.ActualizarDoctorService(doc);
		System.out.println(docService.buscarDoctorEspecialidadService("pediatra"));
		
		arq.setApellido("Aguiler");
		arq.setAniosexperiencia(20);
		//arqService.InsertarArquitectoService(arq);
		//arqService.ActualizarArquitectoService(arq);
		System.out.println(arqService.buscarArquitectoApellidoService("Aguiler"));
		
		abo.setApellido("Montalvo");
		abo.setFirma("abogados de Cayambe");
		//aboService.InsertarAbogadoService(abo);
		//aboService.ActualizarAbogadoService(abo);
		System.out.println(aboService.buscarAbogadoFirmaService("abogados de Cayambe"));
		
		//cho.setMatricula(432535);
		cho.setNombre("Mateo");
		cho.setPlaca(3234657);
		//choService.InsertarChoferService(cho);
		//choService.ActualizarChoferService(cho);
		System.out.println(choService.buscarChoferNombreService("Mateo"));
		
		mes.setApellido("Pereira");
		mes.setRestaurante("McDonalds");
		//mesService.InsertarMeseroService(mes);
		//mesService.ActualizarMeseroService(mes);
		System.out.println(mesService.buscarMeseroRestauranteService("McDonalds"));
		
		
	}

}
