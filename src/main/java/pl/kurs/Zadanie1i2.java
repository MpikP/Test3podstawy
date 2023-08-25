package pl.kurs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Zadanie1i2 {
    public static void main(String[] args) {

        String myPath = "C:\\Users\\Magdalena\\IdeaProjects";

        List<File> javaFilesList = new ArrayList<>();
        addJavaFilesToList(new File(myPath), javaFilesList);

        File fileWithTheHighestLength = javaFilesList.stream()
                .max(Comparator.comparing(x -> x.length()))
                .get();
        System.out.println(fileWithTheHighestLength.getName() + " zajmuje " + fileWithTheHighestLength.length() + " miejsca.");
        //ExercisesRunner.java zajmuje 14842 miejsca.


        javaFilesList.stream().map(x -> getNameOfWeekDayFromFile(x))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(System.out::println);
        //FRIDAY=218
        //MONDAY=23
        //SATURDAY=37
        //SUNDAY=21
        //THURSDAY=59
        //TUESDAY=106
        //WEDNESDAY=47

    }

    public static void addJavaFilesToList(File dir, List<File> filesList) {
        if (dir.isDirectory()) {
            File[] filesArray = dir.listFiles();
            for (File file : filesArray) {
                if (file.isDirectory()) {
                    addJavaFilesToList(file, filesList);
                } else if (file.getName().endsWith(".java")) {
                    filesList.add(file);
                }
            }
        } else {
            throw new RuntimeException("Podana ścieżka nie jest folderem");
        }
    }

    public static String getNameOfWeekDayFromFile(File file) {
        try {
            BasicFileAttributes bfa = Files.readAttributes(Path.of(file.getAbsolutePath()), BasicFileAttributes.class);
            if (bfa != null) {
                Instant instant = bfa.creationTime().toInstant();
                LocalDate localDate = LocalDate.ofInstant(instant, ZoneOffset.UTC);
                return localDate.getDayOfWeek().name();
            } else
                return null;
        } catch (IOException e) {
            throw new RuntimeException("Zła ścieżka pliku.");
        }
    }

}
