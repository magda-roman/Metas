/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import Classes.GerTipoIndXFaixas;
import Classes.GerTipoIndicadores;
import Classes.MovIndXTipos;
import Classes.MovIndicadores;
import Services.GerTipoIndicadoresService;
import Services.MovIndicadoresService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class MovIndicadoresBean implements Serializable {

    @EJB
    private MovIndicadoresService mis;
    @EJB
    private GerTipoIndicadoresService gti;

    private MovIndicadores movIndicadores = new MovIndicadores();
    private GerTipoIndicadores tpInd;
    private Integer codTpInd;

    @PostConstruct
    private void init() {
        movIndicadores.setMovDtHr(new Date());
    }

    public void salva() {
        try {
            mis.salvar(movIndicadores);
            JsfUtil.exibeMensagem("Sucesso");
            movIndicadores = new MovIndicadores();
        } catch (Exception e) {
            JsfUtil.fatal("Falha no cadastro");
        }
    }

    public void atualizaPercentual(MovIndXTipos mov) {
        if (mov.getMviVlrResultado() != null) {
            GerTipoIndicadores tpind = mis.buscaIndicadorPorValor(mov.getMviVlrResultado());
            mov.setMviCodTipo(tpind);
            mov.setMviPercCalculado(buscaFaixaPorValor(tpind.getTpIndXFaixas(), mov.getMviVlrResultado()).getTpfPercPremiacao());
        } else {
            tpInd = null;
        }
    }

    private GerTipoIndXFaixas buscaFaixaPorValor(List<GerTipoIndXFaixas> tpInd, Double valor) {
        GerTipoIndXFaixas retorno = null;
        for (GerTipoIndXFaixas tpIndXFaixas : tpInd) {
            if (tpIndXFaixas.getTpfFaixaIni() <= valor && tpIndXFaixas.getTpfFaixaFim() >= valor) {
                retorno = tpIndXFaixas;
            }
        }
        return retorno;
    }

    public void adiciona() {
        if (tpInd == null) {
            JsfUtil.exibeAviso("Selecione um tipo de indicador");
            return;
        }
        MovIndXTipos mixt = new MovIndXTipos();
        mixt.setMviCodIndi(movIndicadores);
        movIndicadores.getMovIndXTipos().add(mixt);
        JsfUtil.exibeMensagem("Registro adicionado com sucesso");
    }

    public void remove(int index) {
        movIndicadores.getMovIndXTipos().remove(index);
        JsfUtil.exibeMensagem("Registro removido com sucesso");
    }

    public void buscaTpInd() {
        movIndicadores.getMovIndXTipos().clear();
        tpInd = gti.busca(codTpInd);
        if (tpInd == null) {
            JsfUtil.exibeAviso("Nenhum indicador com este código foi encontrado");
        }
    }

    public String getItemLabelTpInd() {
        String retorno = "Selecione um tipo de indicador";
        if (tpInd != null && tpInd.getTpiDesc() != null) {
            retorno = tpInd.getTpiDesc();
        }
        return retorno;
    }

    public MovIndicadores getMovIndicadores() {
        return movIndicadores;
    }

    public void setMovIndicadores(MovIndicadores movIndicadores) {
        this.movIndicadores = movIndicadores;
    }

    public GerTipoIndicadores getTpInd() {
        return tpInd;
    }

    public void setTpInd(GerTipoIndicadores tpInd) {
        this.tpInd = tpInd;
    }

    public Integer getCodTpInd() {
        return codTpInd;
    }

    public void setCodTpInd(Integer codTpInd) {
        this.codTpInd = codTpInd;
    }
}
