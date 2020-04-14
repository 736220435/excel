package com.springboot.servie.impl;

import com.springboot.dao.ForwardDao;
import com.springboot.dao.ForwardResultDao;
import com.springboot.entity.Forward;
import com.springboot.entity.ForwardResult;
import com.springboot.servie.ForwardService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
public class ForwardServiceImpl implements ForwardService {

    @Autowired
    private ForwardDao forwardDao;

    @Autowired
    private ForwardResultDao forwardResultDao;

    @Override
    public Integer insertForward(MultipartFile multipartFile) {
        // 创建都Excel工作簿文件的引用
        XSSFWorkbook sheets = null;
        Integer integer = 0;
        try {
            sheets = new XSSFWorkbook(multipartFile.getInputStream());
            // 获取Excel工作表总数
            int numberOfSheets = sheets.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                XSSFSheet sheet = sheets.getSheetAt(i);
                for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
                    Forward forward = new Forward();
                    ForwardResult forwardResult = new ForwardResult();
                    for (int k = 1; k < sheet.getRow(j).getPhysicalNumberOfCells() + 1; k++) {
                        DataFormatter dataFormatter = new DataFormatter();
                        String stringCellValue = dataFormatter.formatCellValue(sheet.getRow(j).getCell(k));
                        switch (k) {
                            case 1:
                                forward.setExecutetime(stringCellValue);
                                forwardResult.setEndtime(stringCellValue);
                                forwardResult.setPosttime(stringCellValue);
                                break;
                            case 2:
                                forward.setName(stringCellValue);
                                break;
                            case 3:
                                forward.setUrl(stringCellValue);
                                break;
                            case 4:
                                forward.setTitle(stringCellValue);
                                break;
                            case 5:
                                forwardResult.setWebsite_account(stringCellValue);
                                break;
                        }
                    }
                    forwardDao.insertForward(forward);
                    forwardResult.setMblog_forward_id(forward.getId());
                    integer = forwardResultDao.insertForwardResult(forwardResult);
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return integer;
    }
}