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
        htmlBuilder.append("<html><head><title>Logs</title><style>p {white-space: nowrap;margin: 0;}.DEBUG {color: #006400;}.INFO {color: #0000FF;}.WARN {color: #FFA500;}.ERROR {color: #FF0000;}</style></head><body>");

        htmlBuilder.append("<div><label>Search:</label><input type=\"text\" id=\"searchInput\"></div>");

        htmlBuilder.append("<div style=\"margin: 5px 0;\">");

        Pattern pattern = Pattern.compile("\\b(DEBUG|INFO|WARN|ERROR)\\b");
        int lastEnd = 0;

        String[] lines = logs.split("\n");
        for (String line : lines) {
            Matcher lineMatcher = pattern.matcher(line);
            StringBuffer lineHtml = new StringBuffer();
            while (lineMatcher.find()) {
                int start = lineMatcher.start();
                int end = lineMatcher.end();
                String level = lineMatcher.group(1);
                String colorClass = level.toUpperCase();
                lineHtml.append(line.substring(lastEnd, start));
                lineHtml.append("<span class=\"" + colorClass + "\">[" + level + "]</span>");
                lastEnd = end;
            }
            lineHtml.append(line.substring(lastEnd));
            lastEnd = 0;
            htmlBuilder.append("<p>" + lineHtml.toString() + "</p>\n");
        }

        htmlBuilder.append("</div>");

        htmlBuilder.append("<script>\n" +
                "    const searchInput = document.getElementById('searchInput');\n" +
                "    const logs = document.querySelectorAll('div p');\n" +
                "    const clearBtn = document.getElementById('clear-logs');\n" +
                "\n" +
                "    // Listen for input on the search box\n" +
                "    searchInput.addEventListener('input', filterLogs);\n" +
                "\n" +
                "    function filterLogs() {\n" +
                "        const filterValue = searchInput.value.toLowerCase();\n" +
                "        logs.forEach(log => {\n" +
                "            const logText = log.innerText.toLowerCase();\n" +
                "            if (logText.includes(filterValue)) {\n" +
                "                log.style.display = 'block';\n" +
                "            } else {\n" +
                "                log.style.display = 'none';\n" +
                "            }\n" +
                "        });\n" +
                "    }\n" +
                "</script>");
        
        htmlBuilder.append("</body></html>");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);
        return new ResponseEntity<String>(htmlBuilder.toString(), headers, HttpStatus.OK);
    }

}
