package com.ling5821.javabase.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author aidong
 * @date 2021/8/4 22:58
 */
public class FindAndDeleteFile {
    public static void main(String[] args) throws IOException {

        String dirName = "D:\\Projects\\idea\\iot-platform2";

        //过滤出目录
        try (Stream<Path> paths = Files.walk(Paths.get(dirName))) {
            paths.filter(Files::isDirectory).filter(new Predicate<Path>() {
                @Override
                public boolean test(Path path) {
                    String pathStr = path.toFile().getPath();
                    return !pathStr.contains(".git") && pathStr.contains("jetlinks");
                }
            }).forEach(new Consumer<Path>() {
                @Override
                public void accept(Path path) {
                    String pathStr = path.toFile().getPath();
                    int length = path.getParent().toFile().list().length;
                    if (length == 1) {
                        System.out.println(path);
                        path.toFile().delete();
                        path.getParent().toFile().delete();
                    } else if (length > 1) {
                        System.out.println(path);
                        path.toFile().delete();
                    }
                }
            });
        }
    }
}
