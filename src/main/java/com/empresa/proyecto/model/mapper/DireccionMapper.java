package com.empresa.proyecto.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.empresa.proyecto.model.Direccion;

public class DireccionMapper implements RowMapper<Direccion> {

	@Override
	public Direccion mapRow(ResultSet rs, int rowNum) throws SQLException {
		Direccion dir = new Direccion();
		dir.setId(rs.getInt("ID"));
		dir.setDistrito(rs.getString("DISTRITO"));
		dir.setDireccion(rs.getString("DIRECCION"));
		dir.setIdPersona(rs.getInt("ID_PERSONA"));
		return dir;
	}

}
