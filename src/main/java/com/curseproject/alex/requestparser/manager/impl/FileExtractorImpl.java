package com.curseproject.alex.requestparser.manager.impl;

import com.curseproject.alex.requestparser.manager.Extractor;
import com.curseproject.alex.requestparser.model.Info;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class FileExtractorImpl implements Extractor {

    @Override
    public List<Info> extract(Object obj) {
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
                    .setTaskNumber(row.getCell(0).getStringCellValue())
                    .setOptimisticGrade(row.getCell(1).getNumericCellValue())
                    .setPessimisticGrade(row.getCell(2).getNumericCellValue())
                    .setTimeForOneCase(row.getCell(3).getNumericCellValue())
                    .setCaseCount((int) row.getCell(4).getNumericCellValue())
                    .setComplexityCoefficient((int) row.getCell(5).getNumericCellValue())
                    .setIsStandAvailable(Boolean.valueOf(row.getCell(6).getStringCellValue()))
                    .setIsBackDone(Boolean.valueOf(row.getCell(7).getStringCellValue()))
                    .setIsFrontDone(Boolean.valueOf(row.getCell(8).getStringCellValue()))
                    .setIsAllTestersWorkFullDay(Boolean.valueOf(row.getCell(9).getStringCellValue()))
                    .setHasAutotests(Boolean.valueOf(row.getCell(10).getStringCellValue()))
                    .setCheckListTestCount((int) row.getCell(11).getNumericCellValue())
                    .setTestPriority(resolvePriority(row.getCell(12).getStringCellValue()))
                    .setTimeForOneTest(row.getCell(13).getNumericCellValue())
            );
        }
        return result;
    }

    @Override
    public boolean supports(Object obj) {
        return obj instanceof MultipartFile;
    }

    private List<String> resolvePriority(String priority) {
        return Arrays.stream(priority.split(","))
                .filter(Objects::nonNull)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
