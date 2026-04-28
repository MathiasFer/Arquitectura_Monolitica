package com.Fernandez.spaghetti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@SpringBootApplication
@RestController
public class SpaghettiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaghettiApplication.class, args);
	}

	List<Map<String, Object>> estudiantes = new ArrayList<>();
	int estudianteId = 1;

	@GetMapping("/")
	public String home() {
		String html = "<h1>Sistema Academico</h1>";
		html += "<a href='/estudiantes'><button>Gestionar Estudiantes</button></a>";
		return html;
	}

	@GetMapping("/estudiantes")
	public String estudiantes() {
		String html = "<h1>Estudiantes</h1>";

		html += "<form method='POST' action='/crear-estudiante'>";
		html += "Nombre: <input name='nombre'/><br>";
		html += "Direccion: <input name='direccion'/><br>";
		html += "Telefono: <input name='telefono'/><br>";
		html += "Email: <input name='email'/><br>";
		html += "<button type='submit'>Crear</button>";
		html += "</form><br>";

		html += "<ul>";
		for (Map<String, Object> e : estudiantes) {
			html += "<li>";
			html += e.get("id") + " - " + e.get("nombre");
			html += " | Dir: " + e.get("direccion");
			html += " | Tel: " + e.get("telefono");
			html += " | Email: " + e.get("email");
			html += " <a href='/editar-estudiante/" + e.get("id") + "'>Editar</a>";
			html += " <a href='/eliminar-estudiante/" + e.get("id") + "'>Eliminar</a>";
			html += "</li>";
		}
		html += "</ul>";

		html += "<a href='/'>Volver</a>";
		return html;
	}

	@PostMapping("/crear-estudiante")
	public String crear(@RequestParam String nombre,
						@RequestParam String direccion,
						@RequestParam String telefono,
						@RequestParam String email) {

		if (nombre == null || nombre.length() < 3) {
			return "<h3>Nombre invalido</h3><a href='/estudiantes'>Volver</a>";
		}

		Map<String, Object> estudiante = new HashMap<>();
		estudiante.put("id", estudianteId++);
		estudiante.put("nombre", nombre);
		estudiante.put("direccion", direccion);
		estudiante.put("telefono", telefono);
		estudiante.put("email", email);

		estudiantes.add(estudiante);

		return "<h3>Creado</h3><a href='/estudiantes'>Volver</a>";
	}

	@GetMapping("/eliminar-estudiante/{id}")
	public String eliminar(@PathVariable int id) {

		estudiantes.removeIf(e -> (int) e.get("id") == id);

		return "<h3>Eliminado</h3><a href='/estudiantes'>Volver</a>";
	}

	@GetMapping("/editar-estudiante/{id}")
	public String editarForm(@PathVariable int id) {

		Map<String, Object> estudiante = null;

		for (Map<String, Object> e : estudiantes) {
			if ((int) e.get("id") == id) {
				estudiante = e;
			}
		}

		if (estudiante == null) {
			return "<h3>No encontrado</h3><a href='/estudiantes'>Volver</a>";
		}

		String html = "<h1>Editar Estudiante</h1>";

		html += "<form method='POST' action='/actualizar-estudiante'>";
		html += "<input type='hidden' name='id' value='" + estudiante.get("id") + "'/>";
		html += "Nombre: <input name='nombre' value='" + estudiante.get("nombre") + "'/><br>";
		html += "Direccion: <input name='direccion' value='" + estudiante.get("direccion") + "'/><br>";
		html += "Telefono: <input name='telefono' value='" + estudiante.get("telefono") + "'/><br>";
		html += "Email: <input name='email' value='" + estudiante.get("email") + "'/><br>";
		html += "<button type='submit'>Actualizar</button>";
		html += "</form>";

		html += "<a href='/estudiantes'>Volver</a>";

		return html;
	}

	@PostMapping("/actualizar-estudiante")
	public String actualizar(@RequestParam int id,
							 @RequestParam String nombre,
							 @RequestParam String direccion,
							 @RequestParam String telefono,
							 @RequestParam String email) {

		for (Map<String, Object> e : estudiantes) {
			if ((int) e.get("id") == id) {
				e.put("nombre", nombre);
				e.put("direccion", direccion);
				e.put("telefono", telefono);
				e.put("email", email);
			}
		}

		return "<h3>Actualizado</h3><a href='/estudiantes'>Volver</a>";
	}
}