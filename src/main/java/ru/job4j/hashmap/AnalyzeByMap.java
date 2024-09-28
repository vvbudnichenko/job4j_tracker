package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double result = 0D;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subjects : pupil.subjects()) {
                result += subjects.score();
            }
            count += pupil.subjects().size();
        }
        return result / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0D;
            int count = pupil.subjects().size();
            for (Subject eachSubject : pupil.subjects()) {
                score += eachSubject.score();
            }
            list.add(new Label(pupil.name(), score / count));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Double> map = new LinkedHashMap<>();
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject eachSubject : pupil.subjects()) {
                map.merge(eachSubject.name(), (double) eachSubject.score(), Double::sum);
            }
        }
        map.forEach((key, value) -> list.add(new Label(key, value / pupils.size())));
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new LinkedList<>();
        for (Pupil pupil : pupils) {
            double score = 0D;
            for (Subject eachSubject : pupil.subjects()) {
                score += eachSubject.score();
            }
            list.add(new Label(pupil.name(), score));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Double> map = new LinkedHashMap<>();
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject eachSubject : pupil.subjects()) {
                map.merge(eachSubject.name(), (double) eachSubject.score(), Double::sum);
            }
            map.forEach((key, value) -> list.add(new Label(key, value)));
        } list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }
}