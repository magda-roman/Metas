/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Security;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Eduardo.M
 */
public class GerenciaPrivilegiosUtil {

    private static GerenciaPrivilegiosUtil wipe = null;

    public static GerenciaPrivilegiosUtil getGerenciaPrivilegiosUtil() {
        return wipe;
    }

    @Autowired
    public void setGerenciaPrivilegiosUtil(GerenciaPrivilegiosUtil gerenciaPrivilegiosUtil) {
        this.wipe = gerenciaPrivilegiosUtil;
    }
}
