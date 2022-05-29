package utils;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

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

    public static void fatal(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro", mensagem));
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

    public static void hideDlg(String... wVars) {
        for (String wvs : wVars) {
            primeFacesExecute("PF('" + wvs + "').hide();");
        }
    }

    public static void showDlg(String... wVars) {
        for (String wvs : wVars) {
            primeFacesExecute("PF('" + wvs + "').show();");
        }
    }

    public static void primeFacesExecute(String summary) {
        PrimeFaces.current().executeScript(summary);
    }

    public static void primeFacesUpdate(String... summary) {
        PrimeFaces.current().ajax().update(summary);
    }
}
