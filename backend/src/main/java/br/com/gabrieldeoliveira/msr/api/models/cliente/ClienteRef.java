package br.com.gabrieldeoliveira.msr.api.models.cliente;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteRef implements Serializable {
    static final long serialVersionUID = 1L;

    @NotNull
    private Long id;
}
