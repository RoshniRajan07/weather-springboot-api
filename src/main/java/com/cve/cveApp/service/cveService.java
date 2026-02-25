package com.cve.cveApp.service;

import com.cve.cveApp.model.cve;
import java.util.List;

public interface cveService {

    void loadCSV();

    List<cve> getByDate(String date);

    List<cve> getByMonth(String month);

    List<Double> getTemperatureStats(int year);
}