package utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class readXlsDepo {


    @DataProvider(name = "depo")
        public Object [][][] depoData () {
            try {


            File file = new File(System.getProperty("User.dir") + "\\src\\test\\resources\\testdata\\NewAccountData.xlsx");
            FileInputStream fis = new FileInputStream(file);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheetAt(1);

            //get total number of rows and columns dynamically
            int totalRows = sheet.getLastRowNum();
            System.out.println(totalRows);

            //get total cell count
            Row rowCells = sheet.getRow(0);

            //total columns
            int totalCol = rowCells.getLastCellNum();
            System.out.println(totalCol);

            //format whatever data to be string
            DataFormatter format = new DataFormatter();


            String testData [][][] = new String [totalRows][totalCol][2];

            for(int i = 1; i < totalRows; i++){
                Row row = sheet.getRow(i);
                for (int j = 0; j < totalCol; j++){
                    Cell cell = row.getCell(j);

                    testData[i-1][j][0] = format.formatCellValue(cell);
                    testData[i-1][j][1] = format.formatCellValue(row.getCell(j + 1));

                        System.out.println(testData[i-1][j][0] + " " + testData[i-1][j][1]);
                    }
                }

            return testData;

        } catch (Exception e) {
            e.printStackTrace();
            }

            return null;
    }

}