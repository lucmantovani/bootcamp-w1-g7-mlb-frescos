package com.mercadolibre.bootcamp_w1_g7_mlb_frescos.repository;

import com.mercadolibre.bootcamp_w1_g7_mlb_frescos.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BatchRepository  extends JpaRepository<Batch, Integer> {

}
