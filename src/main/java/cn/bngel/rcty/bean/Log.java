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
public class Log {
    private Long id;
    private String type;
    private Date createTime;
    private String text;
}
