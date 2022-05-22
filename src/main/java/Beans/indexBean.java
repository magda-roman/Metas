/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import Classes.MovIndXTipos;
import Classes.MovIndicadores;
import Services.MovIndicadoresService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import utils.DateUtil;

/**
 *
 * @author edumokfa
 */
@Named
@ViewScoped
public class indexBean implements Serializable {

    @EJB
    private MovIndicadoresService mis;

    private List<LineChartModel> lineModel1 = new ArrayList<>();
    private Date dataIni = new Date();
    private Date dataFim = new Date();

    @PostConstruct
    public void init() {
        dataFim = DateUtil.adicionaDias(dataFim, 30);
        pesquisar();
    }

    public void pesquisar() {
        List<MovIndicadores> movIndList = mis.buscaMovimentosPorPeriodo(dataIni, dataFim);

        for (MovIndicadores movIndicadores : movIndList) {
            LineChartModel lineModel = new LineChartModel();
            LineChartSeries series = new LineChartSeries();
            for (MovIndXTipos movIndXTipo : movIndicadores.getMovIndXTipos()) {
                series.set(movIndXTipo.getMviVlrResultado(), movIndXTipo.getMviPercCalculado());
            }
            lineModel.addSeries(series);
            lineModel1.add(lineModel);
        }
    }

    public List<LineChartModel> getLineModel1() {
        return lineModel1;
    }

    public void setLineModel1(List<LineChartModel> lineModel1) {
        this.lineModel1 = lineModel1;
    }

    public Date getDataIni() {
        return dataIni;
    }

    public void setDataIni(Date dataIni) {
        this.dataIni = dataIni;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

}
