package com.ats.service;

import com.ats.model.PlaneModel;

import java.util.List;

public interface PlaneService {
    String generateId();
    List<PlaneModel> getAllPlane();
}
