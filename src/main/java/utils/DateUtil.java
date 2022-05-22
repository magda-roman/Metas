/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author edumokfa
 */
public class DateUtil {

    public static String dataFormatada(XMLGregorianCalendar d) {
        Date data = ((XMLGregorianCalendar) d).toGregorianCalendar().getTime();
        return getDateFormat().format(data);
    }

    public static String dataFormatada(Date d) {
        if (d == null) {
            return "";
        }
        try {
            return getDateFormat().format(d);
        } catch (Exception e) {
            return "";
        }
    }

    public static DateFormat getDateFormat() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
        df.setLenient(false);
        return df;
    }

    public static String dataFirebird(Date date) {
        LocalDate data = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String dia = StringUtil.leftPad(String.valueOf(data.getDayOfMonth()), "0", 2);
        String mes = StringUtil.leftPad(String.valueOf(data.getMonthValue()), "0", 2);
        String ano = String.valueOf(data.getYear());
        return "'" + String.format("%s/%s/%s", mes, dia, ano) + "'";
    }

    public static Date adicionaDias(Date d, int nrDias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DAY_OF_MONTH, nrDias);
        return calendar.getTime();
    }
}
