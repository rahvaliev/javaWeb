package com.ex.examTR.service;

import com.ex.examTR.model.service.OfferServiceModel;
import com.ex.examTR.model.view.OfferViewModel;

import java.util.List;

public interface OfferService {
    void save(OfferServiceModel offerServiceModel);

    List<OfferViewModel> myOffers();

    List<OfferViewModel> allOthersOffer();

    List<OfferViewModel> myBoughtItems();

    void removeOfferById(Long id);

    void BuyById(Long id);
}
