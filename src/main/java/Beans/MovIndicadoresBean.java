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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import utils.JsfUtil;
import utils.ListUtil;

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

    @Inject
    private AcessoBean acesso;

    private MovIndicadores movIndicadores = new MovIndicadores();
    private GerTipoIndicadores tpInd;
    private Integer codTpInd;
    private List<GerTipoIndicadores> tipoIndicadoresList = new ArrayList<>();
    private List<MovIndicadores> movIndicadoresList = new ArrayList<>();

    @PostConstruct
    private void init() {
        if (acesso.getUl() == null || !acesso.getUl().isAdmin()) {
            JsfUtil.redirecionar("/publico/index.xhtml");
        }
        movIndicadores.setMovDtHr(new Date());
    }

    public void pesquisaIndicadores() {
        Map<String, Object> filtros = new HashMap<>();
        filtros.put("tpiAtivo", true);
        tipoIndicadoresList = gti.filtrar(filtros);
        JsfUtil.showDlg("dlgBscIndicadores");
    }

    public void selecionaMovimento(MovIndicadores mvInd) {
        movIndicadores = mvInd;
    }

    public void pesquisa() {
        movIndicadoresList = mis.buscaLista();
        JsfUtil.showDlg("dlgBscMovimentos");
    }

    public void salva() {
        try {
            mis.salvar(movIndicadores);
            JsfUtil.exibeMensagem("Sucesso");
            movIndicadores = new MovIndicadores();
            movIndicadores.setMovDtHr(new Date());
        } catch (Exception e) {
            JsfUtil.fatal("Falha no cadastro");
        }
    }

    public void cancela() {
        movIndicadores = new MovIndicadores();
    }

    public void excluir() {
        if (movIndicadores.getMovCod() == null) {
            JsfUtil.exibeAviso("Pesquise um Movimento para excluí-lo");
            return;
        }
        mis.excluir(movIndicadores);
        JsfUtil.exibeMensagem("Movimento excluído com sucesso");
        cancela();
    }

    public void atualizaPercentual(MovIndXTipos mov) {
        if (mov.getMviVlrResultado() != null) {
            GerTipoIndicadores tpind = mis.buscaIndicadorPorValor(mov.getMviVlrResultado(), mov.getMviCodTipo().getTpiCod());
            if (tpind == null || tpind.getTpiCod() == null) {
                JsfUtil.exibeAviso("Não foi possível calcular um percentual para este valor");
                return;
            }
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
        String retorno = "Digite o código";
        if (tpInd != null && tpInd.getTpiDesc() != null) {
            retorno = tpInd.getTpiDesc();
        }
        return retorno;
    }

    public void selecionaTpInd(GerTipoIndicadores tipoInd) {
        if (ListUtil.isNotEmpty(movIndicadores.getMovIndXTipos())) {
            for (MovIndXTipos mixt : movIndicadores.getMovIndXTipos()) {
                if (mixt.getMviCodTipo().equals(tipoInd)) {
                    JsfUtil.exibeAviso("Este tipo de indicador já foi adicionado na lista");
                    return;
                }
            }
        }
        tpInd = tipoInd;
        MovIndXTipos mixt = new MovIndXTipos();
        mixt.setMviCodIndi(movIndicadores);
        mixt.setMviCodTipo(tpInd);
        movIndicadores.getMovIndXTipos().add(mixt);
        JsfUtil.exibeMensagem("Registro adicionado com sucesso");
        JsfUtil.hideDlg("dlgBscIndicadores");
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

    public List<GerTipoIndicadores> getTipoIndicadoresList() {
        return tipoIndicadoresList;
    }

    public void setTipoIndicadoresList(List<GerTipoIndicadores> tipoIndicadoresList) {
        this.tipoIndicadoresList = tipoIndicadoresList;
    }

    public List<MovIndicadores> getMovIndicadoresList() {
        return movIndicadoresList;
    }

    public void setMovIndicadoresList(List<MovIndicadores> movIndicadoresList) {
        this.movIndicadoresList = movIndicadoresList;
    }
}
