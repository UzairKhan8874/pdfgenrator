package com.pdfgeneration.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class Serviceodfgen {

    public ByteArrayInputStream genratePdf() {

        String title = "Spring Boot PDF Generation";
        String summary = "My name is Mohd Uzair Naseem Khan, and I am from Lucknow, India. "
                + "My father’s name is Naseem Khan, and my mother’s name is Fareeda Naseem. "
                + "I am currently a BCA student at Pune University. "
                + "My dream is to become a best Java developer and a full-stack developer.";

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph titlePara = new Paragraph(title, titleFont);
            titlePara.setAlignment(Element.ALIGN_CENTER);
            document.add(titlePara);

            document.add(new Paragraph(" "));

            Font bodyFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Paragraph bodyPara = new Paragraph(summary, bodyFont);
            bodyPara.setAlignment(Element.ALIGN_CENTER);
            document.add(bodyPara);

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
