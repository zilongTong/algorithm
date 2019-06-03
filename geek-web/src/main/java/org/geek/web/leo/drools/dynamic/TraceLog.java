package org.geek.web.leo.drools.dynamic;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName TraceLog
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/3/22 15:28
 **/
@Data
public class TraceLog implements Serializable {

    private static final long serialVersionUID = 1L;


    private String status;
    private String join_room_success;
    private String remote_leave;
    private String connection_lost;
    private String remote_audio;
    private String remote_video;
    private String mute_remote_audio;
    private String mute_remote_video;
    private String bad_network;

}