package br.com.gabrieldeoliveira.msr.api.exceptionHandler.errors.models;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ErroPadrao extends Erro {

    private String message;

    public ErroPadrao(OffsetDateTime timestamp, Integer status, String title, String message) {
        super(timestamp, status, title);
        this.message = message;
    }
}
