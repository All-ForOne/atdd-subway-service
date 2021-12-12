package nextstep.subway.path.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paths")
public class PathController {
    @GetMapping
    public void paths(@RequestParam("source") int source, @RequestParam("target") int target) {
        return;
    }

}
