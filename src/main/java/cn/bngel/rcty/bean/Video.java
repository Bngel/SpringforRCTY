package cn.bngel.rcty.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    private Long id;
    private String videoName;
    private String videoType;
    private String url;
    private Double videoSize;
    private Date createTime;

}
