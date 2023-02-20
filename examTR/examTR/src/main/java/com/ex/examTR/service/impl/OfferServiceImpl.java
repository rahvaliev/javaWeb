package com.ex.examTR.service.impl;

import com.ex.examTR.model.entity.Offer;
import com.ex.examTR.model.service.OfferServiceModel;
import com.ex.examTR.model.view.OfferViewModel;
import com.ex.examTR.repository.OfferRepository;
import com.ex.examTR.service.ConditionService;
import com.ex.examTR.service.OfferService;
import com.ex.examTR.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ConditionService conditionService;
    private final UserService userService;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ConditionService conditionService, UserService userService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.conditionService = conditionService;
        this.userService = userService;
    }

    @Override
    public void save(OfferServiceModel offerServiceModel) {
        Offer offer=modelMapper.map(offerServiceModel,Offer.class);
        offer.setUser(userService.findById());
        offer.setCondition(conditionService.findByConditionName(offerServiceModel.getCondition()));

        offerRepository.save(offer);

    }

    @Override
    public List<OfferViewModel> myOffers() {

        return offerRepository.findAllByUser_IdOrderByPrice(userService.findCurrentUserId())
                .stream()
                .map(offer -> {
                    OfferViewModel offerViewModel=modelMapper.map(offer,OfferViewModel.class);
                        offerViewModel.setCondition(offer.getCondition().getName());
                        offerViewModel.setUsername(userService.currentUsername());
                    return offerViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<OfferViewModel> allOthersOffer() {
        return offerRepository.findAllByUser_IdNotAndAndBoughtByNull(userService.findCurrentUserId())
                .stream()
                .map(offer -> {
                    OfferViewModel offerViewModel=modelMapper.map(offer,OfferViewModel.class);
                    offerViewModel.setCondition(offer.getCondition().getName());
                    offerViewModel.setUsername(offer.getUser().getUsername());
                    return offerViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<OfferViewModel> myBoughtItems() {
        return offerRepository.findAllByBoughtBy(userService.findCurrentUserId())
                .stream()
                .map(offer -> {
                    OfferViewModel offerViewModel=modelMapper.map(offer,OfferViewModel.class);
                    return offerViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void removeOfferById(Long id) {
        offerRepository.deleteById(id);
    }

    @Override
    public void BuyById(Long id) {
        Offer offerBuy = offerRepository.findById(id).orElse(null);
        offerBuy.setBoughtBy(userService.findCurrentUserId());
        offerBuy.setUser(userService.findByAdminId());
        offerRepository.save(offerBuy);
    }
}
