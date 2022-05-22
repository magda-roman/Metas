/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

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

    @SuppressWarnings("UnusedAssignment")
    public static boolean ValidaCNPJCPF(String sCnpjCpf) {
        if (sCnpjCpf == null) {
            return true;
        } else if (sCnpjCpf.length() == 11) {
            int d1, d2;
            int digito1, digito2, resto;
            int digitoCPF;
            String nDigResult;
            String strCpf = sCnpjCpf;

            if (strCpf.equals("00000000000") || strCpf.equals("11111111111")
                    || strCpf.equals("22222222222") || strCpf.equals("33333333333")
                    || strCpf.equals("44444444444") || strCpf.equals("55555555555")
                    || strCpf.equals("66666666666") || strCpf.equals("77777777777")
                    || strCpf.equals("88888888888") || strCpf.equals("99999999999")) {
                return false;
            }

            d1 = d2 = 0;
            digito1 = digito2 = resto = 0;

            for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
                digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1,
                        nCount));

                //multiplique a ultima casa por 2 a seguinte por 3 a
                //seguinte por 4 e assim por diante.
                d1 = d1 + (11 - nCount) * digitoCPF;

                //para o segundo digito repita o procedimento incluindo
                //o primeiro digito calculado no passo anterior.
                d2 = d2 + (12 - nCount) * digitoCPF;
            }
            //Primeiro resto da divisão por 11.
            resto = (d1 % 11);

            //Se o resultado for 0 ou 1 o digito 0 caso contrário o digito
            //11 menos o resultado anterior.
            if (resto < 2) {
                digito1 = 0;
            } else {
                digito1 = 11 - resto;
            }

            d2 += 2 * digito1;

            //Segundo resto da divisão por 11.
            resto = (d2 % 11);

            //Se o resultado for 0 ou 1 o digito 0 caso contrário o digito
            //11 menos o resultado anterior.
            if (resto < 2) {
                digito2 = 0;
            } else {
                digito2 = 11 - resto;
            }

            //Digito verificador do CPF que está sendo validado.
            String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());

            //Concatenando o primeiro resto com o segundo.
            nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

            //comparar o digito verificador do cpf com o
            //primeiro resto + o segundo resto.
            if (!(nDigVerific.equals(nDigResult))) {
                return false;
            }
        } else if (sCnpjCpf.length() == 14) {
            if (sCnpjCpf.equals("00000000000000")) {
                return false;
            }
            String str_cnpj = sCnpjCpf;
            int soma = 0, aux, dig;
            String cnpj_calc = str_cnpj.substring(0, 12);
            char[] chr_cnpj = str_cnpj.toCharArray();

            /* Primeira parte */
            for (int i = 0; i < 4; i++) {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                    soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++) {
                if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                    soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11)
                    ? "0" : Integer.toString(dig);

            /* Segunda parte */
            soma = 0;
            for (int i = 0; i < 5; i++) {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                    soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++) {
                if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                    soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11)
                    ? "0" : Integer.toString(dig);
            if (!str_cnpj.equals(cnpj_calc)) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    public static String leftPad(String str, String preenchimento, int tamanho) {
        return StringUtils.leftPad(str, tamanho, preenchimento);
    }
}
