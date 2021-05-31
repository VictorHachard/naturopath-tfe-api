package be.heh.app.controller.rest;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.support.ServletContextResource;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1/resource/")
public class RestFullController {

    @ResponseBody
    @RequestMapping(value = "{url}", method = RequestMethod.GET)
    public ResponseEntity<FileSystemResource> getImageAsResource(@PathVariable("url") String url) {
        FileSystemResource res = new FileSystemResource("C:/tfe-images/" + url);
        return new ResponseEntity<FileSystemResource>(res, HttpStatus.CREATED);
    }

}
