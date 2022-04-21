package utils;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Eduardo
 */
public class JsfUtil {

    public static void exibeErro(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", mensagem));
    }

    public static void exibeMensagem(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem", mensagem));
    }

    public static void exibeAviso(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", mensagem));
    }

    public static void redirecionar(String page) {
        if (page == null) {
            page = "";
        }
        try {
            getEC().redirect(getAppPath() + page);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static ExternalContext getEC() {
        return FacesContext.getCurrentInstance().getExternalContext();
    }

    public static String getAppPath() {
        return getEC().getRequestContextPath();
    }
}
