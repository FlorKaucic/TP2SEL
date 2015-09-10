package sel;

import java.util.GregorianCalendar;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar tIni = new GregorianCalendar();
		
		// aca va el codigo que llame a las funciones
		
		Calendar tFin = new GregorianCalendar();

		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println(diff);
	}
	
}
