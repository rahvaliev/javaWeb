package com.example.mobilelele.service.impl;

import com.example.mobilelele.model.entity.ModelEntity;
import com.example.mobilelele.model.entity.OfferEntity;
import com.example.mobilelele.model.entity.UserEntity;
import com.example.mobilelele.model.enums.EngineEnum;
import com.example.mobilelele.model.enums.TransmissionEnum;
import com.example.mobilelele.model.service.OfferUpdateServiceModel;
import com.example.mobilelele.model.view.OfferDetailsView;
import com.example.mobilelele.model.view.OfferSummaryView;
import com.example.mobilelele.repository.ModelRepository;
import com.example.mobilelele.repository.OfferRepository;
import com.example.mobilelele.repository.UserRepository;
import com.example.mobilelele.service.OfferServiceIfc;
import com.example.mobilelele.web.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceIfcImpl implements OfferServiceIfc {
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public OfferServiceIfcImpl(OfferRepository offerRepository, UserRepository userRepository, ModelRepository modelRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public void initializeOffer() {
        if(offerRepository.count()==0) {
            UserEntity pesho = userRepository.findByUsername("pesho").orElse(null);
            ModelEntity model = modelRepository.findById(1l).orElse(null);
            OfferEntity offerEntity = new OfferEntity();
            offerEntity.setDescription("Kacvash se i karash")
                    .setEngine(EngineEnum.DIESEL)
                    .setTransmission(TransmissionEnum.AUTOMATIC)
                    .setImageUrl("https://www.motopfohe.bg/files/news/archive/2017/08/blob-server.jpg")
                    .setMileage(80000)
                    .setModel(model)
                    .setPrice(15000)
                    .setYear(2015)
                    .setSeller(pesho);

            offerRepository.save(offerEntity);
        }
    }

    @Override
    public List<OfferSummaryView> getOffers() {

     return offerRepository.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    @Override
    public OfferDetailsView getOfferDetails(Long id) {
        OfferEntity offerEntity=offerRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("object not found!"));
        OfferDetailsView detailsView=modelMapper.map(offerEntity,OfferDetailsView.class);
        detailsView.setEngine(offerEntity.getEngine());
        detailsView.setTransmission(offerEntity.getTransmission());
        detailsView.setModel(offerEntity.getModel().getBrand().getName() + " " + offerEntity.getModel().getName());
        detailsView.setSeller(offerEntity.getSeller().getFirstName()+" "+offerEntity.getSeller().getLastName());
        detailsView.setModified(LocalDateTime.now());
        return detailsView;
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }

    @Override
    public void updateOffer(OfferUpdateServiceModel serviceModel) {
        OfferEntity offerEntity=offerRepository.findById(serviceModel.getId()).orElseThrow(() -> new ObjectNotFoundException(
                "Offer with id:"+ serviceModel.getId() + "not found!"));
     offerEntity.setPrice(serviceModel.getPrice())
//             .setEngine(serviceModel.getEngine())
//             .setTransmission(serviceModel.getTransmission())
             .setDescription(serviceModel.getDescription())
             .setImageUrl(serviceModel.getImageUrl())
             .setYear(serviceModel.getYear())
             .setMileage(serviceModel.getMileage())
             .setModified(LocalDateTime.now());

        offerRepository.save(offerEntity);


    }

    @Override
    public OfferDetailsView findById(Long id) {

        OfferDetailsView detailsView=modelMapper.map(offerRepository.findById(id),OfferDetailsView.class);
        detailsView.setTransmission(offerRepository.findById(id).get().getTransmission());
        detailsView.setEngine(offerRepository.findById(id).get().getEngine());
        detailsView.setSeller(offerRepository.findById(id).get().getSeller().getFirstName());
        detailsView.setModel(offerRepository.findById(id).get().getModel().getName());
        return detailsView;
    }


    private OfferSummaryView map(OfferEntity offerEntity) {
        OfferSummaryView summaryView=modelMapper.map(offerEntity,OfferSummaryView.class);
        summaryView.setModel(offerEntity.getModel().getName());
        return summaryView;
    }
}
