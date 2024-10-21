package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Media {
    private Long id;
    private byte[] image; // Хранит изображение в байтовом массиве
    private byte[] audio; // Хранит аудиоданные в байтовом массиве
}
