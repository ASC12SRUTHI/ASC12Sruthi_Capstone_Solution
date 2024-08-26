package com.ats.controller;

import com.ats.exception.PlaneNotFoundException;
import com.ats.entity.PlaneEntity;
import com.ats.model.PlaneModel;
import com.ats.repository.PlaneRepository;
import com.ats.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api")
    public class PlaneController {
        private final PlaneRepository planeRepository;
        private final PlaneService planeService;
        @Autowired
        public PlaneController(PlaneRepository planeRepository,PlaneService planeService){
            this.planeRepository=planeRepository;
            this.planeService=planeService;
        }
        @GetMapping("/plane")
        public List<PlaneModel> getAllPlane(){
            return planeService.getAllPlane();
        }
        @GetMapping("/plane/{plId}")
        public PlaneModel getPlaneDetails(@PathVariable(value = "plId") String planeId){
            try{
                PlaneEntity planeDetails=planeRepository.findById(planeId).get();
                return new PlaneModel(planeDetails.getId(),planeDetails.getPlaneMaker(),planeDetails.getModel(),planeDetails.getSeatingCapacity());
            }
            catch(PlaneNotFoundException planeNotFoundException){
                return null;
            }
        }
        @PostMapping("/plane")
        public String insertPlaneDetails(@RequestBody PlaneModel planeInfo){
            if(planeInfo.getPlaneMaker()==null||planeInfo.getModel()==null||planeInfo.getSeatingCapacity()<=0||planeInfo.getPlaneMaker().isEmpty()||planeInfo.getModel().isEmpty()){
                return "Please provide the required details";
            }
            String planeId=planeService.generateId();
            PlaneEntity planeDetails=new PlaneEntity(planeId,planeInfo.getPlaneMaker(),planeInfo.getModel(),planeInfo.getSeatingCapacity());
            planeRepository.save(planeDetails);
            return "Plane Details inserted successfully";
        }
        @DeleteMapping("/plane/{plId}")
        public String deletePlaneDetails(@PathVariable(value = "plId") String planeId){
            try{
                PlaneEntity planeDetailsToBeDeleted=planeRepository.findById(planeId).get();
                planeRepository.delete(planeDetailsToBeDeleted);
                return "Plane Details deleted successfully";
            }
            catch(PlaneNotFoundException planeNotFoundException){
                return "Plane Details is not available";
            }
        }
        @PutMapping("/plane")
        public String updatePlaneDetails(@RequestBody PlaneModel planeInfo){
            try{
                PlaneEntity planeDetailsToBeUpdated=planeRepository.findById(planeInfo.getId()).get();
                if(planeInfo.getPlaneMaker()!=null&&!planeInfo.getPlaneMaker().isEmpty())planeDetailsToBeUpdated.setPlaneMaker(planeInfo.getPlaneMaker());
                if(planeInfo.getModel()!=null&&!planeInfo.getModel().isEmpty()) planeDetailsToBeUpdated.setModel(planeInfo.getModel());
                    if(planeInfo.getSeatingCapacity()>0){
                        planeDetailsToBeUpdated.setSeatingCapacity(planeInfo.getSeatingCapacity());
                    }
                planeRepository.save(planeDetailsToBeUpdated);
                return "Plane Details updated successfully";
            }
            catch(PlaneNotFoundException planeNotFoundException){
                return "Plane Details not updated for the provided Plane Id";
            }
        }
    }
