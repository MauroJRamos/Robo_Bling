package com.robo.ancora.guilherme.dto;

import java.io.Serializable;
import java.util.Date;

import com.robo.ancora.guilherme.entities.PostBling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostBlingDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String status_request;
	private String payload_request;
	private Date datRequest;
	
	public  PostBlingDTO(PostBling entity) {
		id = entity.getId();
		status_request = entity.getStatus_request();
		payload_request = entity.getPayload_request();
		datRequest = entity.getDatRequest();
		
	}

}
