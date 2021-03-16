package Controlador;

import Vista.ResultadosFRM;

public class controladorResultados {
	ResultadosFRM ventana;
	
	public controladorResultados(int porcentajeObtenido,String[] estadosRespuesta,String[] respCorrectas,String[] respUsuario) {
		ventana = new ResultadosFRM(porcentajeObtenido);
		ventana.txtrHolaSi.setText(crearString(estadosRespuesta,respCorrectas,respUsuario));
	}
	
	private String crearString(String[] estadosRespuesta,String[] respCorrectas,String[] respUsuario) {
		String resultados = "";
		for(int i = 0;i<estadosRespuesta.length;i++) {
			if(i!= estadosRespuesta.length-1) {
				resultados = resultados+"PREGUNTA "+(i+1)+": "+estadosRespuesta[i].toUpperCase()+",  R: "+respUsuario[i]+"  ,Solucion: "+respCorrectas[i]+"\n";
			}else {
				resultados = resultados+"PREGUNTA "+(i+1)+": "+estadosRespuesta[i].toUpperCase()+",  R: "+respUsuario[i]+"  ,Solucion: "+respCorrectas[i];
			}
		}
		return resultados;
	}
}
