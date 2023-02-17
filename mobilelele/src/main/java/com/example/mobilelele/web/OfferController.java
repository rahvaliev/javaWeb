package com.example.mobilelele.web;

import com.example.mobilelele.model.binding.OfferUpdateBindingModel;
import com.example.mobilelele.model.enums.EngineEnum;
import com.example.mobilelele.model.enums.TransmissionEnum;
import com.example.mobilelele.model.service.OfferUpdateServiceModel;
import com.example.mobilelele.model.view.OfferDetailsView;
import com.example.mobilelele.service.OfferServiceIfc;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
    @ModelAttribute
    public OfferUpdateBindingModel offerUpdateBindingModel(){
        return new OfferUpdateBindingModel();
    }

    @GetMapping("/offer/{id}/edit")
    public String offerEdit(@PathVariable Long id, Model model) {
        OfferDetailsView offerDetailsView=offerServiceIfc.findById(id);
        OfferUpdateBindingModel offerBindingModel=modelMapper.map(offerDetailsView,OfferUpdateBindingModel.class);
        offerBindingModel.setTransmission(offerDetailsView.getTransmission())
                        .setEngine(offerDetailsView.getEngine());

        model.addAttribute("editModel", offerBindingModel);
        return "update";
    }

    @PostMapping("/offer/{id}/edit/errors")
    public String editOffersError(@PathVariable Long id){
        return "update";
    }

    @PatchMapping("/offer/{id}/edit")
    public String editOffer(@PathVariable Long id,
                            @Validated OfferUpdateBindingModel updateModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        //todo validation във bindingresulta трябва да сложим името на редирект флаш атрибут "editModel" а не updateModel!!!


        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("editModel",updateModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.editModel",bindingResult);
            return "redirect:/offer/" + id+"/edit/errors";
        }

        OfferUpdateServiceModel updateServiceModel = modelMapper.map(updateModel, OfferUpdateServiceModel.class);
        updateServiceModel.setId(id);
        updateServiceModel.setEngine(updateModel.getEngine())
                        .setTransmission(updateModel.getTransmission());


        offerServiceIfc.updateOffer(updateServiceModel);
        return "redirect:/offer/" + id + "/details";

    }
}
