package com.example.project.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import com.example.project.domain.entities.Product;
import com.example.project.domain.entities.Supplier;
import com.example.project.exception.DataNotFoundException;
import com.example.project.repository.ProductRepository;
import com.google.common.collect.Table.Cell;
import com.microsoft.schemas.office.visio.x2012.main.CellType;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.Cleanup;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierService supplierService;
    // private static final String FILE_NAME = "/temp/decola.xlsx";
    private static final String FILE_NAME = "realSpringBoot-master/project/src/main/java/com/example/project/domain/utils/decola.xlsx";

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Product findById(Integer Id) {
        Optional<Product> evento = productRepository.findById(Id);
        return evento.orElseThrow(() -> new DataNotFoundException("Id Not found"));
    }

    public String upload(MultipartFile file, Integer id) {
        String dirName = File.separator + "temp";
        File dir = new File(dirName);

        if (!dir.exists())
            dir.mkdir();

        String filename = file.getOriginalFilename();
        File destFile = new File(dir + File.separator + filename);

        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return destFile.getName();
    }

    public Product putImagem(Integer id, String imagemm) {
        Product p = findById(id);

        p.setImagem(imagemm);
        return productRepository.save(p);
    }

    public List<Product> criar() throws FileNotFoundException {

        List<Product> products = new ArrayList<>();

        // Pegando o Arquivo do excel
        try {
            FileInputStream file = new FileInputStream("src/main/java/com/example/project/domain/utils/decola.xlsx");
            Workbook workbook = new XSSFWorkbook(file);

            // Escolhendo a aba do excel
            Sheet datatypeSheet = workbook.getSheetAt(0);

            // Escolhendo a linha da tabela
            Iterator<Row> rows = datatypeSheet.iterator();

            // Remove linha zero
            rows.next();

            while (rows.hasNext()) {
                Row row = rows.next();
                List<Cell> cells = (List<Cell>) toList(row.cellIterator());
                Supplier s = supplierService.findById((int) cells.get(2).getValue());
                Product produto = Product.builder().id((int) cells.get(0).getValue())
                        .productName((String) cells.get(1).getValue()).supplier(s)
                        .unitPrice((double) cells.get(3).getValue()).packageName((String) cells.get(4).getValue())
                        .isDiscontinued((int) cells.get(5).getValue() == 1).build();

                products.add(produto);
            }

            // rows.forEach(row ->{

            // //Escolhendo as celulas
            // List<Cell> cells = (List<Cell>) toList(row.cellIterator());
            // Product produto = Product.builder()
            // .id((int) cells.get(0).getValue())
            // .productName((String)cells.get(1).getValue())
            // .supplier((int)cells.get(2).getValue())
            // .unitPrice((double)cells.get(3).getValue())
            // .packageName(cells.get(4).getValue())
            // .isDiscontinued(cells.get(5).getValue())
            // .build();

            // products.add(produto);
            // });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<?> toList(Iterator<?> iterator) {
        return IteratorUtils.toList(iterator);
    }

    public void grava(List<Product> products) {
        for(Product p : products){
            System.out.println(p.getProductName());
        }
    }

    // public String excel(Integer id){

    // try {
    // FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
    // Workbook workbook = new XSSFWorkbook(excelFile);
    // Sheet datatypeSheet = workbook.getSheetAt(0);
    // Iterator<Row> iterator = datatypeSheet.iterator();

    // while (iterator.hasNext()) {

    // Row currentRow = iterator.next();
    // Iterator<Cell> cellIterator = currentRow.iterator();

    // while (cellIterator.hasNext()) {

    // Cell currentCell = cellIterator.next();
    // //getCellTypeEnum shown as deprecated for version 3.15
    // //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
    // if (currentCell.getCellTypeEnum() == CellType.STRING) {
    // System.out.print(currentCell.getStringCellValue() + "--");
    // } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
    // System.out.print(currentCell.getNumericCellValue() + "--");
    // }

    // }
    // System.out.println();

    // }
    // } catch (FileNotFoundException e) {
    // e.printStackTrace();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }
}