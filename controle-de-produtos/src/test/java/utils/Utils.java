package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

        public static String converterParaFormatoIso(String data) {
        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoSaida = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        LocalDate dataConvertida = LocalDate.parse(data, formatoEntrada);
        return dataConvertida.format(formatoSaida);
        }
}
