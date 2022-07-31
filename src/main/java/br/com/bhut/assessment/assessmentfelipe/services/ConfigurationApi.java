package br.com.bhut.assessment.assessmentfelipe.services;

public class ConfigurationApi {

    private String bhutApi;

    public String getBhutApi() {
        bhutApi = "http://api-test.bhut.com.br:3000/api/cars";
        return bhutApi;
    }
}
