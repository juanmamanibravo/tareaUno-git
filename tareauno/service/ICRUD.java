package com.tareauno.service;

import java.util.List;

public interface ICRUD <T,V>{
	T registrar(T pPaciente) throws Exception;

	T modificar(T pPaciente) throws Exception;

	List<T> listar() throws Exception;

	T listarPorId(V id) throws Exception;

	void eliminar(V id) throws Exception;
}
