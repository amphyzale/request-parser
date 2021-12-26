package com.curseproject.alex.requestparser.manager.impl;

import com.curseproject.alex.requestparser.manager.Extractor;
import com.curseproject.alex.requestparser.model.Info;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class FileExtractorImpl implements Extractor {

    @Override
    public Info extract(Object obj) {
        final MultipartFile file = (MultipartFile) obj;
        final XSSFWorkbook book;
        try {
            book = new XSSFWorkbook(file.getInputStream());
        } catch (IOException e) {
            log.error("Something went wrong while processing file: ", e);
            throw new RuntimeException();
        }
        final XSSFSheet sheet = book.getSheetAt(0);
        final Iterator<Row> rowIterator = sheet.rowIterator();
        rowIterator.next();
        final List<Info> result = new LinkedList<>();
        while (rowIterator.hasNext()) {
            final Row row = rowIterator.next();
            result.add(new Info()
                    .setInfo(row.getCell(0).getStringCellValue())
                    .setNum(row.getCell(1).getNumericCellValue())
            );
        }
        return result.get(0);
    }

    @Override
    public boolean supports(Object obj) {
        return obj instanceof MultipartFile;
    }
}
