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

    @GetMapping("/pesoXaltura")
    public String retornaTeste() {
        return "pesoXaltura";
    }

    @GetMapping("/gerarGraficoPesoXaltura")
    @ResponseBody
    public byte[] gerarGraficoPesoXaltura() throws IOException {

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
        BufferedImage bufferedImage = chart.createBufferedImage(500, 300);

        // Conversão para bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);

        return baos.toByteArray();
    }
}