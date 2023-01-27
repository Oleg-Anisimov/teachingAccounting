package me.anisimov.teachingAccounting.service;

import me.anisimov.teachingAccounting.domain.BaseEntity;
import me.anisimov.teachingAccounting.util.ReflectionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExportToExcelService {

    public <T extends BaseEntity> void export(String filename, String[] fieldNames, List<T> data) {
        try {
            List<String[]> rows = collectRows(fieldNames, data);
            this.buildExcelFile(filename, fieldNames, rows);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Fantastic situation: declared class field was not found in data-object");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private  <T> List<String[]> collectRows(String[] fieldNames, List<T> data) throws NoSuchFieldException {
        List<String[]> rows = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            String[] row = new String[fieldNames.length];
            for (int j = 0; j < fieldNames.length; j++) {
                String currentFieldName = fieldNames[j];
                try {
                    Object o = ReflectionUtils.diveForField(currentFieldName, data.get(i));
                    if (o != null) {
                        row[j] = o.toString();
                    } else {
                        row[j] = "";
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Can't get access to field [" + currentFieldName + ']');
                }
            }
            rows.add(row);
        }

        return rows;
    }

    private void buildExcelFile(String file, String[] header, List<String[]> rows) throws IOException {
        int rowCounter = 0;
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet();

            Row row = sheet.createRow(rowCounter++);
            this.createRow(header, row);


            for (int i = 0; i < rows.size(); i++) {
                String[] currentData = rows.get(i);
                if (currentData.length != header.length) {
                    throw new IllegalStateException("Illegal row length");
                }
                Row currentRow = sheet.createRow(rowCounter++);
                createRow(currentData, currentRow);
            }

            FileOutputStream stream = new FileOutputStream(file);
            workbook.write(stream);
            workbook.close();
            stream.close();
        }
    }

    private void createRow(String[] data, Row row) {
        for (int i = 0; i < data.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(data[i]);
        }
    }
}
