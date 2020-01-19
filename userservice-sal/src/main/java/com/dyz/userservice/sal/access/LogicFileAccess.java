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
     * @return
     */
    public List<Integer> uploadFiles(MultipartFile[] files) {
        log.info("trigger remote service to upload file");
        List<Integer> pictureIds = logicFileClient.uploadFiles(files).getContent();
        return pictureIds;
    }

    /**
     * delete file
     * @param fileIds
     */
    public void deleteLogicFiles(List<Integer> fileIds) {
        log.info("trigger remote service to delete files");
        logicFileClient.deleteLogicFiles(fileIds);
    }
}
