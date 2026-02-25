package com.cve.cveApp.repository;
import com.cve.cveApp.model.cve;
import org.springframework.data.jpa.repository.JpaRepository;
public interface cveRepository extends JpaRepository<cve,String> {
    
}
