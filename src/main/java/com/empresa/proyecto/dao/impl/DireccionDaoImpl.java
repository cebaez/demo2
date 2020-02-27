package com.empresa.proyecto.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import com.empresa.proyecto.dao.DireccionDao;
import com.empresa.proyecto.model.Direccion;
import com.empresa.proyecto.model.Persona;
import com.empresa.proyecto.model.mapper.DireccionMapper;
import com.empresa.proyecto.model.mapper.PersonaMapper;

@Repository
public class DireccionDaoImpl implements DireccionDao {

	@Autowired
	DataSource dataSource;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public List<Direccion> listarDireccion() {
		List<Direccion> lista = new ArrayList<>();
		Map<String, Object> out = new HashMap<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withSchemaName("CESAR")
					.withCatalogName("PCK_APP").withProcedureName("SP_LISTAR_DIRECCIONES")
					.returningResultSet("AC_LISTA", new DireccionMapper());

			out = simpleJdbcCall.execute();

			lista = (List<Direccion>) out.get("AC_LISTA");
			return lista;
		} catch (Exception e) {
			System.out.println("Error al listar : " + e.getMessage());
			return null;
		}
	}
	
	public int crearDireccion(Direccion d) {
		Integer result = 1;
		Map<String, Object> out = new HashMap<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withSchemaName("CESAR")
					.withCatalogName("PCK_APP").withProcedureName("SP_CREAR_DIRECCION");

			
			MapSqlParameterSource in = new MapSqlParameterSource();
			in.addValue("DISTRITO", d.getDistrito());
			in.addValue("DIRECCION_", d.getDireccion());
			in.addValue("ID_PERSONA", d.getIdPersona());
						
			out = simpleJdbcCall.execute(in);

			result = Integer.parseInt(out.get("PN_COD_RESULTADO").toString());
			return result;
		} catch (Exception e) {
			System.out.println("Error al listar : " + e.getMessage());
			return -1;
		}
	}
	
	public Direccion buscarDireccion(Direccion d) {
		List<Direccion> lista = new ArrayList<>();
		Direccion result = null;
		Map<String, Object> out = new HashMap<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withSchemaName("CESAR")
					.withCatalogName("PCK_APP").withProcedureName("SP_BUSCAR_DIRECCION")
					.returningResultSet("AC_LISTA", new DireccionMapper());//AHI ESTA EL ERROR, ESTAS UTILIZANDO UN MAPPER PERSONA

			
			MapSqlParameterSource in = new MapSqlParameterSource();
			in.addValue("ID_ACTUALIZAR_", d.getId());
			
			
			out = simpleJdbcCall.execute(in);

			lista = (List<Direccion>) out.get("AC_LISTA");
			
			result = lista.get(0);
			return result;
		} catch (Exception e) {
			System.out.println("Error al listar : " + e.getMessage());
			return null;
		}
	}
	
	public int actualizarDireccion(Direccion d) {
		Integer result = 1;
		Map<String, Object> out = new HashMap<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withSchemaName("CESAR")
					.withCatalogName("PCK_APP").withProcedureName("SP_ACTUALIZAR_DIRECCION");

			
			MapSqlParameterSource in = new MapSqlParameterSource();
			in.addValue("ID_ACTUALIZAR_", d.getId());
			in.addValue("DISTRITO_", d.getDistrito());
			in.addValue("DIRECCION_", d.getDireccion());
			in.addValue("ID_PERSONA_", d.getIdPersona());
						
			out = simpleJdbcCall.execute(in);

			result = Integer.parseInt(out.get("PN_COD_RESULTADO").toString());
			return result;
		} catch (Exception e) {
			System.out.println("Error al listar : " + e.getMessage());
			return -1;
		}
	}
	
	public int borrarDireccion(Direccion d) {
		Integer result = 1;
		Map<String, Object> out = new HashMap<>();
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withSchemaName("CESAR")
					.withCatalogName("PCK_APP").withProcedureName("SP_BORRAR_DIRECCION");

			
			MapSqlParameterSource in = new MapSqlParameterSource();
			in.addValue("ID_DIRECCION", d.getId());
			
			out = simpleJdbcCall.execute(in);

			result = Integer.parseInt(out.get("PN_COD_RESULTADO").toString());
			return result;
		} catch (Exception e) {
			System.out.println("Error al listar : " + e.getMessage());
			return -1;
		}
	}

}
