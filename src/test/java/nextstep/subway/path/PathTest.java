package nextstep.subway.path;

import nextstep.subway.line.domain.Line;
import nextstep.subway.line.domain.Sections;
import nextstep.subway.path.domain.PathFinder;
import nextstep.subway.station.domain.Station;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@DataJpaTest
public class PathTest {
    @Test
    @DisplayName("지하철 최단 경로를 조회한다.")
    void findPathTest() {
        List<Line> lines = new ArrayList<>();
        Line line = new Line("1호선", "red", new Station("소사역"), new Station("역곡역"), 10);
        lines.add(line);
        PathFinder pathFinder = new PathFinder(lines);
        when(pathFinder.findPath(any(), any())).thenReturn(Arrays.asList(1L, 2L, 3L, 4L));
    }
}
