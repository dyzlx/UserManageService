package com.dyz.userservice.sal.access;

import com.dyz.filxeservice.client.LogicFileClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Component
public class LogicFileAccess {

    @Autowired
    private LogicFileClient logicFileClient;

    /**
     * upload file
     * @param files
     * @param userId
     * @return
     */
    public List<Integer> uploadFiles(MultipartFile[] files, Integer userId) {
        log.info("trigger remote service to upload file");
        List<Integer> pictureIds = logicFileClient.uploadFiles(files, userId).getContent();
        return pictureIds;
    }

    /**
     * delete file
     * @param fileIds
     * @param userId
     */
    public void deleteLogicFiles(List<Integer> fileIds, Integer userId) {
        log.info("trigger remote service to delete files");
        logicFileClient.deleteLogicFiles(fileIds, userId);
    }
}
