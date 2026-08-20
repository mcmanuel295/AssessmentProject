package com.mcmanuel.AssesmentApplication.domain.box;

import com.mcmanuel.AssesmentApplication.domain.pojo.BoxRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements ServiceIntf {
    private final Repository repo;

    @Override
    public BoxDto createBox(BoxRequest boxRequest) {
        Optional<BoxEntity> availableBox =  repo.findByTxRef(boxRequest.txRef());

        if (availableBox.isPresent()) {
            throw new RuntimeException("TxRef name already exist");
        }
        BoxEntity box = BoxEntity.builder()
                .txRef(boxRequest.txRef())
                .items(boxRequest.items())
                .cameras(boxRequest.cameras())
                .build();

        box.setBatteryLevel(100);
//       assumed weight if an empty box
        box.setWeight(10);
        box.setBatteryLevel(100);
        box.setState(State.IDLE);

        return DtoMapper.toDto(repo.save(box));
    }

    @Override
    public BoxDto getBoxByTxRef(String txRef) {
        BoxEntity box =repo.findByTxRef(txRef).orElseThrow(  () -> new RuntimeException("Box with reference "+txRef+" not found"));
        return DtoMapper.toDto(box);
    }


//    Load with a list of items
    @Override
    public BoxDto loadBox(String txRef,List<Item> items) {
        BoxEntity box =repo.findByTxRef(txRef).orElseThrow(  () -> new RuntimeException("Box with reference "+txRef+" not found"));
        for(Item eachItem : items){
            loadBox(txRef,eachItem);
        }

        box.setState(State.LOADED);
        return DtoMapper.toDto(box);
    }

//    Load with a single item
    @Override
    public BoxDto loadBox(String txRef, Item item) {
        BoxEntity box =repo.findByTxRef(txRef).orElseThrow(  () -> new RuntimeException("Box with reference "+txRef+" not found"));

        //  checking battery percent before loading
        if (box.getBatteryLevel()< 25) {
            throw new RuntimeException("Unable to load box, battery too low");
        }

        box.setState(State.LOADING);

        if (box.getWeight()+item.getItemWeight() > 500) {
            throw new RuntimeException("weight exceeded");
        }

        box.getItems().add(item);
        box.setWeight(box.getWeight()+item.getItemWeight());

        return DtoMapper.toDto(repo.save(box));
    }

    @Override
    public List<Item> getItems(String boxId) {
        return List.of();
    }

    @Override
    public List<BoxDto> getAllBoxes() {
        return List.of();
    }

    @Override
    public List<BoxDto> getAvailableBoxes() {
        return repo.findAll().stream()
                .filter(box -> (box.getWeight()<500 && box.getBatteryLevel()>25) || box.getState().equals(State.IDLE))
                .map(DtoMapper::toDto)
                .toList();
    }

    @Override
    public Optional<Integer> checkBatteryLevel(String txRef) {
        BoxEntity box =repo.findByTxRef(txRef).orElseThrow(  () -> new RuntimeException("Box with reference "+txRef+" not found"));
        return Optional.of(box.getBatteryLevel());
    }
}