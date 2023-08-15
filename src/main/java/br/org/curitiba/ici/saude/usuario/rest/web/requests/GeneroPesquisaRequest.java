package br.org.curitiba.ici.saude.usuario.rest.web.requests;

import br.org.curitiba.ici.saude.common.ParametrosPesquisaRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class GeneroPesquisaRequest extends ParametrosPesquisaRequest {
  private String dsGenero;
  private String sgGenero;

}
