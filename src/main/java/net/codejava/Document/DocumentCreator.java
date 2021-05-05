package net.codejava.Document;

import net.codejava.Model.Department;
import net.codejava.Model.Fired;
import net.codejava.Model.Worker;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DocumentCreator {
    String folderPath="D:\\РИС\\WorkerApplication\\src\\main\\resources\\static\\assets\\documents\\";
    public void createDocument(Worker worker) throws IOException {
        String fileName = "document.docx";

        try (XWPFDocument doc = new XWPFDocument()) {

            // create a paragraph
            XWPFParagraph p1 = doc.createParagraph();
            p1.setAlignment(ParagraphAlignment.LEFT);

            // set font
            XWPFRun r1 = p1.createRun();
            r1.setFontSize(14);
            r1.setFontFamily("Times New Roman");
            r1.setText("Белорусский государственный \n университет информатики и \n радиоэлектроники\n\n");
            XWPFParagraph p2 = doc.createParagraph();
            XWPFRun r2 = p2.createRun();
            r2.setBold(true);
            r2.setText("ПРИКАЗ");
            r2.setBold(false);
            XWPFParagraph p3 = doc.createParagraph();
            XWPFRun r3 = p3.createRun();
            r3.setText("" + worker.getEmployDate().getDayOfMonth() + "." + worker.getEmployDate().getMonth() + "." + worker.getEmployDate().getYear());

            try (FileOutputStream out = new FileOutputStream(fileName)) {
                doc.write(out);
            }

        }
    }

    public void createEmployOrder(String input, String output, Worker worker) throws IOException {

        try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(folderPath + input)))
        ) {

            for (XWPFParagraph p : doc.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        if (text != null && text.contains("name")) {
                            text = text.replace("name", worker.getName());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("family")) {
                            text = text.replace("family", worker.getSurname());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("patronymic")) {
                            text = text.replace("patronymic", worker.getPatronymic());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("day")) {
                            text = text.replace("day", String.valueOf(worker.getEmployDate().getDayOfMonth()));
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("month")) {
                            text = text.replace("month", String.valueOf(worker.getEmployDate().getMonthValue()));
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("year")) {
                            text = text.replace("year", String.valueOf(worker.getEmployDate().getYear()));
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("position")) {
                            text = text.replace("position", String.valueOf(worker.getPosition()));
                            r.setText(text, 0);
                        }
                    }
                }
            }

            // save the docs
            try (FileOutputStream out = new FileOutputStream(output)) {
                doc.write(out);
            }

        }

    }
    public void createFireOrder(String input, String output, Worker worker, Fired fired, Department department) throws IOException {

        try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(folderPath + input)))
        ) {

            for (XWPFParagraph p : doc.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        if (text != null && text.contains("name")) {
                            text = text.replace("name", worker.getName());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("family")) {
                            text = text.replace("family", worker.getSurname());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("patronymic")) {
                            text = text.replace("patronymic", worker.getPatronymic());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("day")) {
                            text = text.replace("day", String.valueOf(fired.getDate().getDayOfMonth()));
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("month")) {
                            text = text.replace("month", String.valueOf(fired.getDate().getMonthValue()));
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("year")) {
                            text = text.replace("year", String.valueOf(fired.getDate().getYear()));
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("position")) {
                            text = text.replace("position", String.valueOf(worker.getPosition()));
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("den")) {
                            text = text.replace("den", String.valueOf(worker.getEmployDate().getDayOfMonth()));
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("mec")) {
                            text = text.replace("mec", String.valueOf(worker.getEmployDate().getMonthValue()));
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("god")) {
                            text = text.replace("god", String.valueOf(worker.getEmployDate().getYear()));
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("department")) {
                            text = text.replace("department", department.getName());
                            r.setText(text, 0);
                        }
                    }
                }
            }

            // save the docs
            try (FileOutputStream out = new FileOutputStream(output)) {
                doc.write(out);
            }

        }

    }
}
