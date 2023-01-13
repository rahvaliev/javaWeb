package com.example.mobilelele.web;

import com.example.mobilelele.service.OfferServiceIfc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OfferController {
    private final OfferServiceIfc offerServiceIfc;

    public OfferController(OfferServiceIfc offerServiceIfc) {
        this.offerServiceIfc = offerServiceIfc;
    }

    @GetMapping("/offers/all")
    public String offersAll(Model model){
        model.addAttribute("offers",offerServiceIfc.getOffers());
        return "offers";
    }

    @GetMapping("/offer/{id}/details")
    public String showDetails(@PathVariable Long id){
        return "details";
    }
}
