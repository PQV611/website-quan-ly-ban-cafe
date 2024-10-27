package website.code.coffeeShop.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import website.code.coffeeShop.model.Bill;
import website.code.coffeeShop.model.BillDetail;
import website.code.coffeeShop.model.Users;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelExportService {
    @Autowired
    private UserService userService;

    public ByteArrayInputStream exportBillToExcel(Bill bill, List<BillDetail> billDetails) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Bill and BillDetail");

            Row billHeader = sheet.createRow(0);
            billHeader.createCell(0).setCellValue("Bill Information");

            Row billInfoHeader = sheet.createRow(1);
            billInfoHeader.createCell(0).setCellValue("Bill ID");
            billInfoHeader.createCell(1).setCellValue("Phone");
            billInfoHeader.createCell(2).setCellValue("Address");
            billHeader.createCell(3).setCellValue("Created Time");
            billHeader.createCell(4).setCellValue("Number of Guests");
            billHeader.createCell(5).setCellValue("Total Cost");
            billHeader.createCell(6).setCellValue("Table ID");
            billHeader.createCell(7).setCellValue("User Name");
            billHeader.createCell(8).setCellValue("Status");
            billHeader.createCell(9).setCellValue("Type");

            Row billRow = sheet.createRow(2);
            billRow.createCell(0).setCellValue(bill.getBillId());
            billRow.createCell(1).setCellValue(bill.getPhone());
            billRow.createCell(2).setCellValue(bill.getAddress());
            billRow.createCell(3).setCellValue(bill.getCreatedTime().toString());
            billRow.createCell(4).setCellValue(bill.getNumberOfGuest());
            billRow.createCell(5).setCellValue(bill.getTotalCost());
            billRow.createCell(6).setCellValue(bill.getTableId());

            Users user = userService.findById(bill.getBillId());
            billRow.createCell(7).setCellValue(user.getUsername());

            String statusText = bill.getStatus() == 1 ? "Đã thanh toán" : "Chưa thanh toán";
            billRow.createCell(8).setCellValue(statusText);

            String typeText = bill.getType() == 1 ? "Offline" : "Online";
            billRow.createCell(9).setCellValue(typeText);

            int detailStartRow = 4;
            Row blankRow = sheet.createRow(detailStartRow);
            detailStartRow++;

            Row detailInfoHeader = sheet.createRow(detailStartRow + 1);
            detailInfoHeader.createCell(0).setCellValue("Bill ID");
            detailInfoHeader.createCell(1).setCellValue("Product Name");
            detailInfoHeader.createCell(2).setCellValue("Quantity");
            detailInfoHeader.createCell(3).setCellValue("Price");

            int detailRowNum = detailStartRow + 2;
            for( BillDetail detail : billDetails) {
                Row detailRow = sheet.createRow(detailRowNum++);
                detailRow.createCell(0).setCellValue(detail.getId().getBillId());
                detailRow.createCell(1).setCellValue(detail.getProduct().getPname());
                detailRow.createCell(2).setCellValue(detail.getQuantity());
                detailRow.createCell(3).setCellValue(detail.getPrice());
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}
