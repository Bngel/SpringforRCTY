package cn.bngel.rcty.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
    private Long id;
    private String title;
    private String text;
    private Integer type;
}
