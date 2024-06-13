package com.example.curriculo.service;

import com.example.curriculo.model.Curriculo;
import com.example.curriculo.repository.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CurriculoService {
    private static final Logger logger = Logger.getLogger(CurriculoService.class.getName());

    @Autowired
    private CurriculoRepository curriculoRepository;

    public Curriculo getCurriculo(Long id) {
        logger.info("Fetching curriculum with ID: " + id);
        Optional<Curriculo> curriculo = curriculoRepository.findById(id);
        if (curriculo.isPresent()) {
            logger.info("Curriculum found: " + curriculo.get());
            return curriculo.get();
        } else {
            logger.warning("Curriculum with ID " + id + " not found");
            return null;
        }
    }

    public Curriculo saveCurriculo(Curriculo curriculo) {
        logger.info("Saving curriculum: " + curriculo);
        return curriculoRepository.save(curriculo);
    }

    public List<Curriculo> getAllCurriculos() {
        logger.info("Fetching all curriculums");
        return curriculoRepository.findAll();
    }
}
