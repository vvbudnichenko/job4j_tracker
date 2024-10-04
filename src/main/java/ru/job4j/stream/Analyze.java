package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(subject -> subject.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(subject -> new Tuple(subject.name(), subject.subjects().stream()
                        .mapToInt(Subject::score)
                        .average()
                        .orElse(0D)))
                .toList();
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        Map<String, Double> rsl = stream.flatMap(subject -> subject.subjects().stream())
                .collect(groupingBy(Subject::name, LinkedHashMap::new, Collectors.averagingDouble(Subject::score)));

        return rsl.entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .toList();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(subject -> new Tuple(subject.name(), subject.subjects().stream()
                        .mapToInt(Subject::score)
                        .sum()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(new Tuple("No students", 0D));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        Map<String, Double> rsl = stream.flatMap(subject -> subject.subjects().stream())
                .collect(groupingBy(Subject::name, LinkedHashMap::new, Collectors.summingDouble(Subject::score)));

        return rsl.entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(new Tuple("No subject", 0D));
    }
}