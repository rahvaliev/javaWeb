package com.example.mobilelele.service;

import com.example.mobilelele.model.view.OfferDetailsView;
import com.example.mobilelele.model.view.OfferSummaryView;

import java.util.List;

public interface OfferServiceIfc {
    void initializeOffer();
    List<OfferSummaryView> getOffers();

    OfferDetailsView getOfferDetails(Long id);
}
