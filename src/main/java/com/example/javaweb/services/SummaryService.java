package com.example.javaweb.services;

import com.example.javaweb.models.Material;
import com.example.javaweb.models.Summary;
import com.example.javaweb.models.SummaryItem;
import com.example.javaweb.repositories.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class SummaryService {

    @Autowired
    private MaterialService materialService;
    @Autowired
    private SummaryRepository summaryRepository;


    public Summary addToSummaryFirstTime(Integer id, String sessionToken, int quantity) {
        Summary summary = new Summary();
        SummaryItem summaryItem = new SummaryItem();
        summaryItem.setQuantity(quantity);
        summaryItem.setMaterial(materialService.getMaterialById(id));
        summary.getItems().add(summaryItem);
        summary.setSessionToken(sessionToken);
        return summaryRepository.save(summary);
    }

    public Summary addToExcistingSummary(Integer id, String sessionToken, int quantity){
        Summary summary = summaryRepository.findBySessionToken(sessionToken);
        Material material = materialService.getMaterialById(id);
        Boolean materialDoesNotExist = false;

        if(summary != null){
            Collection<SummaryItem> items = summary.getItems();
            for(SummaryItem item : items){
                if(item.getMaterial().equals(material)){
                    materialDoesNotExist = true;
                    item.setQuantity(item.getQuantity() + quantity);
                    summary.setItems(items);
                    return summaryRepository.saveAndFlush(summary);
                }
            }
        }
        if(!materialDoesNotExist && (summary != null)) {
            SummaryItem summaryItem1 = new SummaryItem();
            summaryItem1.setQuantity(quantity);
            summaryItem1.setMaterial(material);
            summary.getItems().add(summaryItem1);
            return summaryRepository.saveAndFlush(summary);
        }
        return this.addToSummaryFirstTime(id, sessionToken, quantity);
    }
}
