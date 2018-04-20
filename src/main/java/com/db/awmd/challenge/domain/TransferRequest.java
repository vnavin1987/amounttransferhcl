package com.db.awmd.challenge.domain;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TransferRequest {

	@NotNull
	@NotEmpty
	private final String fromAccountId;
	@NotNull
	@NotEmpty
	private final String toAccountId;
	@NotNull
	@NotEmpty
	private BigDecimal amount;

	@JsonCreator
	public TransferRequest(@JsonProperty("fromAccountId") String fromAccountId,
			@JsonProperty("toAccountId") String toAccountId, @JsonProperty("amount") BigDecimal amount) {
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
	}

}
