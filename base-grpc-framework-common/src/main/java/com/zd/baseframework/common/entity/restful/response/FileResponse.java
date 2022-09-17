package com.zd.baseframework.common.entity.restful.response;

import cn.hutool.core.util.StrUtil;
import com.zd.baseframework.common.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

/**
 * @author liudong
 * @Title: com.zd.baseframework.common.entity.http.FileResponseEntity
 * @Description 用于controller返回文件上传的返回值
 * @date 2022/1/23 7:11 PM
 */
@Slf4j
public class FileResponse {

    public static ResponseEntity responseSuccess(File file) {
        if ( file == null ) {
            log.error("fileObject is null");
            return ResponseEntity.badRequest().build();
        }
        if (!file.isFile() || !file.exists()){
            log.error("fileObject invalid or not exsit");
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().headers(buildHeader(file.getName())).contentLength(file.length()).contentType(MediaType.parseMediaType(Constants.CONTENT_TYPE_STREAM)).body(new FileSystemResource(file));
    }

    public static ResponseEntity responseSuccess(String content, String fileName) {
        if (StrUtil.isEmpty(fileName)) {
            log.error("fileObject is null");
            return ResponseEntity.badRequest().build();
        }

        File file = new File(fileName);
        try( OutputStream os = new FileOutputStream(file) ) {

            os.write(content.getBytes());

        } catch (IOException e) {
            log.error("fileObject IO error");
        }

        return ResponseEntity.ok().headers(buildHeader(file.getName())).contentLength(file.length()).contentType(MediaType.parseMediaType(Constants.CONTENT_TYPE_STREAM)).body(new FileSystemResource(file));
    }

    private static HttpHeaders buildHeader(String fileName){
        HttpHeaders header = new HttpHeaders();
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Content-Disposition", "attachment; filename=" + fileName);
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");
        header.add("Last-Modified", new Date().toString());
        header.add("ETag", String.valueOf(System.currentTimeMillis()));
        return header;
    }
}
