package com.mcmanuel.AssesmentApplication.web;

import com.mcmanuel.AssesmentApplication.domain.box.dto.BoxDto;
import com.mcmanuel.AssesmentApplication.domain.box.entity.Item;
import com.mcmanuel.AssesmentApplication.domain.box.service.BoxService;
import com.mcmanuel.AssesmentApplication.domain.pojo.BoxRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boxes")
public class Controller{
    private final BoxService service;

    @PostMapping("/")
    public ResponseEntity<BoxDto> createBox(@Valid @RequestBody BoxRequest boxRequest){
        return new ResponseEntity<>(service.createBox(boxRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{txRef}")
    public ResponseEntity<BoxDto> getBoxByTxRef(@PathVariable String txRef){
        BoxDto boxDto =service.getBoxByTxRef(txRef);
        if (boxDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(boxDto);
    }

    @PostMapping("/load/{txRef}")
    public ResponseEntity<BoxDto> loadBox(@PathVariable String txRef, @RequestBody List<Item> items){
        BoxDto boxDto= service.loadBox(txRef,items);
        if (boxDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(boxDto);
    }

    @PostMapping("/load/{txRef}")
    public ResponseEntity<BoxDto> loadBox(@PathVariable @Valid String txRef,@RequestBody Item items){
        BoxDto boxDto =service.loadBox(txRef,items);
        if (boxDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(boxDto);
    }

    @GetMapping("/{txRef}/items")
    public ResponseEntity<List<Item>> getItmes(String txRef){
        List<Item> boxItems = service.getItems(txRef);
        if (boxItems == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(boxItems);
    }

    @GetMapping("/")
    public ResponseEntity<List<BoxDto>> getAllBoxes(){
        return ResponseEntity.ok(service.getAllBoxes());
    }

    @GetMapping("/available")
    public ResponseEntity<List<BoxDto>> getAvailableBoxes(){
        return ResponseEntity.ok(service.getAvailableBoxes());
    }

    @GetMapping("/{txRef}/battery-level")
    public ResponseEntity<Integer> checkBatteryLevel(String txRef){
        Optional<Integer> batteryLevel = service.checkBatteryLevel(txRef);
        return batteryLevel.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}