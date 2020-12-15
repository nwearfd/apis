package com.junil.apis.repository;

import com.junil.apis.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
