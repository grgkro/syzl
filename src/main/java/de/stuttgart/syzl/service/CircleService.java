package de.stuttgart.syzl.service;

import de.stuttgart.syzl.repository.CircleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CircleService {

    @Autowired
    private CircleRepository circleRepository;


}
