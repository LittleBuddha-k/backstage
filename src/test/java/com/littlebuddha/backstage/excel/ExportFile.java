package com.littlebuddha.backstage.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ck
 * @date 2020/12/25 9:28
 */
@SpringBootTest
public class ExportFile {

    /**
     * poi导出excel最常用的方式；但是此种方式的局限就是导出的行数至多为65535行，超出65536条后系统就会报错。
     * 此方式因为行数不足七万行所以一般不会发生内存不足的情况（OOM）。
     * 这个操作2003以前的excel版本
     */
    HSSFWorkbook hssfWorkbook;

    /**
     * 这种形式的出现是为了突破HSSFWorkbook的65535行局限。其对应的是excel2007(1048576行，16384列)扩展名为“.xlsx”，
     * 最多可以导出104万行，不过这样就伴随着一个问题---OOM内存溢出，原因是你所创建的book sheet row cell等此时是存在内存的并没有持久化。
     * 这个操作2007excel版本
     */
    XSSFWorkbook xssfWorkbook;

    /**
     * 从POI 3.8版本开始，提供了一种基于XSSF的低内存占用的SXSSF方式。对于大型excel文件的创建，一个关键问题就是，要确保不会内存溢出。
     * 其实，就算生成很小的excel（比如几Mb），它用掉的内存是远大于excel文件实际的size的。如果单元格还有各种格式（比如，加粗，背景标红之类的），
     * 那它占用的内存就更多了。对于大型excel的创建且不会内存溢出的，就只有SXSSFWorkbook了。它的原理很简单，用硬盘空间换内存（就像hash map用空间换时间一样）。
     */
    SXSSFWorkbook sxssfWorkbook;

    /**
     * 定义一个sheet工作页
     */
    Sheet sheet;

    @Test
    public void exportFile(){

    }

    @Test
    public void importFile(){

    }
}
