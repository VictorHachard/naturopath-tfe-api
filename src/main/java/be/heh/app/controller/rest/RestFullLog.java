package be.heh.app.controller.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/logs")
public class RestFullLog {

    @Value("${logging.file.name}")
    private String file_name;

    @ResponseBody
    @GetMapping("")
    public ResponseEntity<String> getLogs() throws IOException {
        Path logFile = Paths.get(this.file_name);
        List<String> allLines = Files.readAllLines(logFile);
        int file_start = Math.max(0, allLines.size() - 500);
        List<String> last500Lines = allLines.subList(file_start, allLines.size());
        Collections.reverse(last500Lines);
        String logs = String.join(System.lineSeparator(), last500Lines);
         // Reverse the order of lines

        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html>");
        htmlBuilder.append("<head>");
        htmlBuilder.append("<title>Logs</title>");
        htmlBuilder.append("<style>");
        htmlBuilder.append(".DEBUG {color: #006400;}");
        htmlBuilder.append(".INFO {color: #0000FF;}");
        htmlBuilder.append(".WARN {color: #FFA500;}");
        htmlBuilder.append(".ERROR {color: #FF0000;}");
        htmlBuilder.append("</style>");
        htmlBuilder.append("</head>");
        htmlBuilder.append("<body>");
        htmlBuilder.append("<pre>");

        Pattern pattern = Pattern.compile("\\b(DEBUG|INFO|WARN|ERROR)\\b");
        Matcher matcher = pattern.matcher(logs);
        int lastEnd = 0;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String level = matcher.group(1);
            String colorClass = level.toUpperCase();
            htmlBuilder.append(logs.substring(lastEnd, start));
            htmlBuilder.append("<span class=\"" + colorClass + "\">[" + level + "]</span>");
            lastEnd = end;
        }
        htmlBuilder.append(logs.substring(lastEnd));

        htmlBuilder.append("</pre>");
        htmlBuilder.append("</body>");
        htmlBuilder.append("</html>");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);
        return new ResponseEntity<String>(htmlBuilder.toString(), headers, HttpStatus.OK);
    }

}
