package com.littlebuddha.backstage.common.excel;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * 支持对xml，xmls读写操作
 * @author ck
 * @date 2020/12/16 15:06
 */
public class ImportExcel {

    Workbook wb;//指定excel文件
    Sheet sheet;//excel文件中的sheet页
    Row row;//sheet页对应的行号

    /**
     * 标题行号
     */
    private int headerNum;

    public ImportExcel(MultipartFile multipartFile, int headerNum, int sheetIndex) throws IOException, InvalidFormatException {
        this(multipartFile.getOriginalFilename(), multipartFile.getInputStream(), headerNum, sheetIndex);
    }

    public ImportExcel(String fileName, InputStream is, int headerNum, int sheetIndex)
            throws InvalidFormatException, IOException {
        if (StringUtils.isBlank(fileName)){
            throw new RuntimeException("导入文档为空!");
        }else if(fileName.toLowerCase().endsWith("xls")){
            this.wb = new HSSFWorkbook(is);
        }else if(fileName.toLowerCase().endsWith("xlsx")){
            this.wb = new XSSFWorkbook(is);
        }else{
            throw new RuntimeException("文档格式不正确!");
        }
        if (this.wb.getNumberOfSheets()<sheetIndex){
            throw new RuntimeException("文档中没有工作表!");
        }
        this.sheet = this.wb.getSheetAt(sheetIndex);
        this.headerNum = headerNum;
    }


}
