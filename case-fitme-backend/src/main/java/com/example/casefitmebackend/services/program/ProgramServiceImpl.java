package com.example.casefitmebackend.services.program;

import com.example.casefitmebackend.exceptions.ProgramNotFoundException;
import com.example.casefitmebackend.models.Program;
import com.example.casefitmebackend.repositories.ProgramRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Fully functioning ServiceImpl. Use this as template
 */
@Service
public class ProgramServiceImpl implements ProgramService {
    private ProgramRepository profileRepository;

    public ProgramServiceImpl(ProgramRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Program findById(Integer id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new ProgramNotFoundException(id));
    }

    @Override
    public Collection<Program> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Program add(Program entity) {
        return profileRepository.save(entity);
    }

    @Override
    public Program update(Program entity) {
        return profileRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        profileRepository.deleteById(id);
    }
}
