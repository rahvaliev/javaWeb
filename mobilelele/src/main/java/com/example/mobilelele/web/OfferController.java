package com.example.mobilelele.web;

import com.example.mobilelele.model.binding.OfferUpdateBindingModel;
import com.example.mobilelele.model.enums.EngineEnum;
import com.example.mobilelele.model.enums.TransmissionEnum;
import com.example.mobilelele.model.service.OfferUpdateServiceModel;
import com.example.mobilelele.service.OfferServiceIfc;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OfferController {
    private final OfferServiceIfc offerServiceIfc;
    private final ModelMapper modelMapper;

    public OfferController(OfferServiceIfc offerServiceIfc, ModelMapper modelMapper) {
        this.offerServiceIfc = offerServiceIfc;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/offers/all")
    public String offersAll(Model model) {
        model.addAttribute("offers", offerServiceIfc.getOffers());
        return "offers";
    }

    @GetMapping("/offer/{id}/details")
    public String showDetails(@PathVariable Long id, Model model) {
        model.addAttribute("offerDetails", offerServiceIfc.getOfferDetails(id));

        return "details";
    }

    @DeleteMapping("/offer/{id}")
    public String deleteOffer(@PathVariable Long id) {
        offerServiceIfc.deleteOffer(id);
        return "redirect:/offers/all";
    }

    @GetMapping("/offer/{id}/edit")
    public String offerEdit(@PathVariable Long id, Model model) {
        OfferUpdateBindingModel offerBindingModel=modelMapper.map(offerServiceIfc.getOfferDetails(id),OfferUpdateBindingModel.class);
       offerBindingModel.setEngine(offerServiceIfc.getOfferDetails(id).getEngine())
                       .setTransmission(offerServiceIfc.getOfferDetails(id).getTransmission());
        model.addAttribute("editModel", offerBindingModel);
        model.addAttribute("engines", EngineEnum.values());
        model.addAttribute("transmissions", TransmissionEnum.values());
        return "update";
    }

    @PatchMapping("/offer/{id}/edit")
    public String editOffer(@PathVariable Long id,
                            @Validated OfferUpdateBindingModel updateModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        //todo validation

        OfferUpdateServiceModel updateServiceModel = modelMapper.map(updateModel, OfferUpdateServiceModel.class);
        updateServiceModel.setId(id);
        updateServiceModel.setEngine(updateModel.getEngine())
                        .setTransmission(updateModel.getTransmission());
        offerServiceIfc.updateOffer(updateServiceModel);
        return "redirect:/offer/" + id + "/details";

    }
}
