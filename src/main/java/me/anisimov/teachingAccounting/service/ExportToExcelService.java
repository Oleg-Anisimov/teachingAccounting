package me.anisimov.teachingAccounting.service;

import lombok.SneakyThrows;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExportToExcelService {
//{{} , {} , {} , {}}
    @SneakyThrows
    public <T> void export(String file, Class<T> tClass, List<T> data) {
        Field[] fields = tClass.getDeclaredFields();
         ;
        String[] headers =Arrays.stream(fields).map(Field::getName).collect(Collectors.toList()).toArray(new String[fields.length]);
        List<String[]> rows = new ArrayList<>();

        for (int i = 0; i<data.size(); i++) {
            T object = data.get(i);
            String[] row = new String[fields.length];
            for (int j = 0; j < fields.length; j++) {
                Field field = object.getClass().getDeclaredField(fields[j].getName());
                field.setAccessible(true);

                Object o = field.get(object);
                if (o != null) {
                    row[j] = o.toString();
                } else {
                    row[j] = "";
                }
            }
            rows.add(row);

        }
        this.export(file, headers, rows);
    }

    private void export(String file, String[] header, List<String[]> rows) throws IOException {
        int rowCounter = 0;
        try (Workbook workbook = new HSSFWorkbook()) {
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

            workbook.write(new FileOutputStream(file));
        }
    }

    private void createRow(String[] data, Row row) {
        for (int i = 0; i < data.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(data[i]);
        }
    }
}
