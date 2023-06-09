package com.engsoftware.heathgraph.controlers;

import com.engsoftware.heathgraph.entities.Crianca;
import com.engsoftware.heathgraph.entities.Registro;
import com.engsoftware.heathgraph.entities.Sexo;
import com.engsoftware.heathgraph.service.RegistroService;
import com.engsoftware.heathgraph.service.ZScoreCalculator;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/graficos")
public class GraficoControler {

    @Autowired
    private final RegistroService registroService;

    private Long idCrianca;
    private Crianca crianca;
    private List<Registro> registros;
    private Registro ultimoRegistro;
    private String sexo;

    // Criação do dataset
    DefaultCategoryDataset dataset;
    JFreeChart chart;

    @GetMapping("/pesoXidade/{id}")
    public String retornaGraficoPesoXidadeTeste(@PathVariable(value = "id") Long id) {
        this.idCrianca = id;
        registros = registroService.findAllRegistrosByIdCrianca(this.idCrianca);
        this.crianca = registros.get(0).getCrianca();
        this.sexo = crianca.getSexo() == Sexo.MASCULINO ? "Meninos" : "Meninas";

        int[] idades = new int[registros.size()];
        double [] pesos = new double [registros.size()];

        int j = 0;
        for(Registro registro: registros){
            idades[j] = registro.getIdade();
            pesos[j] = registro.getPeso();
            ultimoRegistro = registro;
            if(registro.getData().isAfter(ultimoRegistro.getData())){
                ultimoRegistro = registro;
            }
            j++;
        }
        // Criação do dataset
        XYSeries series = new XYSeries("Teste");
        this.dataset = new DefaultCategoryDataset();
        for (int i = 0; i < idades.length; i++) {
            series.add(pesos[i],idades[i]);
        }
        XYDataset dataset2 = new XYSeriesCollection(series);

        // Criação do gráfico
        this.chart = ChartFactory.createXYLineChart("Curva de crescimento de peso por idade (" + sexo + ")",
                "Peso (kg)", "Idade (anos)", dataset2, PlotOrientation.VERTICAL, true, true, false);


//        CategoryPlot plot = (CategoryPlot) chart.getPlot();
//        ValueAxis yAxis = plot.getRangeAxis();
//        yAxis.setRange(5, 25);
//

        DecimalFormat df = new DecimalFormat("#.###");
        // Adicionando a anotação com o valor final da série
        double ultimoValor = series.getY(series.getItemCount()-1).doubleValue();
        String zScore = df.format(ZScoreCalculator.calcularZScore(ultimoRegistro.getIdade(), ultimoRegistro.getPeso(), crianca.getSexo() == Sexo.FEMININO ? true : false ));
        XYTextAnnotation annotation = new XYTextAnnotation("Z-Score: " + zScore, series.getMaxX(), ultimoValor);
        annotation.setTextAnchor(TextAnchor.TOP_RIGHT);
        chart.getXYPlot().addAnnotation(annotation);

        return "grafico";
    }
    @GetMapping("/imc/{id}")
    public String retornaGraficoImc(@PathVariable(value = "id") Long id) {
        this.idCrianca = id;
        registros = registroService.findAllRegistrosByIdCrianca(this.idCrianca);
        this.crianca = registros.get(0).getCrianca();
        this.sexo = crianca.getSexo() == Sexo.MASCULINO ? "Meninos" : "Meninas";
        int[] alturas = new int[registros.size()];
        double [] pesos = new double [registros.size()];

        int j = 0;
        for(Registro registro: registros){
            alturas[j] = registro.getIdade();
            pesos[j] = registro.getPeso();
            ultimoRegistro = registro;
            if(registro.getData().isAfter(ultimoRegistro.getData())){
                ultimoRegistro = registro;
            }
            j++;
        }
        // Criação do dataset
        this.dataset = new DefaultCategoryDataset();
        for (int i = 0; i < alturas.length; i++) {
            dataset.addValue(pesos[i], "Peso médio", Double.toString(alturas[i]));
        }
        // Criação do gráfico
        this.chart = ChartFactory.createLineChart("Curva de crescimento do IMC (" + sexo + ")",
                "Altura (cm)", "Peso (kg)", dataset, PlotOrientation.VERTICAL, true, true, false);
        return "grafico";
    }
    @GetMapping("/alturaXidade/{id}")
    public String retornaGraficoAlturaXidade(@PathVariable(value = "id") Long id) {
        this.idCrianca = id;
        registros = registroService.findAllRegistrosByIdCrianca(this.idCrianca);
        this.crianca = registros.get(0).getCrianca();
        this.sexo = crianca.getSexo() == Sexo.MASCULINO ? "Meninos" : "Meninas";
        int[] idades = new int[registros.size()];
        double [] alturas = new double [registros.size()];

        int j = 0;
        for(Registro registro: registros){
            idades[j] = registro.getIdade();
            alturas[j] = registro.getAltura();
            ultimoRegistro = registro;
            if(registro.getData().isAfter(ultimoRegistro.getData())){
                ultimoRegistro = registro;
            }
            j++;
        }

        // Criação do dataset
        this.dataset = new DefaultCategoryDataset();
        for (int i = 0; i < alturas.length; i++) {
            dataset.addValue(idades[i], "Altura média", Double.toString(alturas[i]));
        }

        // Criação do gráfico
        this.chart = ChartFactory.createLineChart("Curva de crescimento de altura por idade (" + sexo + ")",
                "Altura (cm)", "Idade (anos)", dataset, PlotOrientation.VERTICAL, true, true, false);
        return "grafico"; }
    @GetMapping("/imcXidade/{id}")
    public String retornaGraficoImcXidade(@PathVariable(value = "id") Long id) {
        this.idCrianca = id;
        registros = registroService.findAllRegistrosByIdCrianca(this.idCrianca);
        this.crianca = registros.get(0).getCrianca();
        this.sexo = crianca.getSexo() == Sexo.MASCULINO ? "Menino" : "Menina";
        int[] idades = new int[registros.size()];
        double [] imcs = new double [registros.size()];

        int j = 0;
        for(Registro registro: registros){
            idades[j] = registro.getIdade();
            imcs[j] = registro.getPeso();
            ultimoRegistro = registro;
            if(registro.getData().isAfter(ultimoRegistro.getData())){
                ultimoRegistro = registro;
            }
            j++;
        }

        // Criação do dataset
        XYSeries series = new XYSeries("IMC médio");
        //this.dataset = new DefaultCategoryDataset();
        for (int i = 0; i < idades.length; i++) {
            series.add(imcs[i],idades[i]);
        }
        XYDataset dataset = new XYSeriesCollection(series);

        // Criação do gráfico
        this.chart = ChartFactory.createXYLineChart("Curva de crescimento do IMC por idade (" + sexo + ")",
                "Idade (anos)", "IMC", dataset, PlotOrientation.VERTICAL, true, true, false);
        return "grafico";  }



    @GetMapping("/gerarGrafico")
    @ResponseBody
    public byte[] gerarGrafico() throws IOException {

        // Criação da imagem
        BufferedImage bufferedImage = chart.createBufferedImage(900, 600);
        // Conversão para bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);

        return baos.toByteArray();
    }



}