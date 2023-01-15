package com.example.mobilelele.service;

import com.example.mobilelele.model.binding.OfferUpdateBindingModel;
import com.example.mobilelele.model.service.OfferUpdateServiceModel;
import com.example.mobilelele.model.view.OfferDetailsView;
import com.example.mobilelele.model.view.OfferSummaryView;

import java.util.List;

public interface OfferServiceIfc {
    void initializeOffer();
    List<OfferSummaryView> getOffers();

    OfferDetailsView getOfferDetails(Long id);
    void deleteOffer (Long id);

    void updateOffer(OfferUpdateServiceModel offerUpdateServiceModel);


}
