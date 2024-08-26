package com.ats.service;

import com.ats.model.AdministratorModel;

import java.util.List;

public interface AdministratorService {
        String newAdministrator(AdministratorModel administratorModel);
        List<AdministratorModel>getAllAdministrator();
        AdministratorModel getAdministratorById(Long id);
    }
