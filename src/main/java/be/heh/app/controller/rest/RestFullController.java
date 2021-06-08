package be.heh.app.controller.rest;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1/resource/")
public class RestFullController {

    @ResponseBody
    @RequestMapping(value = "{url}", method = RequestMethod.GET)
    public ResponseEntity<FileSystemResource> getImageAsResource(@PathVariable("url") String url) {
        FileSystemResource res = new FileSystemResource("C:/tfe-images/" + url);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

}
