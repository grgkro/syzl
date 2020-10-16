package de.stuttgart.syzl.service;

import de.stuttgart.syzl.repository.CircleRepository;
import de.stuttgart.syzl.repository.StarShortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarShortService {

    @Autowired
    private StarShortRepository starShortRepository;


}
