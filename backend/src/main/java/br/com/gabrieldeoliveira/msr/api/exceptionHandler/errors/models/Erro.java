package br.com.gabrieldeoliveira.msr.api.exceptionHandler.errors.models;

import java.io.Serializable;
import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Erro implements Serializable {
    static final long serialVersionUID = 1L;
    
    private OffsetDateTime timestamp;

    private Integer status;

    private String title;
}
