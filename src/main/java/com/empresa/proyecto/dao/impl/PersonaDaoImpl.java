package com.empresa.proyecto.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import com.empresa.proyecto.dao.PersonaDao;
import com.empresa.proyecto.model.Persona;
import com.empresa.proyecto.model.mapper.PersonaMapper;

@Repository
public class PersonaDaoImpl implements PersonaDao {

	@Autowired
	DataSource dataSource;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public List<Persona> listarPersona() {
		List<Persona> lista = new ArrayList<>();
		Map<String, Object> out = new HashMap<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withSchemaName("CESAR")
					.withCatalogName("PCK_APP").withProcedureName("SP_LISTAR_PERSONA")
					.returningResultSet("AC_LISTA", new PersonaMapper());

			out = simpleJdbcCall.execute();

			lista = (List<Persona>) out.get("AC_LISTA");
			return lista;
		} catch (Exception e) {
			System.out.println("Error al listar : " + e.getMessage());
			return null;
		}
	}

	public int crearPersona(Persona p) {
		Integer result = 1;
		Map<String, Object> out = new HashMap<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withSchemaName("CESAR")
					.withCatalogName("PCK_APP").withProcedureName("SP_CREAR_PERSONA");

			
			MapSqlParameterSource in = new MapSqlParameterSource();
			in.addValue("DNI", p.getDni());
			in.addValue("NOMBRE", p.getNombre());
			in.addValue("AP_PATERNO", p.getApellidoPaterno());
			in.addValue("AP_MATERNO", p.getApellidoMaterno());
			in.addValue("FECHA_NAC",sdf.format(p.getFechaNacimiento()));
			in.addValue("SEXO", p.getSexo());
			
			out = simpleJdbcCall.execute(in);

			result = Integer.parseInt(out.get("PN_COD_RESULTADO").toString());
			return result;
		} catch (Exception e) {
			System.out.println("Error al listar : " + e.getMessage());
			return -1;
		}
	}

	
	public Persona buscarPersona(Persona p) {
		List<Persona> lista = new ArrayList<>();
		Persona result = null;
		Map<String, Object> out = new HashMap<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withSchemaName("CESAR")
					.withCatalogName("PCK_APP").withProcedureName("SP_BUSCAR_PERSONA")
					.returningResultSet("AC_LISTA", new PersonaMapper());

			
			MapSqlParameterSource in = new MapSqlParameterSource();
			in.addValue("ID_CODIGO", p.getId());
			
			
			out = simpleJdbcCall.execute(in);

			lista = (List<Persona>) out.get("AC_LISTA");
			
			result = lista.get(0);
			return result;
		} catch (Exception e) {
			System.out.println("Error al listar : " + e.getMessage());
			return null;
		}
	}

	public int actualizarPersona(Persona p) {
		Integer result = 1;
		Map<String, Object> out = new HashMap<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withSchemaName("CESAR")
					.withCatalogName("PCK_APP").withProcedureName("SP_ACTUALIZAR_PERSONA");

			
			MapSqlParameterSource in = new MapSqlParameterSource();
			in.addValue("ID_ACTUALIZAR", p.getId());
			in.addValue("DNI_", p.getDni());
			in.addValue("NOMBRE_", p.getNombre());
			in.addValue("AP_PATERNO", p.getApellidoPaterno());
			in.addValue("AP_MATERNO", p.getApellidoMaterno());
			in.addValue("FECHA_NAC",sdf.format(p.getFechaNacimiento()));
			in.addValue("SEXO_", p.getSexo());
			
			out = simpleJdbcCall.execute(in);

			result = Integer.parseInt(out.get("PN_COD_RESULTADO").toString());
			return result;
		} catch (Exception e) {
			System.out.println("Error al listar : " + e.getMessage());
			return -1;
		}
	}

	public int borrarPersona(Persona p) {
		Integer result = 1;
		Map<String, Object> out = new HashMap<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withSchemaName("CESAR")
					.withCatalogName("PCK_APP").withProcedureName("SP_BORRAR_PERSONA");

			
			MapSqlParameterSource in = new MapSqlParameterSource();
			in.addValue("ID_CODIGO", p.getId());
			
			out = simpleJdbcCall.execute(in);

			result = Integer.parseInt(out.get("PN_COD_RESULTADO").toString());
			return result;
		} catch (Exception e) {
			System.out.println("Error al listar : " + e.getMessage());
			return -1;
		}
	}

}
