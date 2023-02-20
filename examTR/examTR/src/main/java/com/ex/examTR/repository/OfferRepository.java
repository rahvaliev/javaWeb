package com.ex.examTR.repository;

import com.ex.examTR.model.entity.Offer;
import com.ex.examTR.model.view.OfferViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {
    List<Offer> findAllByUser_IdOrderByPrice(Long user_id);
    List<Offer> findAllByUser_IdNotAndAndBoughtByNull(Long user_id);

    List<Offer> findAllByBoughtBy(Long boughtBy);
}
