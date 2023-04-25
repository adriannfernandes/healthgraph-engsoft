package com.engsoftware.heathgraph.controlers;

import com.engsoftware.heathgraph.service.RegistroService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/graficos")
public class GraficoControler {

    @Autowired
    private final RegistroService registroService;

    @GetMapping("/pesoXidade")
    public String retornaGraficoPesoXidade() { return "pesoXidade"; }
    @GetMapping("/imc")
    public String retornaGraficoImc() {        return "imc";    }
    @GetMapping("/alturaXidade")
    public String retornaGraficoAlturaXidade() { return "alturaXidade"; }
    @GetMapping("/imcXidade")
    public String retornaGraficoImcXidade() {   return "imcXidade";  }

    @GetMapping("/gerarGraficoPesoXidade")
    @ResponseBody
    public byte[] gerarGraficoPesoXidade() throws IOException {

        // Dados de exemplo (médias de peso por idade para meninos)
        int[] idades = {0, 1, 2, 3, 4, 5};
        double[] pesos = {3.4, 9.5, 12.6, 15.3, 17.2, 90.0};

        // Criação do dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < idades.length; i++) {
            dataset.addValue(pesos[i], "Peso médio", Integer.toString(idades[i]));
        }

        // Criação do gráfico
        JFreeChart chart = ChartFactory.createLineChart("Curva de crescimento de peso por idade (meninos)",
                "Idade (anos)", "Peso (kg)", dataset, PlotOrientation.VERTICAL, true, true, false);

        // Criação da imagem
        BufferedImage bufferedImage = chart.createBufferedImage(1400, 1000);

        // Conversão para bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);

        return baos.toByteArray();
    }

    @GetMapping("/gerarGraficoAlturaXidade")
    @ResponseBody
    public byte[] gerarGraficoAlturaXidade() throws IOException {

        // Dados de exemplo (médias de altura por idade para meninos)
        double[] alturas = {0, 1, 2, 3, 4, 5};
        int[] idade = {3, 9, 12, 15, 17, 90};

        // Criação do dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < alturas.length; i++) {
            dataset.addValue(idade[i], "Altura média", Double.toString(alturas[i]));
        }

        // Criação do gráfico
        JFreeChart chart = ChartFactory.createLineChart("Curva de crescimento de altura por idade (meninos)",
                "Altura (cm)", "Idade (anos)", dataset, PlotOrientation.VERTICAL, true, true, false);

        // Criação da imagem
        BufferedImage bufferedImage = chart.createBufferedImage(1400, 1000);

        // Conversão para bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);

        return baos.toByteArray();
    }

    @GetMapping("/gerarGraficoImcXidade")
    @ResponseBody
    public byte[] gerarGraficoImcXidade() throws IOException {

        // Dados de exemplo (médias de peso por idade para meninos)
        int[] idades = {0, 1, 2, 3, 4, 5};
        double[] imc = {3.4, 9.5, 12.6, 15.3, 17.2, 90.0};

        // Criação do dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < idades.length; i++) {
            dataset.addValue(imc[i], "IMC médio", Integer.toString(idades[i]));
        }

        // Criação do gráfico
        JFreeChart chart = ChartFactory.createLineChart("Curva de crescimento do IMC por idade (meninos)",
                "Idade (anos)", "IMC", dataset, PlotOrientation.VERTICAL, true, true, false);

        // Criação da imagem
        BufferedImage bufferedImage = chart.createBufferedImage(1400, 1000);

        // Conversão para bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);

        return baos.toByteArray();
    }

    @GetMapping("/gerarGraficoImc")
    @ResponseBody
    public byte[] gerarGraficoImc() throws IOException {

        // Dados de exemplo (médias de peso por idade para meninos)
        double[] alturas = {1.60, 1.61, 1.62, 1.63, 1.64, 1.65};
        double[] pesos = {3.4, 9.5, 12.6, 15.3, 17.2, 90.0};

        // Criação do dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < alturas.length; i++) {
            dataset.addValue(pesos[i], "Peso médio", Double.toString(alturas[i]));
        }

        // Criação do gráfico
        JFreeChart chart = ChartFactory.createLineChart("Curva de crescimento do IMC (meninos)",
                "Altura (cm)", "Peso (kg)", dataset, PlotOrientation.VERTICAL, true, true, false);

        // Criação da imagem
        BufferedImage bufferedImage = chart.createBufferedImage(1400, 1000);

        // Conversão para bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);

        return baos.toByteArray();
    }
}