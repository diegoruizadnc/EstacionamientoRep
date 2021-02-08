package com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad;

import java.util.Date;

import com.ceiba.reservasbarultimate.comun.dominio.excepciones.CampoRequeridoExcepcion;
import com.ceiba.reservasbarultimate.comun.dominio.excepciones.ValorNoValidoExcepcion;
import com.ceiba.reservasbarultimate.util.Utiles;

public final class ValidadorCamposReserva {

	private ValidadorCamposReserva() {
	}

	public static void validarNumeroMesa(Integer idMesa, String errorMessage) {
		if (idMesa == null) {
			throw new CampoRequeridoExcepcion(errorMessage);
		}
		if (idMesa < 0 || idMesa > 9) {
			throw new ValorNoValidoExcepcion(errorMessage);
		}

	}

	public static void validarCantidadPersonas(Integer cantidadPersonas, String errorMessage) {
		if (cantidadPersonas == null) {
			throw new CampoRequeridoExcepcion(errorMessage);
		}
		if (cantidadPersonas <= 0 || cantidadPersonas > 5) {
			throw new ValorNoValidoExcepcion(errorMessage);
		}
	}

	public static void validarDocumentoUsuarioValido(Long idUsuario, Long longitudMinimaDoc, Long longitudMaximaDoc,
			String errorMessage) {

		if (idUsuario == null) {
			throw new CampoRequeridoExcepcion(errorMessage);
		}

		Boolean longitudMaximaDocumentoValida = Utiles.validaMaxCaracteres(idUsuario.toString(), longitudMaximaDoc);
		Boolean longitudMinimaDocumentoValida = Utiles.validaMinimaCaracteres(idUsuario.toString(), longitudMinimaDoc);

		if (!longitudMaximaDocumentoValida || !longitudMinimaDocumentoValida) {
			throw new ValorNoValidoExcepcion(errorMessage);
		}
	}

	public static void validarDiaReservaValido(Date fechaHoy, String errorMessage) {

		int dia = Utiles.obtenerDiaSemana(fechaHoy);

		if (dia < 3 || dia == 7) {
			throw new ValorNoValidoExcepcion(errorMessage);
		}
	}

}
