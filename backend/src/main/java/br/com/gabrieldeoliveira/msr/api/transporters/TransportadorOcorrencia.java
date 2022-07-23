package br.com.gabrieldeoliveira.msr.api.transporters;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.gabrieldeoliveira.msr.api.model.ocorrencia.OcorrenciaDeEntrada;
import br.com.gabrieldeoliveira.msr.api.model.ocorrencia.OcorrenciaResumo;
import br.com.gabrieldeoliveira.msr.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TransportadorOcorrencia {

    private ModelMapper modelMapper;

    public Ocorrencia paraEntidade(OcorrenciaDeEntrada dto) {
        return modelMapper.map(dto, Ocorrencia.class);
    }

    public OcorrenciaResumo paraModeloResumo(Ocorrencia Ocorrencia) {
        return modelMapper.map(Ocorrencia, OcorrenciaResumo.class);
    }

    public List<OcorrenciaResumo> paraListModeloResumo(List<Ocorrencia> Ocorrencias) {
        return Ocorrencias.stream().map(x -> paraModeloResumo(x)).toList();
    }
}
