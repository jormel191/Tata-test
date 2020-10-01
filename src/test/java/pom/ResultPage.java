package pom;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileOutputStream;
import java.util.List;


public class ResultPage extends BasePage {

    private String resultTitlePage = "Compare Lenovo B40-80 vs Lenovo E41-80 - Lenovo B40-80 vs Lenovo E41-80 Comparison by Price, Specifications, Reviews & Features | Gadgets Now";


    public ResultPage(WebDriver driver) {
        super(driver);

    }


    public boolean resultPageIsDisplayed() throws Exception {

        return this.getTitle().equals(resultTitlePage);
    }


    public void writeExcel() throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "Hoja excel");

        String[] headers = new String[]{
                "SUMMARY"

        };

        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        HSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; ++i) {
            String header = headers[i];
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellStyle(headerStyle);
            cell.setCellValue(header);
        }


        WebElement tableList = driver.findElement(By.className("inr_tbl"));
        List<WebElement> TitleTable = tableList.findElements(By.className("title"));
        List<WebElement> valeTable = tableList.findElements(By.className("val"));

        for (int i = 0; i < TitleTable.size(); i++) {
            HSSFRow dataRow = sheet.createRow(i + 1);
            dataRow.createCell(0).setCellValue(TitleTable.get(i).getText());
            dataRow.createCell(1).setCellValue(valeTable.get(i * 4).getText());
            dataRow.createCell(2).setCellValue(valeTable.get(i * 4 + 1).getText());

        }

        FileOutputStream file = new FileOutputStream("data.xls");

        workbook.write(file);
        file.close();
    }
}

