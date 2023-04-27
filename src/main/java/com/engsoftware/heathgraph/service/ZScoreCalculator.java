package com.engsoftware.heathgraph.service;

import org.apache.commons.math3.distribution.NormalDistribution;

public class ZScoreCalculator {

    // Média e desvio padrão para a população de referência
    private static final int [] IDADES = new int []{0,1,2,3,4,5};
    private static final double [] DADOS_REF_MEAN_MASCULINO = new double[]{3.3464, 9.6490, 12.1515, 14.3429, 16.3489, 18.3366};
    private static final double [] DADOS_REF_SD_MASCULINO = new double[]{0.14602, 0.10925, 0.11426, 0.12186, 0.12759, 0.13517};

    private static final double [] DADOS_REF_MEAN_FEMININO = new double[]{3.2322, 8.9481, 11.4775, 13.8503, 16.0397, 18.2193};
    private static final double [] DADOS_REF_SD_FEMININO = new double[]{0.14151, 0.12268, 0.12390, 0.12919, 0.13884, 0.14821};

    public static Double calcularZScore(int idade, double pesoKg, boolean isFemale){

        double REF_MEAN = 0.0;
        double REF_SD = 0.0;
        for(int i = 0; i < IDADES.length ; i++){
            if(idade == IDADES[i]){
                if(isFemale){
                    REF_MEAN = DADOS_REF_MEAN_FEMININO[i];
                    REF_SD = DADOS_REF_SD_FEMININO[i];
                }else{
                    REF_MEAN = DADOS_REF_MEAN_MASCULINO[i];
                    REF_SD = DADOS_REF_SD_MASCULINO[i];
                }
            }
        }
        // Cálculo do Z-score
        double zScore = (pesoKg - REF_MEAN) / REF_SD;

        // Cálculo do percentil
//        NormalDistribution normDist = new NormalDistribution();
//        double percentile = normDist.cumulativeProbability(zScore) * 100.0;

        // Exibição dos resultados
        return zScore;

    }
}
