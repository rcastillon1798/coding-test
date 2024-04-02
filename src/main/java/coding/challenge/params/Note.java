package coding.challenge.params;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Note {

    private static int idCounter = 0;
    private int id;

    @NotBlank(message = "The title is required.")
    private String title;
    private String body;

    public Note() {
        this.id = ++idCounter;
    }
}
