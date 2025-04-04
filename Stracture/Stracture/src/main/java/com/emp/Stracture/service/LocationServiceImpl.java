package com.emp.Stracture.service;

import com.emp.Stracture.Entity.Location;
import com.emp.Stracture.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LocationServiceImpl implements LocationService {

    @Autowired
   LocationRepository locationRepository;

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}