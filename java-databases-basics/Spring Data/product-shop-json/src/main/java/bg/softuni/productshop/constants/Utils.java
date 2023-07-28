package bg.softuni.productshop.constants;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public enum Utils {
    ;

    public static final ModelMapper MAPPER = new ModelMapper();

    public static final Gson GSON = new GsonBuilder()
                                            .setPrettyPrinting()
                                            .excludeFieldsWithoutExposeAnnotation()
                                            .create();

    public static <T> void writeIntoJSONFile(List<T> objects, Path path) throws IOException {
        FileWriter fileWriter = new FileWriter(path.toFile());

        GSON.toJson(objects, fileWriter);

        fileWriter.flush();
        fileWriter.close();
    }

    public static <T> void writeIntoJSONFile(T object, Path path) throws IOException {
        FileWriter fileWriter = new FileWriter(path.toFile());

        GSON.toJson(object, fileWriter);

        fileWriter.flush();
        fileWriter.close();
    }
}
