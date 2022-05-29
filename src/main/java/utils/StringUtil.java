/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.InputMismatchException;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author edumokfa
 */
public class StringUtil {

    public static boolean nullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean notNullOrEmpty(String str) {
        return !nullOrEmpty(str);
    }

    public static String StrToHex(String sStr) {
        int i;
        String sOut = "";
        for (i = 0; (i < sStr.length()); i++) {
            sOut += byteToHex((byte) sStr.charAt(i));
        }
        return (sOut);
    }

    public static String onlyNumbers(String entrada) {
        return entrada.replaceAll("[\\D]", "");
    }

    public static String HexToStr(String sHexa) {
        int i = 0;
        int x = 0;
        String sOut = "";
        while (i < sHexa.length()) {
            sOut += (char) Integer.parseInt(sHexa.substring(i, i + 2), 16);
            //x = Integer.parseInt(sHexa.substring(i,i+2), 16);
            //sOut+=new Character((char)x).toString();
            i = i + 2;
        }
        return (sOut);
    }

    public static String byteToHex(int valor) {
        int d1 = valor & 0xF;
        d1 += (d1 < 10) ? 48 : 55;
        int d2 = (valor & 0xF0) >> 4;
        d2 += (d2 < 10) ? 48 : 55;
        String ret = "" + (char) d2 + (char) d1;
        return ret;
    }

    public static boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public static String leftPad(String str, String preenchimento, int tamanho) {
        return StringUtils.leftPad(str, tamanho, preenchimento);
    }
}
