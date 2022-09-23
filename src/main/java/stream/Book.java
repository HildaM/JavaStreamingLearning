package stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode          // 用于后期的去重使用
public class Book {
    private Long id;
    private String name;
    private String category;
    private Integer score;
    private String intro;
}
