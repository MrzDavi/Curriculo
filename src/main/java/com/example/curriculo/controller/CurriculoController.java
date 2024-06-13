package com.example.curriculo.controller;

import com.example.curriculo.model.Curriculo;
import com.example.curriculo.service.CurriculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/curriculo")
public class CurriculoController {
    private static final Logger logger = Logger.getLogger(CurriculoController.class.getName());
    private final CurriculoService curriculoService;

    public CurriculoController(CurriculoService curriculoService) {
        this.curriculoService = curriculoService;
    }

    @GetMapping("/{id}")
    public Curriculo getCurriculo(@PathVariable Long id) {
        logger.info("Received request to fetch curriculum with ID: " + id);
        return curriculoService.getCurriculo(id);
    }

    @PostMapping
    public Curriculo saveCurriculo(@RequestBody Curriculo curriculo) {
        logger.info("Received request to save curriculum: " + curriculo);
        return curriculoService.saveCurriculo(curriculo);
    }

    @GetMapping
    public List<Curriculo> getAllCurriculos() {
        logger.info("Received request to fetch all curriculums");
        return curriculoService.getAllCurriculos();
    }
}
