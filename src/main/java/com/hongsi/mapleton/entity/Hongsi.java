package com.hongsi.mapleton.entity;

import com.hongsi.mapleton.dto.RequestDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "hongsi")
@NoArgsConstructor
public class Hongsi {

    @Id @GeneratedValue
    @Column(name = "hongsi_id")
    private Long id;

    private String title;
    private Long currentParticipant;
    private Long maxParticipant;
    private String content;
    private String startDate;
    private String endDate;
    private String hongsi_status; //before, during(사람꽉참), completed-> 시간 단위 : String -> Date Type으로 바꿈
    private String success_status; //success, fail -> 유저마다 필요
    private String writer;
    private String image;
    private String deleteImage;
    private String category;

    @OneToMany(mappedBy = "hongsi", cascade = CascadeType.PERSIST)
    private List<UserConHongsi> userList = new ArrayList<>();

    @OneToMany(mappedBy = "hongsi", cascade = CascadeType.PERSIST)
    private List<Board> boardList = new ArrayList<>();

    public Hongsi (RequestDto requestDto){
        this.title = requestDto.getTitle();
        this.currentParticipant = requestDto.getCurrentParticipant();
        this.maxParticipant = requestDto.getMaxParticipant();
        this.content = requestDto.getContent();
        this.startDate = requestDto.getStartDate();
        this.endDate = requestDto.getEndDate();
        this.writer = requestDto.getWriter();
    }
}
