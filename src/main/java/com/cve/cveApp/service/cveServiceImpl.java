package com.cve.cveApp.service;

import com.cve.cveApp.model.cve;
import com.cve.cveApp.repository.cveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class cveServiceImpl implements cveService {

    @Autowired
    private cveRepository repo;

    @Override
    public void loadCSV() {

        String file = "C:\\Users\\Roshini\\Downloads\\Weather data assessment csv\\Assessment 2\\testset.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            boolean first = true;

            while ((line = br.readLine()) != null) {

                if (first) { first = false; continue; }

                String[] d = line.split(",");

                cve w = new cve();

         
                String raw = d[0];
                String year = raw.substring(0,4);
                String month = raw.substring(4,6);
                String day = raw.substring(6,8);

                String formatted = year + "." + month + "." + day;
                w.setDatetimeUtc(formatted);

                w.setConds(d[1]);
                w.setTempm(parseDouble(d[11]));
                w.setHum(parseDouble(d[6]));
                w.setPressurem(parseDouble(d[8]));

                repo.save(w);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<cve> getByDate(String date) {
        return repo.findAll().stream()
                .filter(x -> x.getDatetimeUtc().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<cve> getByMonth(String month) {
        return repo.findAll().stream()
                .filter(x -> x.getDatetimeUtc().split("\\.")[1].equals(month))
                .collect(Collectors.toList());
    }

    @Override
    public List<Double> getTemperatureStats(int year) {

        List<Double> temps = repo.findAll().stream()
                .filter(x -> x.getDatetimeUtc().startsWith(String.valueOf(year)))
                .map(cve::getTempm)
                .filter(Objects::nonNull)
                .sorted()
                .collect(Collectors.toList());

        if (temps.isEmpty()) return List.of();

        double min = temps.get(0);
        double max = temps.get(temps.size()-1);
        double median = temps.get(temps.size()/2);

        return List.of(min, median, max);
    }

    private Double parseDouble(String v){
        try { return Double.parseDouble(v); }
        catch(Exception e){ return null; }
    }
}