package utils;

import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.chart.BarChartModel;

/**
 *
 * @author edumokfa
 */
public class GraficoXLegenda {

    private String legenda;
    private BarChartModel barModel;

    public GraficoXLegenda() {
    }

    public GraficoXLegenda(String legenda, BarChartModel barModel) {
        this.legenda = legenda;
        this.barModel = barModel;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
}
