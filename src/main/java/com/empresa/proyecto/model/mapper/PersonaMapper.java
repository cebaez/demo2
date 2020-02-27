package com.empresa.proyecto.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.empresa.proyecto.model.Persona;

public class PersonaMapper implements RowMapper<Persona> {

	@Override
	public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
		Persona per = new Persona();
		per.setId(rs.getInt("ID"));
		per.setDni(rs.getString("DNI"));
		per.setNombre(rs.getString("NOMBRE"));
		per.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
		per.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
		per.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
		per.setSexo(rs.getString("SEXO"));

		return per;
	}

}