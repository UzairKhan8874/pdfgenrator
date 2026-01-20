package com.pdfgeneration.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdfgeneration.service.Serviceodfgen;

@RestController
public class PdfController {

    @Autowired
    private Serviceodfgen service;

    @GetMapping("/pdf")
    public ResponseEntity<InputStreamResource> generatePdf() {

        ByteArrayInputStream pdf = service.genratePdf();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=demo.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }
}
