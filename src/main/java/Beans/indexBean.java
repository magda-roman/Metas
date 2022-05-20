/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author edumokfa
 */
@Named
@ViewScoped
public class indexBean implements Serializable {

    private List<LineChartModel> lineModel1 = new ArrayList<>();

    @PostConstruct
    public void init() {
        LineChartModel lineModel = new LineChartModel();
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");

        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
        lineModel.addSeries(series1);

        LineChartModel lineMode2 = new LineChartModel();
        LineChartSeries series2 = new LineChartSeries();
        series1.setLabel("Series 2");

        series2.set(25, 25);
        series2.set(30, 30);
        series2.set(35, 35);
        series2.set(40, 40);
        series2.set(45, 45);
        series2.set(50, 50);
        lineMode2.addSeries(series2);
        lineModel1.add(lineModel);
        lineModel1.add(lineMode2);
        lineModel1.add(lineMode2);
        lineModel1.add(lineMode2);
        lineModel1.add(lineMode2);
    }

    public List<LineChartModel> getLineModel1() {
        return lineModel1;
    }

    public void setLineModel1(List<LineChartModel> lineModel1) {
        this.lineModel1 = lineModel1;
    }
}
