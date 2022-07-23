package br.com.gabrieldeoliveira.msr.domain.models;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.gabrieldeoliveira.msr.domain.exceptions.RegraNegocioExcecao;
import br.com.gabrieldeoliveira.msr.domain.models.enums.StatusEntrega;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "entregas")
public class Entrega {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private OffsetDateTime dataPedido;

    private OffsetDateTime dataFinalizacao;

    @Enumerated(EnumType.STRING)
    private StatusEntrega status;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Embedded
    private Destinatario destinatario;

    @OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL)
    private List<Ocorrencia> ocorrencias = new ArrayList<>();

    public Entrega(Long id,
            OffsetDateTime dataPedido,
            OffsetDateTime dataFinalizacao,
            StatusEntrega status,
            Cliente cliente) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.dataFinalizacao = dataFinalizacao;
        this.status = status;
        this.cliente = cliente;
    }

    public Ocorrencia adicionarOcorrencia(String descricao) {
        verificarSePodeAdicionarOcorrencia();
        Ocorrencia ocorrencia = new Ocorrencia(null, descricao, OffsetDateTime.now(), this);
        getOcorrencias().add(ocorrencia);
        return ocorrencia;
    }

    private void verificarSePodeAdicionarOcorrencia() {
        if (!entregaPentende()) {
            throw new RegraNegocioExcecao(
                    String.format("Não pode gerar ocorrência. Status de entrega: %s", status.name()));
        }
    }

    public void finalizar() {
        verificarSePodeFinalizar();
        setStatus(StatusEntrega.FINALIZADA);
        setDataFinalizacao(OffsetDateTime.now());
    }

    private void verificarSePodeFinalizar() {
        if (!entregaPentende()) {
            throw new RegraNegocioExcecao(
                    String.format("Entrega não pode ser finalizada. Status de entrega: %s", status.name()));
        }
    }

    public void cancelar() {
        verificarSePodeCancelar();
        setStatus(StatusEntrega.CANCELADA);
        setDataFinalizacao(OffsetDateTime.now());
    }

    private void verificarSePodeCancelar() {
        if (!entregaPentende()) {
            throw new RegraNegocioExcecao(
                    String.format("Entrega não pode ser cancelada. Status de entrega: %s", status.name()));
        }
    }

    private boolean entregaPentende() {
        return getStatus().equals(StatusEntrega.PENDENTE);
    }
}
