package com.pwfz.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Service
public interface UploadfileService {
    String sendfile(MultipartFile file, String packagename, HttpServletRequest request) throws IOException;
}
