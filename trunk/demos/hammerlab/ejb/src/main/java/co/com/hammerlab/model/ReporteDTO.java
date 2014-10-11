package com.j4.reporte;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReporteDTO {

	private List<RegistroActividadesDTO> listaRegistro = new ArrayList<RegistroActividadesDTO>();

	public List<RegistroActividadesDTO> getListaRegistro() {
		return listaRegistro;
	}

	public void setListaRegistro(List<RegistroActividadesDTO> listaRegistro) {
		this.listaRegistro = listaRegistro;
	}

	public JRDataSource getRegistroDS() {
		return new JRBeanCollectionDataSource(listaRegistro);
	}

}
