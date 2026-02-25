package com.cve.cveApp.controller;

import com.cve.cveApp.model.cve;
import com.cve.cveApp.service.cveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class cveController {

    @Autowired
    private cveService service;

    @GetMapping("/load")
    public String load() {
        service.loadCSV();
        return "CSV data stored successfully";
    }

  
    @GetMapping("/date/{date}")
    public List<cve> byDate(@PathVariable String date) {
        return service.getByDate(date);
    }

  
    @GetMapping("/month/{month}")
    public List<cve> byMonth(@PathVariable String month) {
        return service.getByMonth(month);
    }

    @GetMapping("/stats/{year}")
    public List<Double> stats(@PathVariable int year) {
        return service.getTemperatureStats(year);
    }
}