/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
}
