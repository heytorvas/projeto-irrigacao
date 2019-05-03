import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;

@Named
public class ChartJsView implements Serializable {

	private LineChartModel lineModel;
	private LineChartModel lineTemp;
	private LineChartModel lineUmi;
	private LineChartModel lineLumi;
	private LineChartModel lineSolo;

	@PostConstruct
	public void init() {

		createLineModel();

	}

	public void createLineModel() {
		lineModel = new LineChartModel();
		ChartData data = new ChartData();

		LineChartDataSet dataSet = new LineChartDataSet();
		List<Number> values = new ArrayList<>();
		values.add(65);
		values.add(59);
		values.add(80);
		values.add(81);
		values.add(56);
		dataSet.setData(values);
		dataSet.setFill(false);
		dataSet.setLabel("Histórico");
		dataSet.setBorderColor("rgb(178, 34, 34)");
		dataSet.setLineTension(0.1);
		data.addChartDataSet(dataSet);

		List<String> labels = new ArrayList<>();
		labels.add("08:00");
		labels.add("09:00");
		labels.add("10:00");
		labels.add("11:00");
		labels.add("12:00");
		data.setLabels(labels);

		// Options
		LineChartOptions options = new LineChartOptions();
		Title title = new Title();
		title.setDisplay(true);
		title.setText("TEMPERATURA");
		options.setTitle(title);

		lineModel.setOptions(options);
		lineModel.setData(data);
	}

	public void createLineTemp() {
		lineTemp = new LineChartModel();
		ChartData data = new ChartData();

		LineChartDataSet dataSet = new LineChartDataSet();
		List<Number> values = new ArrayList<>();
		values.add(65);
		values.add(59);
		values.add(80);
		values.add(81);
		values.add(56);
		values.add(55);
		values.add(40);
		dataSet.setData(values);
		dataSet.setFill(false);
		dataSet.setLabel("Histórico");
		dataSet.setBorderColor("rgb(24, 34, 34)");
		dataSet.setLineTension(0.1);
		data.addChartDataSet(dataSet);

		List<String> labels = new ArrayList<>();
		labels.add("08:00");
		labels.add("09:00");
		labels.add("10:00");
		labels.add("11:00");
		labels.add("12:00");
		labels.add("13:00");
		labels.add("14:00");
		data.setLabels(labels);

		// Options
		LineChartOptions options = new LineChartOptions();
		Title title = new Title();
		title.setDisplay(true);
		title.setText("UMIDADE DO AR");
		options.setTitle(title);

		lineTemp.setOptions(options);
		lineTemp.setData(data);
	}

	public void itemSelect(ItemSelectEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
				"Item Index: " + event.getItemIndex() + ", DataSet Index:" + event.getDataSetIndex());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public LineChartModel getLineModel() {
		return lineModel;
	}

	public void setLineModel(LineChartModel lineModel) {
		this.lineModel = lineModel;
	}

	public LineChartModel getLineTemp() {
		return lineTemp;
	}

	public void setLineTemp(LineChartModel lineTemp) {
		this.lineTemp = lineTemp;
	}

	public LineChartModel getLineUmi() {
		return lineUmi;
	}

	public void setLineUmi(LineChartModel lineUmi) {
		this.lineUmi = lineUmi;
	}

	public LineChartModel getLineLumi() {
		return lineLumi;
	}

	public void setLineLumi(LineChartModel lineLumi) {
		this.lineLumi = lineLumi;
	}

	public LineChartModel getLineSolo() {
		return lineSolo;
	}

	public void setLineSolo(LineChartModel lineSolo) {
		this.lineSolo = lineSolo;
	}

}