package com.example.casefitmebackend.services.program;

import com.example.casefitmebackend.models.Exercise;
import com.example.casefitmebackend.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface ProgramService extends CrudService<Exercise, Integer> {
}
