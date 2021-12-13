package nextstep.subway.path.domain;

import nextstep.subway.line.domain.Line;
import nextstep.subway.line.domain.Section;
import nextstep.subway.station.domain.Station;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;
import java.util.stream.Collectors;

public class PathFinder {
    private List<Line> lines;

    public PathFinder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Long> findPath(int source, int target) {
        WeightedMultigraph<Long, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        List<Station> stations = getStations();
        for (Station station : stations) {
            graph.addVertex(station.getId());
        }
        List<Section> sections = getSections();
        for (Section section : sections) {
            graph.setEdgeWeight(graph.addEdge(section.getUpStation().getId(), section.getDownStation().getId()), section.getDistance());
        }

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(Long.valueOf(source), Long.valueOf(target)).getVertexList();
    }

    private List<Section> getSections() {
        return lines.stream()
                .flatMap(line -> line.getSections().getSections().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Station> getStations() {
        return lines.stream()
                .flatMap(line -> line.getStations().stream())
                .distinct()
                .collect(Collectors.toList());
    }
}
