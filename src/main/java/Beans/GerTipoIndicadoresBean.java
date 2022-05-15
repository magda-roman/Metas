/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import Classes.GerTipoIndXFaixas;
import Classes.GerTipoIndicadores;
import Services.GerTipoIndicadoresService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import utils.JsfUtil;

/**
 *
 * @author edumokfa
 */
@Named
@ViewScoped
public class GerTipoIndicadoresBean implements Serializable {

    @EJB
    GerTipoIndicadoresService gti;

    private GerTipoIndicadores tipoIndicadores = new GerTipoIndicadores();

    public void salva() {
        try {
            gti.salvar(tipoIndicadores);
            JsfUtil.exibeMensagem("Sucesso");
            tipoIndicadores = new GerTipoIndicadores();
        } catch (Exception e) {
            JsfUtil.fatal("Falha no cadastro");
        }
    }

    public void adiciona() {
        GerTipoIndXFaixas tpixf = new GerTipoIndXFaixas();
        tpixf.setTpfCodTipo(tipoIndicadores);
        tipoIndicadores.getTpIndXFaixas().add(tpixf);
        JsfUtil.exibeMensagem("Registro adicionado com sucesso");
    }

    public void remove(int index) {
        tipoIndicadores.getTpIndXFaixas().remove(index);
        JsfUtil.exibeMensagem("Registro removido com sucesso");
    }

    public GerTipoIndicadores getTipoIndicadores() {
        return tipoIndicadores;
    }

    public void setTipoIndicadores(GerTipoIndicadores tipoIndicadores) {
        this.tipoIndicadores = tipoIndicadores;
    }
}
