package br.com.gabrieldeoliveira.msr.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ocorrencias")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ocorrencia {
    
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String descricao;

    @Column(nullable = false)
    private OffsetDateTime dataRegistro;

    @ManyToOne
    @JoinColumn(name = "id_entrega")
    private Entrega entrega;
}
