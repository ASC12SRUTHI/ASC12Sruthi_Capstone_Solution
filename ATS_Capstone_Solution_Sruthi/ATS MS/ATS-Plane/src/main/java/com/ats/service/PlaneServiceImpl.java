package com.ats.service;

import com.ats.entity.PlaneEntity;
import com.ats.model.PlaneModel;
import com.ats.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService{
    private final PlaneRepository planeRepository;
    @Autowired
    public PlaneServiceImpl(PlaneRepository planeRepository){
        this.planeRepository=planeRepository;
    }
    @Override
    public String generateId() {
        String planeId = planeRepository.findTopId();
        if (planeId == null || planeId.isEmpty()) {
            planeId = "PL0000";
        }
        String id="PL";
        int num=Integer.parseInt(planeId.substring(2,6));
        num++;
        String digit=Integer.toString(num);
        switch(4-digit.length()){
            case 1:
                id+="0";
                break;
            case 2:
                id+="00";
                break;
            case 3:
                id+="000";
                break;
            default:
                break;
        }
        id+=digit;
        return id;
    }

    @Override
    public List<PlaneModel> getAllPlane() {
        List<PlaneEntity> allPlanes=planeRepository.findAll();
        List<PlaneModel> planeList=new ArrayList<>();
        for(PlaneEntity planeEntity:allPlanes){
            PlaneModel planeModel=new PlaneModel(planeEntity.getId(),planeEntity.getPlaneMaker(),planeEntity.getModel(),planeEntity.getSeatingCapacity());
            planeList.add(planeModel);
        }
        return planeList;
    }
}

