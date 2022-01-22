package com.gestion.empleados.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.excepciones.ResourceNotFoundException;
import com.gestion.empleados.modelo.Empleado;
import com.gestion.empleados.repositorio.EmpleadoRepositorio;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200/")
public class EmpleadoControlador {
	
	@Autowired
	private EmpleadoRepositorio repositorio;
	
	@GetMapping("/empleados")
	public List<Empleado> listarTodosLosEmpleados(){
		return repositorio.findAll();
	}
	
	@PostMapping("/empleados")
	public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
		return repositorio.save(empleado);
	}
	
	@GetMapping("/empleados/{id}")
	public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id){
		Empleado empleado= repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe empleado con ID: "+ id));
		return ResponseEntity.ok(empleado);
	}
	
	@PutMapping("/empleados/{id}")
	public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado detalleEmpleado){
		Empleado empleado= repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe empleado con ID: "+ id));
		empleado.setNombre(detalleEmpleado.getNombre());
		empleado.setApellido(detalleEmpleado.getApellido());
		empleado.setEmail(detalleEmpleado.getEmail());
		
		Empleado empleadoActualizado= repositorio.save(empleado);
		return ResponseEntity.ok(empleadoActualizado);
	}
	
	//otra version de cambio de empleado
	public void hola_mundo() {
		System.out.println("hola_mundo");
	}
	public void hola_mundo_2() {
		System.out.println("hola_mundo");
	}
	public void hola_mundo_3() {
		System.out.println("hola_mundo");
	}
	public void hola_mundo_4() {
		System.out.println("hola_mundo");
	}

}
